## 1. spring boot 和spring cloud区别

```
    spring boot是一个专注于开发单个微服务（单个）
    spring cloud是一系列框架的集合，包括nacos（配置中心），feign（），eureka()等，
        是一个分布式服务治理的框架,构建分布式系统的工具(全局)
    spring could在spring boot的基础框架上进行分布式开发,不可离开spring boot，但spring boot可单独开发。
        属于依赖关系
   
   
   spring could：
    ① Ribbon：客户端负载均衡，特性有区域亲和、重试机制。
     ② Hystrix：客户端容错保护，特性有服务降级、服务熔断、请求缓存、请求合并、依赖隔离。
     ③ Feign：声明式服务调用，本质上就是Ribbon+Hystrix。
     ④ Stream：消息驱动，有Sink、Source、Processor三种通道，特性有订阅发布、消费组、消息分区。
     ⑤ Bus：消息总线，配合Config仓库修改的一种Stream实现。
     ⑥ Sleuth：分布式服务追踪，需要搞清楚TraceID和SpanID以及抽样，如何与ELK整合。     
```

## 2. 