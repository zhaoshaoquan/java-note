# java-note
Java学习笔记

# 一、Java基础
### 1.字符串(String、StringBuilder、StringBuffer)

### 2.集合(Set、List)

### 3.Map(HashMap、LinkedHashMap、TreeMap、Hashtable、ConcurrentHashMap)

COnHasMap（ConcurrentHashMap）这个必问的
ConcurrentHashMap原理分析：https://www.cnblogs.com/ITtangtang/p/3948786.html


hash原理：https://www.cnblogs.com/chengxiao/p/6059914.html
Map本质就是数组（物理存储结构），HashMap即是采用了链地址法，也就是数组+链表的方式

Hashtable：继承Dictionary类，是遗留类，很多映射的常用功能与HashMap类似，线程安全，但是不建议在新代码使用，不需要线程安全的场合可以用HashMap替换，需要线程安全的场合可以用ConcurrentHashMap替换。
LinkedHashMap：是HashMap的一个子类，保存了记录的插入顺序，在用Iterator遍历LinkedHashMap时，先得到的记录肯定是先插入的，也可以在构造时带参数，按照访问次序排序。

TreeMap：继承AbstractMap,实现SortedMap接口，能够把它保存的记录根据键排序，默认是按键值的升序排序，也可以指定排序的比较器，当用Iterator遍历TreeMap时，得到的记录是排过序的。如果使用排序的映射，建议使用TreeMap。在使用TreeMap时，key必须实现Comparable接口或者在构造TreeMap传入自定义的Comparator，否则会在运行时抛出java.lang.ClassCastException类型的异常。


　　哈希表（hash table）也叫散列表，是一种非常重要的数据结构，应用场景及其丰富，许多缓存技术（比如memcached）的核心其实就是在内存中维护一张大的哈希表，而HashMap的实现原理也常常出现在各类的面试题中，重要性可见一斑。本文会对java集合框架中的对应实现HashMap的实现原理进行讲解，然后会对JDK7的HashMap源码进行分析。
### 4.Java反射

主要是指程序可以访问，检测和修改它本身状态或行为的一种能力，并能根据自身行为的状态和结果，调整或修改应用所描述行为的状态和相关的语义。 
反射是java中一种强大的工具，能够使我们很方便的创建灵活的代码，这些代码可以再运行时装配，无需在组件之间进行源代码链接。但是反射使用不当会成本很高！

### 5.Java注解

### 6.Java泛型
JAVA的泛型擦除：https://www.cnblogs.com/doucheyard/p/6855823.html
泛型继承，通配符，泛型反射：https://blog.csdn.net/vi_young_95/article/details/82979358
### 7.JDBC

### 8.JNI

### 9.深拷贝与浅拷贝
    浅拷贝是指在拷贝对象时，对于基本数据类型的变量会重新复制一份，而对于引用类型的变量只是对引用进行拷贝，
    没有对引用指向的对象进行拷贝。 
    深拷贝是指在拷贝对象时，同时会对引用指向的对象进行拷贝。 
    区别就在于是否对 对象中的引用变量所指向的对象进行拷贝。
    浅拷贝是指拷贝对象时仅仅拷贝对象本身（包括对象中的基本变量），而不拷贝对象包含的引用指向的对象。
    深拷贝不仅拷贝对象本身，而且拷贝对象包含的引用指向的所有对象。举例来说更加清楚：对象A1中包含对B1的引用，
    B1中包含对C1的引用。浅拷贝A1得到A2，A2 中依然包含对B1的引用，B1中依然包含对C1的引用。深拷贝则是对浅拷贝的递归，深拷
    贝A1得到A2，A2中包含对B2（B1的copy）的引用，B2 中包含对C2（C1的copy）的引用。 
    若不对clone()方法进行改写，则调用此方法得到的对象即为浅拷贝。

### 10、Java代理
    代理(Proxy)是一种设计模式,提供了对目标对象另外的访问方式;即通过代理对象访问目标对象.这样做的好处是:可以在目标对象实现的基础上,增强额外的功能操作,即扩展目标对象的功能.
    这里使用到编程中的一个思想:不要随意去修改别人已经写好的代码或者方法,如果需改修改,可以通过代理的方式来扩展该方法
https://www.cnblogs.com/cenyu/p/6289209.html
静态代理：
动态代理：
Cglib代理：

### 11、transient volatile
transient相关：
volatile相关：https://www.cnblogs.com/dolphin0520/p/3920373.html

### 12、Java类加载

# 二、设计模式
    java的设计模式大体上分为三大类：
    创建型模式（5种）：工厂方法模式，抽象工厂模式，单例模式，建造者模式，原型模式。
    结构型模式（7种）：适配器模式，装饰器模式，代理模式，外观模式，桥接模式，组合模式，享元模式。
    行为型模式（11种）：策略模式、模板方法模式、观察者模式、迭代子模式、责任链模式、命令模式、备忘录模式、状态模式、
    访问者模式、中介者模式、解释器模式。
    设计模式遵循的原则有6个：
    1、开闭原则（Open Close Principle）
    　　对扩展开放，对修改关闭。
    2、里氏代换原则（Liskov Substitution Principle）
    　　只有当衍生类可以替换掉基类，软件单位的功能不受到影响时，基类才能真正被复用，而衍生类也能够在基类的基础上增加新的行为。
    3、依赖倒转原则（Dependence Inversion Principle）
    　　这个是开闭原则的基础，对接口编程，依赖于抽象而不依赖于具体。
    4、接口隔离原则（Interface Segregation Principle）
    　　使用多个隔离的借口来降低耦合度。
    5、迪米特法则（最少知道原则）（Demeter Principle）
    　　一个实体应当尽量少的与其他实体之间发生相互作用，使得系统功能模块相对独立。
    6、合成复用原则（Composite Reuse Principle）
    　　原则是尽量使用合成/聚合的方式，而不是使用继承。继承实际上破坏了类的封装性，超类的方法可能会被子类修改。
### 1.工厂方法模式
### 2.抽象工厂模式
### 3.单例模式
~~### 4.建造者模式~~
~~### 5.原型模式~~
### 6.适配器模式
~~### 7.装饰器模式~~
### 8.代理模式
### 9.外观模式
~~### 10.桥接模式~~
~~### 11.组合模式~~
~~### 12.享元模式~~
### 13.策略模式
~~### 14.模板方法模式~~
### 15.观察者模式
~~### 16.迭代子模式~~
~~### 17.责任链模式~~
### 18.命令模式
~~### 19.备忘录模式~~
### 20.状态模式
### 21.访问者模式
~~### 22.中介者模式~~
### 23.解释器模式
    基础的了解 观察者 工厂 啥的就行了，没必要太多。

# 三、多线程
### 1.
### 2.
### 3.锁
同步锁
分段锁
JAVA中锁的对比：https://www.cnblogs.com/zhimingyang/p/5702752.html
乐观锁、悲观锁：https://blog.csdn.net/qq_34337272/article/details/81072874
公平锁、非公平锁

在并发编程中，我们通常会遇到以下三个问题：原子性问题，可见性问题，有序性问题。

### 4.线程池实现原理

# 四、网络篇
### 1.TCP协议的三次握手
### 2.
### 3.

# 五、JDK
### 1.JDK源码
### 2.JDK6新特性
### 3.JDK7新特性
### 4.JDK8新特性
    hashMap增加红黑树：https://blog.csdn.net/lch_2016/article/details/81045480
### 5.JDK9新特性
    https://baijiahao.baidu.com/s?id=1593429162250494010&wfr=spider&for=pc

# 六、JVM
### 1.OOM
### 2.GC管理
### 3.Java内存模型
### 4.

# 七、框架篇
### 1.Spring
    IOC、AOP：https://blog.csdn.net/yuexianchang/article/details/77018603
    在Spring的AOP编程中，如果加入容器的目标对象有实现接口,用JDK代理；如果目标对象没有实现接口,用Cglib代理

### 2.Spring Boot

### 3.Spring Cloud
    配置中心、注册中心、
### 4.MyBatis
    
### 5.Netty

### 6.Activity

### 7、Apache Maven


# 八、分步式
### 1.zookeeper
### 2.dubbo
### 3.
分布式 了解SpringCLoud这套组件的理论，还有 典型的分布式组件zookeeper，及相关的分布式算法zab,raft,paxos,

CAP理论：https://www.cnblogs.com/duanxz/p/5229352.html


# 九、数据库
### 1.索引
### 2.查询优化
### 3.
数据库集中在 索引那部分，和查询优化。

# 十、中间件
### 1.Redis
### 2.消息对列(ActiveMQ、RabbitMQ、Kafka)
### 3.

# 十一、Java IO篇
### 1、IO与NIO
### 2、