# JVM

![image-20241210202727855](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241210202727855.png)

## 1、JVM的位置

运行在操作系统之上的     JRE

操作系统下面的是硬件体系

.JAVA ->Class File-> 类装载器 Class Loader

##  2、JVM体系

![image-20241210203837252](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241210203837252.png)

栈和程序计数器  不会有垃圾回收

JVM调优在方法区和堆     99%在堆

## 3和4、类加载器

作用：加载CLASS文件  

getclassloader

![image-20241214192847755](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241214192847755.png)

1、虚拟机自带的加载器

2、启动类（根）加载器

3、扩展类加载器

4、应用程序加载器 

一层一层 开始找

双亲委派机制 保证安全

**双亲委派机制**（Parent Delegation Model）是 Java 类加载器的一种设计模式，用于确保 Java 类的加载具有一定的安全性和稳定性。它是 Java 类加载过程中的重要规则，主要体现在 `ClassLoader` 类的实现中。假设一个类加载器 `C` 需要加载某个类 `Test`，其流程如下：

1. `C` 首先将请求委托给它的父加载器。
2. 父加载器进一步向上委托，直到达到了 `Bootstrap ClassLoader`。
3. `Bootstrap ClassLoader` 尝试加载类。如果找到该类，加载过程结束；否则，将返回未找到的结果。
4. 加载请求逐层回退到子加载器，直到当前加载器 `C` 尝试自己加载类。
5. 如果当前加载器 `C` 仍无法加载类，则抛出 `ClassNotFoundException`。

这一流程确保了 Java 类的加载过程是由父级加载器优先，避免了重复加载和冲突

**安全性**：避免核心类库被篡改。例如，自定义加载器无法加载替代核心类（如 `java.lang.String`）。

**避免重复加载**：同一个类只会被加载一次，从而节省内存。

**稳定性**：确保 JVM 自带的类库优先加载，避免被自定义类库覆盖。

APP->EXC--BOOT

 ![image-20241214161053446](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241214161053446.png)





## 5、沙箱安全机制

核心就是java沙箱，限制程序运行的环境

当前最新  引入域的原则

![image-20241214200735530](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241214200735530.png)



![image-20241214200934239](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241214200934239.png)

类加载器第一个：双亲委派   第三个：沙箱安全机制

![image-20241214201240237](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241214201240237.png)

## 6、Native

```
private native void start0();  
```

```
//native:凡是带了native关键字的方法，说明java的作用范围达不到了
//会去调用底层C语言的库！
//会进入本地方法栈
//调用本地方法接口， JNI
//JNI作用：扩展JAVA的使用，融合不同的编程语言为Java所用！
//最初：C、C++
//Java诞生的时候 C和C++横行   想要立足、必须要用C和C++的程序
//它在内存区域中专门开辟了一条标记区域：Native Method Stack,登记natvie方法
//在最终执行的时候 加载本地方法库中的方法  通过JNI

//JAVA程序驱动打印机，管理系统
//掌握即可，在企业级应用中较为少见！
```

PC寄存器

＋1 



## 8、方法区

![image-20241215213549596](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241215213549596.png)

static  final   class模板  常量池 ——》方法区

其他在堆

## 9、栈

主管程序的运行，生命周期和线程同步  线程独占

一旦线程结束，栈就结束 

不存在垃圾回收的问题

栈：8大基本类型+对象引用+实例的方法

本地变量就是局部变量的意思

栈运行原理：栈帧

![image-20241215215157958](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241215215157958.png)

栈满了:StackOverflowwError

栈＋堆＋方法区：交互关系

**栈**是线程私有的，主要用来管理方法调用和执行时的数据。在栈帧中保存了方法的局部变量表、操作数栈、动态链接和返回地址等信息。

## 10、三种JVM

Sun公司 HotSpot  一般是这个

BEA公司 JRockit  

IBM公司 J9VM  JIT编译器 





 ## 堆

Heap   一个JVM只有一个堆内存

堆内存的大小是可以调节的。

类加载器读取了类文件后，一般会把什么东西放到堆中呢  

类，方法，常量，变量   保存我们所有引用类型的真实对象 （实例） 数组

堆内存细分三个区域：新生区（伊甸园区）、老年区、永久区



新生区：伊甸园、幸存区0区、幸存区1区    动态概念    轻GC后没有被回收 进入幸存区    0和1区会交互

假设GC次数为20

活下来后去养老区



养老区满了会触发重量级GC  (full GC)



永久存储区

GC垃圾回收主要是在伊甸园区和养老区



OOM爆了

Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
	at java.util.Arrays.copyOf(Unknown Source)
	at java.lang.AbstractStringBuilder.ensureCapacityInternal(Unknown Source)
	at java.lang.AbstractStringBuilder.append(Unknown Source)
	at java.lang.StringBuilder.append(Unknown Source)
	at JVM.Edenlearning.main(Edenlearning.java:9)





## 新生区、老年区、永久区

99%的对象都是临时对象



类：诞生和成长的地方，甚至死亡

伊甸园  所有的对象都是在这里new出来的  满了 触发轻GC

还有引用的活下来的 去幸存区



幸存者区  0区和1区  互相交换 的  动态的

幸存区满了 触发重GC 把新生区都清      活下来的 去养老区





永久区（JDK8以后叫元空间）

这个区域常驻内存的。用来存放JDK自身携带的Class对象。Interface元数据，存储的是运行时的一些环境   这个区域不存在垃圾回收 ！  关闭虚拟机时就会释放



一个启动类 加载了大量的第三方jar包   tomcat部署了太多的应用  大量动态生成的反射类。  不断的被加载就会爆

jdk1.6以之前 永久代  常量池在方法区

1.7   去永久代 常量池在堆中

1.8之后：无永久代，常量池在元空间

### **元空间存放的内容**：

1. **类的元数据**：
   - 类的名称、字段、方法、字节码、常量池等信息。
2. **运行时类信息**：
   - 类加载器加载的类的所有元信息。
3. **方法的元数据**：
   - 方法的字节码和其他方法相关的元信息。

非堆

在**JDK 7 及以前**，方法区由**永久代（PermGen）\**实现；在\**JDK 8 及以后**，方法区由**元空间（Metaspace）**实现。



**方法区** 和 **堆** 是两个不同的内存区域，分别负责存储类的元数据和对象实例。

**元空间** 是 **方法区** 的实现（JDK 8 以后），并不在堆内存中，而是使用本地内存。

在 **JDK 8 及以后**，**方法区** 的实现由 **永久代（PermGen）** 改为 **元空间（Metaspace）**。

**永久代（PermGen）** 存储在 JVM 的堆外内存（非堆）中，大小固定。

**元空间（Metaspace）** 存储在 **本地内存** 中，可以动态扩展，并且不再受到堆内存大小的限制。



**元空间（Metaspace）** 和 **永久代（PermGen）** 都**不在堆内存**中

 

- **常量池** 存储在 **方法区（Method Area）** 中，方法区是 **永久代（PermGen）** 的一部分。
- 永久代中的常量池保存的是字面量常量（如字符串、数字）以及符号引用（如类名、字段名、方法名等）。

**在 JDK 8 及以后（元空间）**：

- **常量池** 仍然存储在 **方法区** 中，但方法区的实现由 **永久代** 转变为 **元空间（Metaspace）**。
- 在 JDK 8 之后，**常量池** 跟 **元空间** 一起存储在 **本地内存（Native Memory）** 中，不再使用堆内存，而是由操作系统的内存管理来管理

元空间逻辑上存在 物理上不存在



![img](https://i-blog.csdnimg.cn/blog_migrate/a537a8741eb2c0ca7c6c0edf760662a9.png)



分配的总内存是内存的四分之一  初始化的内存  1/64

OOM解决：1、尝试扩大堆内存

2、分析内存 看一下哪个地方出现问题



## 排除OOM错误

Debug  一行行代码看

能够看到第几行出错  内存快照分析工具，MAT  Jprofiler

MAT JPofiler作用： 分析dump内存文件，快速定位内存泄漏；

获取堆中的数据

获得大的对象



14、堆内存调优

15、GC

16、JMM

17、总结





