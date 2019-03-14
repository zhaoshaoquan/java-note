# Java 基础

    1、hashMap的实现原理和底层结构，hashMap，get方法的时间复杂度
    2、解决key哈希值冲突的方法
    3、ArrayList与LinkedList的实现区别
    4、IO的几种模式（https://blog.csdn.net/woxinqidai/article/details/82717427）
        同步阻塞IO，同步非阻塞IO，IO多路复用，AIO(Asynchronous IO) 异步非阻塞IO
    5、

# Spring 基础

    1、spring事务的实现原理
    2、

# 多线程

    1、volatile关键字的作用是什么
    2、Runnable接口和Callable接口的不同点？
    3、CyclicBarrier和CountDownLatch的区别（https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=924747898,3771862030&fm=173&s=4D00E91A9BDC64C80EFCB1CA0000C0B1&w=544&h=258&img.JPEG）
    4、volatile和synchronized的区别
        1）volatile本质是在告诉jvm当前变量在寄存器中的值是不确定的,需要从主存中读取,synchronized则是锁定当前变量,只有当前线程可以访问该变量,其他线程被阻塞住.
        2）volatile仅能使用在变量级别,synchronized则可以使用在变量,方法.
        3）volatile仅能实现变量的修改可见性,而synchronized则可以保证变量的修改可见性和原子性.
        4）volatile不会造成线程的阻塞,而synchronized可能会造成线程的阻塞.
    5、Lock和synchronized区别
    6、线程池ThreadPoolExecutor的工作原理
    （https://segmentfault.com/a/1190000012705130）
    7、
    

# jvm
    （http://www.importnew.com/23792.html）

    1、类加载机制，步骤，各做了什么事情
        （http://www.importnew.com/23742.html）
        
    2、jvm内存结构
         （http://www.importnew.com/23746.html）
        对象分配规则
        对象优先分配在Eden区，如果Eden区没有足够的空间时，虚拟机执行一次Minor GC。
        大对象直接进入老年代（大对象是指需要大量连续内存空间的对象）。这样做的目的是避免在Eden区和两个Survivor区之间发生大量的内存拷贝（新生代采用复制算法收集内存）。
        长期存活的对象进入老年代。虚拟机为每个对象定义了一个年龄计数器，如果对象经过了1次Minor GC那么对象会进入Survivor区，之后每经过一次Minor GC那么对象的年龄加1，知道达到阀值对象进入老年区。
        动态判断对象的年龄。如果Survivor区中相同年龄的所有对象大小的总和大于Survivor空间的一半，年龄大于或等于该年龄的对象可以直接进入老年代。
        空间分配担保。每次进行Minor GC时，JVM会计算Survivor区移至老年区的对象的平均大小，如果这个值大于老年区的剩余值大小则进行一次Full GC，如果小于检查HandlePromotionFailure设置，如果true则只进行Monitor GC,如果false则进行Full GC。
        
    3、GC算法 垃圾回收（http://www.importnew.com/23752.html）
    
        标记 -清除算法，“标记-清除”（Mark-Sweep）算法，如它的名字一样，算法分为“标记”和“清除”两个阶段：首先标记出所有需要回收的对象，在标记完成后统一回收掉所有被标记的对象。
        复制算法，“复制”（Copying）的收集算法，它将可用内存按容量划分为大小相等的两块，每次只使用其中的一块。当这一块的内存用完了，就将还存活着的对象复制到另外一块上面，然后再把已使用过的内存空间一次清理掉。
        标记-压缩算法，标记过程仍然与“标记-清除”算法一样，但后续步骤不是直接对可回收对象进行清理，而是让所有存活的对象都向一端移动，然后直接清理掉端边界以外的内存
        分代收集算法，“分代收集”（Generational Collection）算法，把Java堆分为新生代和老年代，这样就可以根据各个年代的特点采用最适当的收集算法。
        
        垃圾收集器
        
        
    4、GC分析 命令调优
        http://www.importnew.com/23761.html
    


# 算法


    1、使用代码写出快速排序
    2、使用代码写出堆排序
    3、倒排索引的原理

# 分布式架构

    1、微服务如何实现幂等性
    2、分布式事务的实现方式有哪几种
    

# 消息队列



# 关系型数据库

    

# 非关系型数据库

## redis 
    
    1、redis内存回收策略：
        （https://www.cnblogs.com/WJ5888/p/4371647.html）
      noeviction:返回错误当内存限制达到并且客户端尝试执行会让更多内存被使用的命令（大部分的写入指令，但DEL和几个例外）
      allkeys-lru: 尝试回收最少使用的键（LRU），使得新添加的数据有空间存放。
      volatile-lru: 尝试回收最少使用的键（LRU），但仅限于在过期集合的键,使得新添加的数据有空间存放。
      allkeys-random: 回收随机的键使得新添加的数据有空间存放。
      volatile-random: 回收随机的键使得新添加的数据有空间存放，但仅限于在过期集合的键。
      volatile-ttl: 回收在过期集合的键，并且优先回收存活时间（TTL）较短的键,使得新添加的数据有空间存放。
      
    2、redis键值最大的容量是多少？
    3、redis分片原理
    4、redis哈希剿的概念
    5、redis如何做内存优化
    6、redis插入大量数据的方法
        http://www.redis.cn/topics/mass-insert.html
    7、redis如何做横向扩容
    8、redis如何实现分布式锁，如何实现先到先得
    9、redis持久化的方式，各有什么优缺点
    10、海量日志如何排序和处理
    11、redis的key是如何寻址的
    
# 笔试题
    
    
      




