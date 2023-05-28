# 1、避免子查询
    MySQL5.5版本 内部执行计划先查外表后查内表，若外表数据量过大，查询速度会很慢

    可使用join优化

# 2、用IN替换OR
    IN中的常量全部储存于数组中（优先排好序会进一步提升效率），二分查找去筛选满足条件（O(log n)）, OR的时间复杂度为O（n）

# 3、读取适量的记录 LIMIT m,n
    

# 4、禁止不必要的order by排序
    group by 会默认排序，可使用 group by xxx order by null 禁止排序

# 5、注意union all 的使用
    union 和 union all 的区别在于union all 会把结果集排序再去重操作  
    仅确定不会出现重复数据才能使用union all

# 6、避免随机取记录
    rand() 函数

# 7、多次插入换成批量一次性插入
    Insert into table(col1,col2) values(x,x),(y,y),(z,z);

# 8、只返回必要的列，用具体的字段列表代替 select *
    
# 9、区分in和exists
    区别主要为 两者的驱动顺序。 
    IN： 先执行子查询，适用于外表大 内表小的情况；
    EXISTS ： 外层表为驱动表先被执行
    注 ： 建议再确定且有限集合时，可以使用IN
