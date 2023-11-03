## 线程池

# 通过实现ThreadPoolExecutor创建线程池

```java
class thread {

    public ThreadPoolExecutor(int corePoolSize,
                              int maximumPoolSize,
                              long keepAliveTime,
                              TimeUnit unit,
                              BlockingQueue<Runnable> workQueue,
                              ThreadFactory threadFactory) {
        this(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue,
                threadFactory, defaultHandler);
    }
}
// defaultHandler默认的拒绝策略，直接抛出运行时异常
```

# 通过实现Executors接口创建线程池

1. newCachedThreadPool

```
    可缓存的无界线程池
```

2. newFixedThreadPool

```
    指定大小的线程池，可设置最大并发数，超出的线程会在LinkedBlockingQueue队列中等待
```

2. newScheduledThreadPool

```
    有周期性的线程池,可指定核心线程数
```