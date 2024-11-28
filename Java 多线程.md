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

Lock的三个实现类   可重入锁(常用)   写锁 读锁

 



公平锁：十分公平 可以先来后到 NonfairSync()

非公平锁：十分不公平  可以插队 FairSync()    默认非公平锁



lock锁与synchronized的区别：

1、 synchronized是内置的关键字  Lock是一个类

2、 synchronized 无法判断获取锁的状态  而Lock可以

3、synchronized会自动释放锁   Lock手动解锁    如果不放 会死锁

4、synchronized  线程1获得锁，阻塞  线程2等待，傻等； lock锁  不一定一直等

5、synchronized  可重入锁，不可以中断的  非公平 ； lock，可重入  可以判断锁，可设置公平和非公平

6、synchronized  适合锁少量的代码同步问题，  lock 适合锁大量的代码同步



锁是什么，如何判断锁的是谁

# 生产者和消费者问题

面试：单例模式、排序算法、生产者和消费者、死锁问题

生产者和消费者问题  Synchronized 版   

~~~java	
class Data{  //数字 资源类

    int number =0;

    // +1
    public synchronized void  increment() throws InterruptedException
    {
        if(number!=0) //改为while 防止虚假唤醒
        {
            //等待
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程  我+1 完毕了
        this.notifyAll();
    }

    public synchronized void decrement() throws InterruptedException
    {
        if(number==0)//改为while 防止虚假唤醒
        {
            //等待
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程  我-1完毕了
        this.notifyAll();
    }

~~~



问题存在  ABCD 四个线程！

等待应该出现在循环中，防止虚假唤醒   if改为while判断

wait和notify notify

## juc版的生产者和消费者问题



通过Lock找到Condition  await  signalAll方法  (Condition类)

为什么不能直接使用await和signal:

`await` 和 `signal` 是 `Condition` 接口的方法，用于实现线程之间的等待与通知机制。但是，它们的操作需要在**持有锁的前提下**进行

`await` 和 `signal` 通常用于线程之间的通信，它们操作的是**共享资源**的状态（例如队列是否为空、是否已满）。如果没有锁来保护对共享资源的访问，多个线程可能同时修改资源，导致数据竞争或不一致的状态

代码实现:

~~~java
class Data2{  //数字 资源类

    int number =0;

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    // +1
    public  void  increment() throws InterruptedException
    {

        lock.lock();

        try{
            while(number!=0)
        {
            //等待
            condition.await();

        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        //通知其他线程  我+1 完毕了
        condition.signalAll();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public   void decrement() throws InterruptedException {
        lock.lock();

        try {
            while (number == 0) {
                //等待
                condition.await();
            }
            number--;
            System.out.println(Thread.currentThread().getName() + "=>" + number);
            //通知其他线程  我-1完毕了
            condition.signalAll();
        }catch (InterruptedException e)
        {
            e.printStackTrace();

        }
        finally {

            lock.unlock();
        }
    }
~~~





Condition可以精准的通知和唤醒线程

 ~~~Java	
 
 class Data3{
     private Lock lock = new ReentrantLock();
     private Condition condition1 = lock.newCondition();
     private Condition condition2 = lock.newCondition();
     private Condition condition3 = lock.newCondition();
 
 
     private int number=1;  //1A  2B 3C
     public void printA()
     {
         lock.lock();
         try {
             //业务代码，判断->执行->通知
             while(number!=1)
             {
                 //等待
                 condition1.await();
             }
             System.out.println(Thread.currentThread().getName()+"AAAAAA");
             //唤醒,只唤醒指定的人 B
             number=2;
             condition2.signal();
         }
         catch (Exception e) {
             e.printStackTrace();
 
         }
         finally {
             lock.unlock();
         }
 
     }
 
     public void printB()
     {
         lock.lock();
         try {
             //业务代码，判断->执行->通知
                 while(number!=2)
             {
                 //等待
                 condition2.await();
             }
             System.out.println(Thread.currentThread().getName()+"BBBBBBBB");
             //唤醒,只唤醒指定的人 B
             number=3;
             condition3.signal();
         }
         catch (Exception e) {
             e.printStackTrace();
 
         }
         finally {
             lock.unlock();
         }
     }
     public void printC()
     {
         lock.lock();
         try {
             //业务代码，判断->执行->通知
                while(number!=3)
             {
                 //等待
                 condition3.await();
             }
             System.out.println(Thread.currentThread().getName()+"CCCCCCC");
             //唤醒,只唤醒指定的人 B
             number=1;
             condition1.signal();
         }
         catch (Exception e) {
             e.printStackTrace();
 
         }
         finally {
             lock.unlock();
         }
     }
 
         //生产线：下单->支付->交易->物流
         
 
 }
 
 ~~~

## 八锁现象

