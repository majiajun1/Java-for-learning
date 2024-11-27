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





# 并发编程



Callable效率比runnable 高？ 相对罢了  



## 线程和进程



进程是资源分配的最小单位  线程是资源调度的最小单位

进程：一个程序   程序的集合  jar  exe

一个进程往往可以包含多个线程

java默认 两个线程    main和gc

线程： 写字的自动保存(线程负责)   

Thread runnable callable

Java真的能开启线程吗？

~~~java	

    public synchronized void start() {
        /**
         * This method is not invoked for the main method thread or "system"
         * group threads created/set up by the VM. Any new functionality added
         * to this method in the future may have to also be added to the VM.
         *
         * A zero status value corresponds to state "NEW".
         */
        if (threadStatus != 0)
            throw new IllegalThreadStateException();

        /* Notify the group that this thread is about to be started
         * so that it can be added to the group's list of threads
         * and the group's unstarted count can be decremented. */
        group.add(this);

        boolean started = false;
        try {
            start0();
            started = true;
        } finally {
            try {
                if (!started) {
                    group.threadStartFailed(this);
                }
            } catch (Throwable ignore) {
                /* do nothing. If start0 threw a Throwable then
                  it will be passed up the call stack */
            }
        }
    }
  //
    private native void start0();
~~~

调用本地方法 底层CPP   JAVA无法直接操作硬件

## 并发和并行



并发（多线程操作同一个资源）

CPU  一核  模拟多线程 快速交替

并行（多个人一起行走）：

多核CPU  线程池



并发编程的本质：充分利用CPU的资源

所有的公司都很看重





### 线程的状态

```
public enum State {
    /**
     * Thread state for a thread which has not yet started.
     */
    NEW,  //新生

    RUNNABLE,  //运行

    BLOCKED,  //阻塞

    WAITING, //等待

    TIMED_WAITING, //超时等待
 
    TERMINATED; //终止
}
```



### wait 与sleep的区别

1、 来自不同的类   wait在object类  sleep在Thread类

企业当中 用TimeUnit比较多

2、关于锁的释放

wait会释放锁  sleep睡觉   抱着锁睡觉  不会释放

3、使用范围不同

wait必须在同步代码块中 (要有人等）

sleep可在任何地方睡觉

4、是否需要捕获异常

wait不需要捕获异常 （除了InterruptedException）

sleep必须要捕获异常



## LOCK锁

传统 Synchronized



