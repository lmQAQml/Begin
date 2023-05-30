#索引的优化/如何避免索引失效

## 1、最佳左前缀法则
    如果索引了多列，要遵守最左前缀法则，指的是查询从索引的最左前列开始并且不跳过索引中的列。
    Mysql查询优化器会对查询的字段进行改进，判断查询的字段以哪种形式组合能使得查询更快，所有比如创建的是(a,b)索引，查询的是(b,a)，
    查询优化器会修改成(a,b)后使用索引查询。

## 2、不在索引列上做任何操作
    1）计算: 对索引进行表达式计算会导致索引失效，
        如 where id + 1 = 10，可以转换成 where id = 10 -1，这样就可以走索引

    2）函数：select * from t_user where length(name)=6; 
        此语句对字段使用到了函数，会导致索引失效

        从 MySQL 8.0 开始，索引特性增加了函数索引，即可以针对函数计算后的值建立一个索引，也就是说该索引的值是函数计算后的值，所以就可以通过扫描索引来查询数据。
        alter table 't_user' add key idx_name_length ((length(name)));

    3) 字符串类型必须带''引号才能使索引生效
        如select * from user where phone = 13030303030。
        Mysql 在执行上述语句时，会把字段转换为数字再进行比较 select * from user where CAST(phone AS signed int) = 13030303030; 
        CAST 函数是作用在了 phone 字段，而 phone 字段是索引，也就是对索引使用了函数！所以索引失效。

## 3、存储引擎不能使用索引中范围条件右边的列
    如这样的sql: select * from user where username='123' and age>20 and phone='1390012345',
    其中username, age, phone都有索引，只有username和age会生效，处于范围条件右边的phone索引不会生效。

## 4、尽量使用覆盖索引（只访问索引的查询（索引列和查询列一致））
    如select age from user，减少select *
    查出来的列尽量是有索引的列

## 5、mysql在使用负向查询条件(!=、<>、not in、not exists、not like)的时候无法使用索引会导致全表扫描。
    平衡树原理，左子树<根节点<右子树,
    若where条件是!=、not in 等类似负向查询条件索引将无法生效，便会全表扫描
    
## 6、like 以通配符开头(%abc..)时，mysql索引失效会变成全表扫描的操作。
    1) 所以最好用右边like ‘abc%’。如果两边都要用，可以用select username from user where username like '%abc%'，
        其中username是必须是索引列，才可让索引生效

    2) 假如index(a,b,c), where a=3 and b like ‘abc%’ and c=4，a能用，b能用，c不能用，类似于不能使用范围条件右边的列的索引

    3) 对于一棵B+树索引来讲，如果根节点是字符def，假如查询条件的通配符在后面，例如abc%，则其知道应该搜索左子树，
        假如传入为efg%，则应该搜索右子树，如果通配符在前面%abc，则数据库不知道应该走哪一面，就都扫描一遍了。

## 7、少用or，在 WHERE 子句中，如果在 OR 前的条件列是索引列，而在 OR 后的条件列不是索引列，那么索引会失效。
    select * from t_user where id = 1 or age = 18;
    id有索引，age没有，此时没法走索引
    必须要or前后的字段都有索引，查询才能使用上索引（分别使用，最后合并结果type = index_merge）

## 8、在组合/联合索引中，将有区分度的索引放在前面
    如果没有区分度，例如用性别，相当于把整个大表分成两部分，查找数据还是需要遍历半个表才能找到，使得索引失去了意义。
    
## 9、使用前缀索引
    短索引不仅可以提高查询性能而且可以节省磁盘空间和I/O操作，减少索引文件的维护开销，
        但缺点是不能用于 ORDER BY 和 GROUP BY 操作，也不能用于覆盖索引。

    比如有一个varchar(255)的列，如果该列在前10个或20个字符内，可以做到既使前缀索引的区分度接近全列索引，
        那么就不要对整个列进行索引。为了减少key_len，可以考虑创建前缀索引，即指定一个前缀长度，
        可以使用count(distinct leftIndex(列名, 索引长度))/count(*) 来计算前缀索引的区分度。

## 10、explain 中的 type：至少要达到 range 级别，要求是 ref 级别，如果可以是 consts 最好
    consts：单表中最多只有一个匹配行（主键或者唯一索引），在优化阶段即可读取到数据。
    ref：使用普通的索引
    range：对索引进行范围检索
    当 type=index 时，索引物理文件全扫，速度非常慢。