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







8、方法区

9、栈

10、三种JVM

11、堆

12、新生区、老年区

13、永久区

14、堆内存调优

15、GC

16、JMM

17、总结





