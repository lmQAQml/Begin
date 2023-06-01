#JDK 1.8
## 一 、 StreamApi 
    jdk1.8增加了stream特性，主要是基于fork-join框架构建，
    而且你可以通过parallel()与sequential()在并行流与顺序流之间进行切换。

## 二 、 Hashmap性能优化
    1. 最重要的一点是底层结构不一样，1.7是数组 + 链表，1.8则是数组 + 链表 + 红黑树结构
    2. 插入键值对的put方法的区别，1.8中会将节点插入到链表尾部，而1.7中是采用头插
    3. jdk1.7中的hash函数对哈希值的计算直接使用key的hashCode值，
        而1.8中则是采用key的hashCode异或上key的hashCode进行无符号右移16位的结果，
        避免了只靠低位数据来计算哈希时导致的冲突，计算结果由高低位结合决定，使元素分布更均匀
    4. 扩容策略：1.7中是只要不小于阈值就直接扩容2倍；
        而1.8的扩容策略会更优化，当数组容量未达到64时，以2倍进行扩容，
        超过64之后若桶中元素个数不小于7就将链表转换为红黑树，
        但如果红黑树中的元素个数小于6就会还原为链表，当红黑树中元素不小于32的时候才会再次扩容。
    注： 1. 头插尾插区别？
        2. 多种散列方式？
        3. 扩容 桶的含义以及红黑树如何转换？

## 三 、永久代移除，变成元空间

    1.字符串存在永久代中，容易出现性能问题和内存溢出。 
    2.类及方法的信息等比较难确定其大小（比如动态加载类时），因此对于永久代的大小指定比较困难，太小容易出现永久代溢出，太大则容易导致老年代溢出

## 四 、lambda表达式

    函数式接口，接口中只有一个方法

```
    // 用匿名内部类的方式来创建线程 
    new Thread(new Runnable(){
        @Override
            public void run(){
                System.out.println("hello world");
            }
        });

    // 使用Lambda来创建线程
    new Thread(()->System.out.println("hello world"));
```

## 五 并发：1. LongAdder 2. CompletableFuture 3. StampedLock

    LongAdder(L————AtomicLong 的并发进化版)
    相比较Atomiclong,相当于用空间来换时间，longAdder的基本思路就是分散热点,里面有几个核心要素，需要记住
    Striped64抽象类，Striped64中定义了Cell内部类和各重要属性
    cell类------当并发高时，拆分到多个cell进行计算
    base-------基础值
    顺便提一下Atomiclong的原理---AtomicLong的实现方式是内部有个value 变量，当多线程并发自增，自减时，主要是调用了Unsafe类的getAndAddLong方法，该方法是个native方法，它的逻辑是采用自旋的方式不断更新目标值，直到更新成功。----缺点就是在高并发的情况下，自旋的情况会明显变多，这样子CAS的性能就会大幅度下降了
    AtomicLong,常见方法--addAndGet、decrementAndGet、compareAndSet，getAndIncrement()，incrementAndGet()


    
