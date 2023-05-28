# 1、避免子查询
    MySQL5.5版本 内部执行计划先查外表后查内表，若外表数据量过大，查询速度会很慢

    可使用join优化

# 2、用IN替换OR
    IN中的常量全部储存于数组中（优先排好序会进一步提升效率），二分查找去筛选满足条件（O(log n)）, OR的时间复杂度为O（n）

# 3、读取适量的记录 LIMIT m,n
    

# 4、禁止不必要的order by排序
    group by 会默认排序，可使用 group by xxx order by null 禁止排序