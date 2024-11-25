# Java 多线程

线程和任务的关系

Thread 类创建的

任务通过Runnable 接口来定义的



继承Thread类

实现Runnable接口

实现Callable接口

 



Thread构造器:无参构造就是不需要指定任务   有参构造可以直接指定线程的任务 

~~~java	
public Thread (Runnable target) 
~~~

创建线程对象的时候直接传入它的任务

 

1. 创建线程对象 同时指定任务
2. 启动线程，start方法  就绪状态 等待CPU资源
3. 拿到CPU资源时就运行  run方法  

~~~java	
public void run() {
        if (target != null) {
            target.run();
        }
    }  jdk8
~~~



 runnable target的任务  成员变量



用来接收创建线程对象时，传入的任务

1.创建线程对象 传入任务

2.将任务赋值给target成员变量

3.线程执行的时候    操作target对象



实现多线程的两种形式对比

继承  与  实现接口   （还有实现callable接口 比较少）

线程对象一旦争到CPU资源 就会调用run方法



继承的缺点直接将任务的实现写到了线程类当中，耦合度高



实现接口的形式可以解决上述问题  实现解耦合  Thread和runnable 分开

交替实行  CPU资源切换

lambda 表达式  函数式编程

可以将方法的实现作为参数进行传值

实现接口的方式：

1、实现匿名内部类的形式来减少类的定义

2、使用lambda表达式进一步简化代码 不需要关注其他内容



线程休眠

1. 创建t1 并启动

2. t1休眠1s

3. 创建t2并启动

   sleep方法究竟是让哪个线程休眠

   ### 不在于谁调用sleep 而在于sleep写在哪

