## 1. 聚簇索引和非聚簇索引
```
    聚簇索引: 叶子节点存放索引和数据
    非聚簇索引： 叶子节点存放索引的key值
```

## 2. 回表
```
    select *
    from table
    where name = 'xx'
    
    索引有：id，name
    流程：1.通过name字段索引找到字符串xx对应主键索引key
         2.再通过key在主键索引树找到其他数据
    走了两颗B+树，这种现象就是回表
```

## 3. 索引覆盖
```
    select id，name
    from table
    where name = 'xx'
    
    这里的SQL只需要找到id，name两个字段，当通过字符串xx找到主键索引key（id）时，等于找全了所需字段，
    此时直接返回即可，不需要从聚簇索引查询其他任何数据，这就是索引覆盖
```

## 4.索引下推
```
    mysql三层架构：client、server、存储引擎
    select * from table where name = 'xx' and age = 10
    没有索引下推前：现根据name从索引引擎获取符合条件的数据，再到server层对age进行过滤
    有索引下推： 根据name，age两个条件从存储引擎中获取对应数据
    索引下推作用: 原来在server层做的计算放到存储引擎计算了，减少了server层和存储引擎层的数据交互
```