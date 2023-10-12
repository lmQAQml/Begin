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

##3. 索引覆盖
```
    select id，name
    from table
    where name = 'xx'
    
    这里的SQL只需要找到id，name两个字段，当通过字符串xx找到主键索引key（id）时，等于找全了所需字段，
    此时直接返回即可，不需要从聚簇索引查询其他任何数据，这就是索引覆盖
```