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
    