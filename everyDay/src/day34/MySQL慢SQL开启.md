## 1. MySQL慢SQL开启

保证最终一致性！！！

```mysql
    set GLOBAL slow_query_log = 1;
    
    select @@slow_query_log;
    
    set GLOBAL long_query_time = 9;
    
    select @@long_query_time;
    
    set GLOBAL log_output='TABLE,FILE';
    
    select @@log_output;
    
    select * from slow_log limit 10;
```
