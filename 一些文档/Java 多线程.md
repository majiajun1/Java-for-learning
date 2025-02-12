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

1、实现匿名内部类的形式来减少类的定义  implement runable 重写run方法

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

非公平锁：十分不公平  可以插队 FairSync()    （谁抢到就谁）

ReentrantLock可重入锁 **默认非公平锁**



lock锁与synchronized的区别：

1、 synchronized是内置的关键字  Lock是一个类

2、 synchronized 无法判断获取锁的状态  而Lock可以

3、synchronized会自动释放锁   Lock手动解锁    如果不放 会死锁

4、synchronized  线程1获得锁，阻塞  线程2等待，傻等； lock锁  不一定一直等 

**tryLock()方法：**是有返回值的，它表示用来尝试获取锁，如果获取成功，则返回true，如果获取失败（即锁已被其他线程获取），则返回false，也就说这个方法无论如何都会立即返回。在拿不到锁时不会一直在那等待。

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

看代码

new this 具体的一个手机

static 锁的是class 唯一的一个模板



## 集合类不安全

Exception in thread "8" java.util.ConcurrentModificationException

并发修改异常

并发下 arraylist不安全

vector是安全的

用synchronized解决？想多了 vector底层已经帮你写好了    vector甚至比arraylist早

使用collections库的安全版

~~~java	
 List<String> list = Collections.synchronizedList(new ArrayList<>());
~~~

JUC库

```
List<String> list = new CopyOnWriteArrayList<>();
```

CopyOnWrite 写入时复制  COW   计算机程序设计优化策略

多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
 在写入的时候避免覆盖 ，造成数据问题

CopyOnWriteArrayList<>() 比vector厉害在哪里？
有synchronized的方法 速度慢一点  而前者用的LOCK锁  写入时复制也是用到lock锁



## set不安全

Hashmap也一样会出BUG

1.collection 类转化

```
Set<String> set = Collections.synchronizedSet(new HashSet<>());
```

2.JUC写法  但是实现不了hashset???

```
Set<String> set = new CopyOnWriteArraySet<>();
```

hashset底层是hashmap    key是无法重复的

```
public HashSet() {
    map = new HashMap<>();
}
public boolean add(E e) {
        return map.put(e, PRESENT)==null;
    }
```

用这个

Set<String> set =ConcurrentHashMap.newKeySet();



## map不安全

并发修改异常 again

Collections.synchronizedMap(map);    不行！！！

没有copyonwrite

有ConcurrentHashMap

```
Map<String,String> map = new ConcurrentHashMap<>();
```

## callable（简单）

runnable不返回结果 也不抛出被检查的异常

callable可以有返回值  可以抛出异常

方法不同,run() 和call()的区别

callable<V>  V为返回值类型

V call()

回顾：Thread只接受Runnable参数

Callable 找方法跟runnable扯上关系

**适配器模式**

~~~java
==只是示例===
public class FutureTask<V> implements RunnableFuture<V> {
    private final Callable<V> callable;  // 适配的目标
    private V result;                    // 存储返回值

    public FutureTask(Callable<V> callable) {
        this.callable = callable;
    }

    @Override
    public void run() {
        try {
            result = callable.call();  // 调用 Callable 的 call() 方法
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public V get() {
        return result;  // 返回计算结果
    }
}
~~~

 **`future.get()` 会阻塞，直到任务完成**。





FutureTask是runnable的实现类   

RunnableFuture extends Runnable, Future

futuretask implements RunnableFuture

![在这里插入图片描述](https://i-blog.csdnimg.cn/blog_migrate/07c4baa8fefb5a9ab12ede92c18f9f84.png)

```
 FutureTask(Callable<V> callable)
```

```
public FutureTask(Runnable runnable, V result) {
    this.callable = Executors.callable(runnable, result);
    this.state = NEW;       // ensure visibility of callable
}
```



~~~java	

public class CallableLearning {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //new Thread(new MyThread()).start(); Runable不能用了

        //new Thread().start();
        MyThread2 thread = new MyThread2();

        //适配类
        FutureTask futureTask = new FutureTask(thread);

        new Thread(futureTask, "A").start();
         new Thread(futureTask, "B").start(); //会打印几个call? 一个 结果会被缓存，效率高


            Integer o = (Integer) futureTask.get();  //get方法可能会产生阻塞 把他放到最后
        //或者使用异步通信来处理！
            System.out.println(o);

    }

}

/*
class MyThread implements Runnable {

    public void run() {

    }
}
*/

class MyThread2 implements Callable<Integer>{

    public Integer call(){
        System.out.println("Call()");
        //假设是耗时的操作 返回可能会产生阻塞
        return 1024;
    }
}
~~~

`FutureTask` 是一个线程安全的、一次性执行的任务。

- 一旦 `FutureTask` 的 `run()` 方法被执行，无论是由哪个线程调用，只会执行一次（即使有多个线程调用 `start()`）。
- 因此，当多个线程使用同一个 `FutureTask` 实例时，只有一个线程会真正执行任务中的逻辑，其他线程尝试执行时会发现任务已经完成。

细节：

1、有缓存

2、结果可能需要等待，会阻塞！





## 常用的辅助类

### CountDownlatch

减法计数器

~~~java	
public class CountDownlatchLearning {
    public static void main(String[] args) throws InterruptedException {
        //倒计时 总是是6
        //执行任务的时候再使用
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"Go out");
                countDownLatch.countDown();//数量减一
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零 然后向下执行 没这个 就提前关门了
        System.out.println("close door");

    }
}

~~~

 countDownLatch.await()  和  countDownLatch.countDown()  



### CyclicBarrier

加法计数器



~~~java	
public class CyclicBarrierLearning {
    public static void main(String[] args) {
        //召唤龙珠的线程

        CyclicBarrier cyclicBarrier = new CyclicBarrier(7,
                ()->{System.out.println("召唤神龙成功");});


        for (int i = 1; i <=7; i++) {
            final int num = i;
            new Thread(()->{      //类操作不了i 只能用中间变量
                //System.out.println(num);
                System.out.println(Thread.currentThread().getName()+"收集第"+num+"个龙珠");
        try{
                cyclicBarrier.await();}
        catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
            }).start();

        }


    }
}
~~~

### Semaphore

经典信号量

抢车位问题

acquire和release

满了就等待 等到被释放为止

release放在 finally  跟Lock解锁是一样的 放finally

release释放信号量(+1)

~~~java
public class SemaphoreLearning {
    public static void main(String[] args) {
        //线程数量:停车位 限流
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i < 6; i++) {
            new Thread(()->{
                //acquire得到
               try {
                   semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到车位");
                   TimeUnit.SECONDS.sleep(2);
                   System.out.println(Thread.currentThread().getName()+"离开车位");

               }
               catch (InterruptedException e) {
                   e.printStackTrace();
               }finally {
                   semaphore.release();//release释放
               }

            },String.valueOf(i)).start();
        }
    }
}
~~~



## 读写锁

细粒度的lock

~~~java	
private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
lock和unlock函数
    /**
 * 独占锁（写锁）
 * 共享锁（读锁）
 * 读-读可以共存
 * 读-写不能共存
 * 写-写不能共存
 */
~~~



## 阻塞队列

队列里的资源问题

blockingQueue不是新的东西

![Collections](D:\Document\JAVA\Collections.png)

多线程，线程池 会用到



## 学会使用队列

添加、移除

### 四组API

1、抛出异常

2、不会抛出异常

3、阻塞等待

4、超时等待



| 方式       | 抛出异常 | 不抛异常，有返回值 | 阻塞等待 | 超时等待          |
| ---------- | -------- | ------------------ | -------- | ----------------- |
| 添加       | add      | offer              | put      | offer(多两个参数) |
| 移除       | remove   | poll               | take     | poll同理          |
| 判断队列首 | element  | peek               | -        | -                 |

 方法都可以混用的 但是最好不要



## SynchronousQueue 同步队列

没有容量，

进去一个元素，必须等待取出来之后 才能再往里面放一个元素

put、take方法

~~~java	

public class SynchronousQueuelearn {
    public static void main(String[] args) throws InterruptedException {

        SynchronousQueue<String> blockingQueue = new SynchronousQueue<>();
        //同步队列
        //SynchronousQueue不存储元素
        //put了一个元素 必须先take出来 否则不能再put进去值
        new Thread(()->{


            try{System.out.println(Thread.currentThread().getName()+" put 1");
             blockingQueue.put("1");
            System.out.println(Thread.currentThread().getName()+" put 2");
             blockingQueue.put("2");
            System.out.println(Thread.currentThread().getName()+" put 3");
             blockingQueue.put("3");}
            catch(InterruptedException e){
                e.printStackTrace();
            }
        },"T1").start();


        new Thread(()->{


            try{
                 TimeUnit.SECONDS.sleep(3);
                 System.out.println(Thread.currentThread().getName()+blockingQueue.take());
                  TimeUnit.SECONDS.sleep(3);
                 System.out.println(Thread.currentThread().getName()+blockingQueue.take());
                  TimeUnit.SECONDS.sleep(3);
                 System.out.println(Thread.currentThread().getName()+blockingQueue.take());

             }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        },"T2").start();
    }
}

~~~



## 线程池

### 池化技术

程序的运行，本质：占用系统的资源 ！ 优化资源的使用 ！ 池化技术



线程池、连接池、内存池、对象池。。。。。。//创建、销毁 浪费时间和资源

池化技术：事先准备好一些资源，有人要用，就来我这里拿，用完之后还给我

### 线程池的好处

1、降低资源的消耗

2、提高响应的速度

3、方便管理

线程复用、可以控制最大并发数、管理线程



### 线程池 三大方法  七大参数 四种拒接策略

线程池不允许使用Executors去创建   而是通过ThreadPoolExecutor的方式

规避资源耗尽的风险

Executors ：

FixedThreadPool和SingleThreadPool：允许请求队列长度为integer.Max_value 会堆积请求 导致OOM 

CachedThreadPool和ScheduledThreadPool:允许创建线程数量为integer.Max_value，可能会创建大量的线程 导致OOM

~~~java	
public class ThreadLakeLearning {
    public static void main(String[] args) {
       // Executors.newSingleThreadExecutor(); //单个线程
       // Executors.newFixedThreadPool(5); //创建固定的线程池大小
       // Executors.newCachedThreadPool();//可伸缩的

        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //ExecutorService threadPool  = Executors.newFixedThreadPool(5);
        ExecutorService threadPool  = Executors.newCachedThreadPool();
        try{
        for (int i = 0; i < 100; i++) {
            //用了线程池 不用new Thread
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+" OK");
            });
        }}
        catch(Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();

        }

        //线程池用完 程序结束 要关闭线程池

    }
}

~~~



### 七大参数

```
public static ExecutorService newSingleThreadExecutor() {
    return new FinalizableDelegatedExecutorService
        (new ThreadPoolExecutor(1, 1,
                                0L, TimeUnit.MILLISECONDS,
                                new LinkedBlockingQueue<Runnable>()));
}
```

```
public static ExecutorService newFixedThreadPool(int nThreads) {
    return new ThreadPoolExecutor(nThreads, nThreads,
                                  0L, TimeUnit.MILLISECONDS,
                                  new LinkedBlockingQueue<Runnable>());
}
```

```
public static ExecutorService newCachedThreadPool() {
    return new ThreadPoolExecutor(0, Integer.MAX_VALUE, //约等于21亿
                                  60L, TimeUnit.SECONDS,
                                  new SynchronousQueue<Runnable>());
}
```

本质：ThreadPoolExecutor

```
public ThreadPoolExecutor(int corePoolSize, //核心线程池大小
                          int maximumPoolSize,//最大核心线程池大小
                          long keepAliveTime, //超时了没有人调用就会释放
                          TimeUnit unit,//超时单位
                          BlockingQueue<Runnable> workQueue,//阻塞队列
                          ThreadFactory threadFactory, //线程工厂，创建线程的，一般不用动
                          RejectedExecutionHandler handler//拒绝策略) //七个参数
                          
                          
                          {
    if (corePoolSize < 0 ||
        maximumPoolSize <= 0 ||
        maximumPoolSize < corePoolSize ||
        keepAliveTime < 0)
        throw new IllegalArgumentException();
    if (workQueue == null || threadFactory == null || handler == null)
        throw new NullPointerException();
    this.acc = System.getSecurityManager() == null ?
            null :
            AccessController.getContext();
    this.corePoolSize = corePoolSize;
    this.maximumPoolSize = maximumPoolSize;
    this.workQueue = workQueue;
    this.keepAliveTime = unit.toNanos(keepAliveTime);
    this.threadFactory = threadFactory;
    this.handler = handler;
}
```

![image-20241202163821748](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241202163821748.png)

四种拒绝策略

```
private static final RejectedExecutionHandler defaultHandler =
    new AbortPolicy(); 默认拒绝策略   满了 还有人进来，不处理这个人 抛出异常
```

```
最大承载：Deque+max
```

```
CallerRunsPolicy()  哪里来的去哪里
我的实验代码中 去main处理了

DiscardPolicy() //队列满了 不抛异常 丢掉任务 
```

```
DiscardOldestPolicy()  //队列满了 尝试和第一个竞争  不行 还是丢掉 不抛异常

 public static class DiscardOldestPolicy implements RejectedExecutionHandler {
        /**
         * Creates a {@code DiscardOldestPolicy} for the given executor.
         */
        public DiscardOldestPolicy() { }

        
        public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
            if (!e.isShutdown()) {
                e.getQueue().poll();
                e.execute(r);
            }
        }
    }
```



## 小结和拓展

最大线程该如何定义

1、CPU密集型    几核 就定义为几   可以保证效率最高

```
Runtime.getRuntime().availableProcessors() 获取线程数 再去定义
```

2、IO密集型 

假设 15个大型任务 IO十分占用资源       判断程序中十分耗IO的线程    设置两倍

设置30个线程



## 四大函数式接口

lambda表达式、链式编程、函数式接口、Stream流式计算

```
public interface Runnable {
    public abstract void run();
}
//简化编程模型，在新版本的框架底层大量应用！
// foreach(消费者类的函数式接口)
default void forEach(Consumer<? super T> action) {
        Objects.requireNonNull(action);
        for (T t : this) {
            action.accept(t);
        }
    }
```

Consumer、Function、Predicate、Supplier

代码测试：  Function  函数式接口

```
public interface Function<T, R> {
 
    R apply(T t);  传入参数类型T  返回类型R
```

```
public static void main(String[] args) {
    Function function=new Function<String,String>() {
        @Override
        public String apply(String str) {
            return str;
        }
    };
    
    
    System.out.println(function.apply("hello"));
}

Function function=(str)->{return  str;};  lambda表达式简化

```

Predicate:  有一个输入参数  返回值只能是布尔值！

```
public interface Predicate<T> {
 
    boolean test(T t);
    
   Predicate predicate=new Predicate<String>() {
            @Override
            public boolean test(String o) {
                
                return false;
            }
        }
        
        
        Predicate<String> predicate=(str)->{return str.isEmpty();};  简化 判断是否为空
        
```

Consumer:  消费型接口   没有返回值 只有一个输入

```
public interface Consumer<T> {
 
    void accept(T t);
    
    
    
 Consumer <String> consumer=(str)->{System.out.println(str);};
```

Supplier:供给型接口  只有返回值

```
public interface Supplier<T> {
 
    T get();
}

Supplier<String> supplier=()->{return "hello";};
System.out.println(supplier.get());
```

###  Stream流式计算

大数据：存储+计算

集合、MySQL本质就是存储东西的

计算都应该交给流来操作！

```
Stream<T> filter(Predicate<? super T> predicate);
<R> Stream<R> map(Function<? super T, ? extends R> mapper);
Stream<T> sorted(Comparator<? super T> comparator);
Stream<T> limit(long maxSize);
```

```
list.stream().filter((u)->{
    return u.getId()%2==0;
})
.filter((u)->{return u.getAge()>23;})
.map((u)->{return u.getName().toUpperCase();})
.sorted((uu1,uu2)->{return  uu1.compareTo(uu2);})
.limit(1)
.forEach(System.out::println);
```

## ForkJoin详解

特点：工作窃取

我做完了 资源空出来 把别人的任务“偷”过来

双端队列

```
public void execute(ForkJoinTask<?> task) {
    if (task == null)
        throw new NullPointerException();
    externalPush(task);
}
```

ForkJoinTask的实现类：RecursiveAction 递归事件  没有返回值 

  RecursiveTask递归任务 有返回值

```
public abstract class RecursiveTask<V> extends ForkJoinTask<V> {
    private static final long serialVersionUID = 5232453952276485270L;

 
    V result;

 
    protected abstract V compute();

    public final V getRawResult() {
        return result;
    }

    protected final void setRawResult(V value) {
        result = value;
    }

    /**
     * Implements execution conventions for RecursiveTask.
     */
    protected final boolean exec() {
        result = compute();
        return true;
    }

}
```



```
public class ForkJoinLearning extends RecursiveTask<Long> {
    public ForkJoinLearning(Long start, Long end) {
        this.end = end;
        this.start = start;
    }

    private Long start;    //1
    private Long end; //19909000000

    //临界值
    private Long temp=10000L;




    //计算方法
    @Override
    protected Long compute()
    {
       if((end-start)<temp)
        {
            Long sum=0L;
            for (Long i = start; i <=end; i++) {
                    sum+=i;
            }
            return sum;

        }else
        {
            //分支合并计算
            //递归
            long middle = (end+start)/2;
            ForkJoinLearning test1=new ForkJoinLearning(start,middle);
            test1.fork(); //拆分任务，把任务压入线程队列
            ForkJoinLearning test2=new ForkJoinLearning(middle+1,end);
            test2.fork();
            return test1.join()+test2.join();
        }
    }
}
```





```
public class ForkJoinLearningTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //test1(); //6292
        //test2(); //1939
        test3(); //136
    }


    //普通程序员
    public static void test1()
    {
        Long sum = 0L;
        long start=System.currentTimeMillis();
        for (Long i=1L;i<=10_0000_0000L;i++)
        {
            sum+=i;
        }


        long end=System.currentTimeMillis();
        System.out.println("SUM= "+sum+"时间："+(end-start));
    }

    //会使用ForkJoin
    public static void test2 ()throws InterruptedException,ExecutionException
    {
        long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinLearning(0L,10_0000_0000L);
        ForkJoinTask<Long> submit=forkJoinPool.submit(task);

        Long sum=submit.get();


        long end=System.currentTimeMillis();
        System.out.println("SUM= "+sum+"时间："+(end-start));
    }

    //Stream并行流
    public static void test3()
    {
        long start=System.currentTimeMillis();
        //Stream并行流    rangeClosed (]  区间不同 和range
        long sum =LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0L, Long::sum);
        long end=System.currentTimeMillis();
        System.out.println("SUM= "+sum+"时间："+(end-start));
    }
}




Long::sum
 public static long sum(long a, long b) {
        return a + b;
    }
  T reduce(T identity, BinaryOperator<T> accumulator);
```



## 异步回调

每个线程上的不同任务所需时间不一样    调用者不需要等待被调用方法执行完成，而是可以继续执行其他任务。被调用的方法会在完成后，通过回调、通知或者某种机制告知调用者结果。

## Class  CompletableFuture<T>

- [java.lang.Object](../../../java/lang/Object.html) 
- - java.util.concurrent.CompletableFuture<T> 

- - All Implemented Interfaces: 

    [CompletionStage](../../../java/util/concurrent/CompletionStage.html)  <T>， [Future](../../../java/util/concurrent/Future.html) <T> 

```
public class YibuDemo {
    public static void main(String[] args)  throws InterruptedException,ExecutionException {

        //发起一个请求
        //没有返回值的runAsync异步回调
/*       CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(
               ()->{
                   try{
                       TimeUnit.SECONDS.sleep(2);
                   }catch (InterruptedException e)
                   {
                       e.printStackTrace();
                   }
                    System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
               });
        System.out.println("11111");
        completableFuture.get();  //获取阻塞执行结果*/
        //有返回值的异步回调 supplyAsync
        //ajax,成功和失败的回调
        //返回的是错误信息
        CompletableFuture<Integer> completableFuture= CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"==>Integer");
            int i=10/0;   //分母除0错误
            return 1024;});

        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t);   //t代表正常的返回结果
            System.out.println("u=>" + u);   //u代表异常错误信息
        }).exceptionally((e) -> {
            e.getMessage();
            return 233;   //可以获取到错误的返回结果
        }).get());
        
        /*
          succee code 200
          code 400
         */

    }
}
```







## JMM

Volatile是JAVA虚拟机提供**轻量级**的同步机制

1、保证可见性

2、不保证原子性

3、禁止指令重排



 什么是JMM

JMM：Java内存模型，不存在的东西，概念 约定





JMM的同步的约定：

1、线程解锁前，必须把共享变量立刻刷回主存

2、线程加锁前，必须读取主存中的最新值到工作内存中！

3、加锁和解锁是同一把锁



线程   工作内存、主内存

8种操作

1、Read操作

2、load操作

3、Use操作

4、assign操作

5、write操作

6、storage操作   

7、lock操作

8、Unlock操作

 先storage后write 图错了



![image-20241203173911423](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241203173911423.png)

问题：线程B修改了值 但是线程A不能及时可见 

引入volatile

 

- - lock   （锁定）：作用于主内存的变量，把一个变量标识为线程独占状态
  - unlock （解锁）：作用于主内存的变量，它把一个处于锁定状态的变量释放出来，释放后的变量才可以被其他线程锁定
  - read  （读取）：作用于主内存变量，它把一个变量的值从主内存传输到线程的工作内存中，以便随后的load动作使用
  - load   （载入）：作用于工作内存的变量，它把read操作从主存中变量放入工作内存中
  - use   （使用）：作用于工作内存中的变量，它把工作内存中的变量传输给执行引擎，每当虚拟机遇到一个需要使用到变量的值，就会使用到这个指令
  - assign （赋值）：作用于工作内存中的变量，它把一个从执行引擎中接受到的值放入工作内存的变量副本中
  - store  （存储）：作用于主内存中的变量，它把一个从工作内存中一个变量的值传送到主内存中，以便后续的write使用
  - write 　（写入）：作用于主内存中的变量，它把store操作从工作内存中得到的变量的值放入主内存的变量中

　　JMM对这八种指令的使用，制定了如下规则：

- - 不允许read和load、store和write操作之一单独出现。即使用了read必须load，使用了store必须write
  - 不允许线程丢弃他最近的assign操作，即工作变量的数据改变了之后，必须告知主存
  - 不允许一个线程将没有assign的数据从工作内存同步回主内存
  - 一个新的变量必须在主内存中诞生，不允许工作内存直接使用一个未被初始化的变量。就是怼变量实施use、store操作之前，必须经过assign和load操作
  - 一个变量同一时间只有一个线程能对其进行lock。多次lock后，必须执行相同次数的unlock才能解锁
  - 如果对一个变量进行lock操作，会清空所有工作内存中此变量的值，在执行引擎使用这个变量前，必须重新load或assign操作初始化变量的值
  - 如果一个变量没有被lock，就不能对其进行unlock操作。也不能unlock一个被其他线程锁住的变量
  - 对一个变量进行unlock操作之前，必须把此变量同步回主内存

问题：程序不知道主内存的值已经被修改过了



![image-20241203175030459](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241203175030459.png)

> volatile保证可见性

```
public class JMMLearning {
    private static volatile int  num=0;
    public static void main(String[] args) {//main


        new Thread(()->{   //线程1

            while(num==0)
            {

            }
        }).start();

        try{
            TimeUnit.SECONDS.sleep(1);
        }catch(InterruptedException e){
            e.printStackTrace();
        }

        num=1;
        System.out.println(num);
    }
}

```

> 不保证原子性

原子性： 不可分割

线程A 执行任务中  不可被打扰  也不能被分割。  要么同时成功 要么同时失败

```
public class VolatileLearning {


    private volatile   static  int num=0;
    public   static void add()
    {
        num++;
    }


    public static void main(String[] args) {
        //不保证原子性
        //理论上 number结果为两万 但实际不是
        //synchronized化方法能解决 加锁 能保证原子性
        //volatile化参数仍然不行 不保证原子性  只能看见 不能加锁
        //
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }


        while(Thread.activeCount()>2)  //main gc
        {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+":"+num);

    }
}
```

如果不加Lock和synchronized，怎么保证原子性？

使用原子类 来解决原子性问题

非常高效

原子类为什么那么高级  底层是C++ 本地方法

Unsafe类 是一个很特殊的存在

```
public final int getAndIncrement() {
    return unsafe.getAndAddInt(this, valueOffset, 1);
}
```

> 禁止指令重排

什么是指令重排

你写的程序，计算机并不是按照你写的那样去执行的。

源代码-- 编译器优化的重排--指令并行也可能会重排--内存系统也会重排--执行

**指令重排要考虑数据之间的依赖性**

~~~java	


int x=1;  //1

int y=2;  //2

x=x+5;  ///3

y=x*x; //4
我们所期望的 1234 但是 会变成2134  1324
    不可能是4123  
~~~



volatile可以避免指令重排

内存屏障

1、保证特定的操作的执行顺序

2、可以保证某些变量的内存可见性（利用这些特性volatile实现了可见性）

在单例模式用的最多



## 单例模式

### 饿汉式  DCL懒汉式



```
public class LazyLearning {

    private LazyLearning() {
        System.out.println(Thread.currentThread().getName()+"ok");
    }


    private volatile static LazyLearning lazyLearning; //volatile防止重排
    //双重检测锁模式的懒汉式单例  DCL懒汉式
    public static LazyLearning getInstance() {
        //要加锁
        if(lazyLearning == null) {
            synchronized(LazyLearning.class) {
                if (lazyLearning == null) {
            lazyLearning = new LazyLearning();
        }
            }
        }

        return lazyLearning;  //此时lazylearning还没有完成构造
    }

    //单线程下 确实单例OK
    //多线程
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                lazyLearning.getInstance();   //不是原子性操作
                /*
                1、分配内存空间
                2、执行构造方法，初始化对象
                3、把这个对象指向这个空间
                 */


            }).start();

        }

    }

}
```

也可以用静态内部类 但都是不安全的   反射可以破解

~~~java	
public class HolderLearning {

     private HolderLearning() {


     }
     public static HolderLearning getInstance() {
          return InnerClass.INSTANCE;
     }
     public static class InnerClass{

          private static final HolderLearning INSTANCE = new HolderLearning();
     }



}

~~~

### **静态内部类单例的特点**

1. **线程安全**：
   - Java 的类加载机制确保了类的加载过程是线程安全的。
   - 静态内部类 `InnerClass` 在第一次加载时，会初始化 `INSTANCE`，此时 Java 虚拟机会保证线程安全，不需要额外的同步。
2. **延迟加载**：
   - `HolderLearning` 的实例会在第一次调用 `getInstance()` 方法时初始化。
   - 如果不调用 `getInstance()` 方法，`InnerClass` 和 `INSTANCE` 永远不会加载，从而节省资源。
3. **高效**：
   - 通过静态内部类的机制，避免了双重检查锁（DCL）中同步的开销。
   - 同时又能实现懒加载的特性。



**反射**可以破解懒汉式单例模式，甚至可以破解大多数单例模式，包括常用的**饿汉式**和**静态内部类**实现。反射通过直接操作类的构造方法，可以无视访问权限，强行创建新的实例，从而破坏单例模式的唯一性。

```
Constructor<LazyLearning> declaredConstructor=LazyLearning.class.getDeclaredConstructor(null);
declaredConstructor.setAccessible(true);
LazyLearning lazyLearning2 = declaredConstructor.newInstance();
```

```
private LazyLearning() {
    synchronized (LazyLearning.class) {   //用标志加密  解决全部用反射的问题
        if(qinjiang==false)
        {
            qinjiang=true;
        }
        else  {
            throw new RuntimeException("不要试图使用反射破坏异常");
        }
    }

    System.out.println(Thread.currentThread().getName()+"ok");
}

private LazyLearning() {  //如果一个反射 一个正常 那用这个解决
        synchronized (LazyLearning.class) {
            if(lazyLearning != null) {
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }

        System.out.println(Thread.currentThread().getName()+"ok");
    }
```

```
//反射再次破坏上述的qinjiang信号量方法
public static void main(String[] args) throws Exception {
     
    Field qinjiang1 = LazyLearning.class.getDeclaredField("qinjiang");
    qinjiang1.setAccessible(true);

    Constructor<LazyLearning> declaredConstructor=LazyLearning.class.getDeclaredConstructor(null);
    declaredConstructor.setAccessible(true);
    LazyLearning lazyLearning2 = declaredConstructor.newInstance();
    qinjiang1.set(lazyLearning2, false);
    LazyLearning lazyLearning3 = declaredConstructor.newInstance();


    System.out.println(lazyLearning3);
    System.out.println(lazyLearning2);
    //反射可以破坏单例

}
```

**道高一尺魔高一丈!!**!!!

```
public T newInstance(Object ... initargs)
    throws InstantiationException, IllegalAccessException,
           IllegalArgumentException, InvocationTargetException
{
    if (!override) {
        if (!Reflection.quickCheckMemberAccess(clazz, modifiers)) {
            Class<?> caller = Reflection.getCallerClass();
            checkAccess(caller, clazz, null, modifiers);
        }
    }
    if ((clazz.getModifiers() & Modifier.ENUM) != 0)
        throw new IllegalArgumentException("Cannot reflectively create enum objects");
    ConstructorAccessor ca = constructorAccessor;   // read volatile
    if (ca == null) {
        ca = acquireConstructorAccessor();
    }
    @SuppressWarnings("unchecked")
    T inst = (T) ca.newInstance(initargs);
    return inst;
}
```

用枚举解决！  有参构造   String 和int 

```
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public enum EnumLearning {
    INSTANCE;

    public EnumLearning getEnumLearning() {

        return INSTANCE;
    }
}


class EnumTest
{
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        EnumLearning instance1 = EnumLearning.INSTANCE;
        Constructor<EnumLearning> declaredConstructor = EnumLearning.class.getDeclaredConstructor(String.class, int.class);  //无参构造是骗人的 真正是有参构造的
        declaredConstructor.setAccessible(true); //反射
        EnumLearning instance2 = declaredConstructor.newInstance();
        //EnumLearning instance2 = EnumLearning.INSTANCE;

        System.out.println(instance1);
        System.out.println(instance2);
    }
}
```



## 深入理解 CAS

什么是CAS  比较当前工作内存中的值和主内存中的值，如果这个值是期望的，那么则执行操作！ 如果不是就一直循环！  自带原子性

缺点：

1、循环会耗时

2、一次性只能保证一个共享变量的原子性

3、存在ABA问题

```
public final boolean compareAndSet(int expect, int update) {
    return unsafe.compareAndSwapInt(this, valueOffset, expect, update);
}
```

unsafe 类

```
public final int getAndIncrement() {
    return unsafe.getAndAddInt(this, valueOffset, 1);
}
```

![image-20241204163259572](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241204163259572.png)

```
public final int getAndAddInt(Object var1, long var2, int var4) {
    int var5;
    do {
        var5 = this.getIntVolatile(var1, var2);
    } while(!this.compareAndSwapInt(var1, var2, var5, var5 + var4));

    return var5;
}
自旋锁 

```

> ABA问题

狸猫换太子

![image-20241204165015291](C:\Users\Administrator\AppData\Roaming\Typora\typora-user-images\image-20241204165015291.png)

```
public class CASLearning {
    //CAS  compareAndSet比较并交换！
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(2020);
        //public final boolean compareAndSet(int expect, int update) {
        //
        // 期望、更新
        //如果期望值达到了 就更新 否则不更新  CAS是CPU的并发原语
        //对于我们平时写的SQL : 乐观锁！
        //捣乱的线程===================
        atomicInteger.compareAndSet(2020,2021);
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(2021, 2020));
        System.out.println(atomicInteger.get());


        //期望的线程===========================
        System.out.println(atomicInteger.compareAndSet(2020, 6666));
        System.out.println(atomicInteger.get());
    }
}
```

## 原子引用

带版本号的原子操作

解决ABA问题 引入原子引用  对应思想：乐观锁

```
public AtomicStampedReference(V initialRef, int initialStamp) {
    pair = Pair.of(initialRef, initialStamp);
}
```

```
//Interger  包装类的坑：使用了对象缓存机制，默认范围是-128至127
// 超过这个区间都不会复用已有对象  
//所有包装类的对比 都是用equals更好
```

```
public class CASLearning {
    //CAS  compareAndSet比较并交换！
    public static void main(String[] args) {
        //Interger  包装类的坑：使用了对象缓存机制，默认范围是-128至127
        // 超过这个区间都不会复用已有对象
        //所有包装类的对比 都是用equals更好
        //        AtomicInteger atomicInteger = new AtomicInteger(2020);
        AtomicStampedReference<Integer>  atomicInteger =
                new AtomicStampedReference<>(1,1);
        //public final boolean compareAndSet(int expect, int update) {
        //
        // 期望、更新
        //如果期望值达到了 就更新 否则不更新  CAS是CPU的并发原语
        //对于我们平时写的SQL : 乐观锁！
        //捣乱的线程===================
//        atomicInteger.compareAndSet(2020,2021);
//        System.out.println(atomicInteger.get());
//
//        System.out.println(atomicInteger.compareAndSet(2021, 2020));
//        System.out.println(atomicInteger.get());
//
//
//        //期望的线程===========================
//        System.out.println(atomicInteger.compareAndSet(2020, 6666));
//        System.out.println(atomicInteger.get());



        new Thread(()->{
            int stamp = atomicInteger.getStamp();//获得版本号
            System.out.println("a1=>"+stamp);
            try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            //version+1
            System.out.println(atomicInteger.compareAndSet(1, 2,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println("a2=>"+atomicInteger.getStamp());

            System.out.println(atomicInteger.compareAndSet(2, 1,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println("a3=>"+atomicInteger.getStamp());
        },"a").start();


         new Thread(()->{
            int stamp = atomicInteger.getStamp();//获得版本号
             System.out.println("b1=>"+stamp);
              try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

             System.out.println(atomicInteger.compareAndSet(1, 6,
                     stamp, stamp + 1));

             System.out.println("b2=>"+atomicInteger.getStamp());

        },"b").start();

    }
}
```



## 各种锁

公平锁：非常公平，不能插队 先来后到

非公平锁：非常不公平，可以插队    

默认非公平锁

可以重载

```
public ReentrantLock(boolean fair) {
    sync = fair ? new FairSync() : new NonfairSync();
}
```

### 可重入锁

递归锁  

```
//锁必须配对，否则就会死在里面
```

~~~java
public synchronized void method1() {
    System.out.println("Method 1");
    method2(); // 当前线程在持有锁时可以再次进入
}

public synchronized void method2() {
    System.out.println("Method 2");
}

~~~

### **可重入锁的优势**

1. 避免递归或嵌套调用中的死锁

   在递归函数或方法调用链中，锁不会因为多次被获取而阻塞线程。

2. 更高的灵活性

   可重入锁可以配合计数器机制，允许线程更灵活地处理加锁和解锁的逻辑。   

    

    

 **可重入锁**允许线程在持有锁的情况下再次获取同一把锁，这是并发编程中非常重要的特性，可以避免死锁问题，特别是在递归或嵌套调用中。



## 自旋锁

spinlock

```
public class ZiXuanLockLearning {
    // int 0
    //Thread null
    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    //加锁
    public void myLock()
    {
        Thread thread=Thread.currentThread();


        while(!atomicReference.compareAndSet(null,thread))
        {

        }
        System.out.println(Thread.currentThread().getName()+"==> mylock");
    }

    //解锁
    public void myUnlock()
    {
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"==> myunlock");
        atomicReference.compareAndSet(thread,null);

    }
}

```

```
public class ZiXuanLockTest {
    public static void main(String[] args) throws InterruptedException {
//        ReentrantLock reentrantLock = new ReentrantLock();
//        reentrantLock.lock();
//        reentrantLock.unlock();
//
        //底层使用的自旋锁 CAS

        ZiXuanLockLearning lock=new ZiXuanLockLearning();

        new Thread(()->{
            lock.myLock();
        try{
            TimeUnit.SECONDS.sleep(5);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.myUnlock();
        }

        },"T1").start();
        TimeUnit.SECONDS.sleep(1);
    ////////////////////
        new Thread(()->{
            lock.myLock();
            try{
             TimeUnit.SECONDS.sleep(1);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            lock.myUnlock();
        }


        },"T2").start();
//        lock.myLock();
//        lock.myUnlock();
    }
}
```

T2在自旋

运行情况：

T1==> mylock
T1==> myunlock
T2==> mylock
T2==> myunlock



## 死锁排查

怎么排除死锁

```
public class Deadlocklearning {
    public static void main(String[] args) {

        String lockA="lockA";
        String lockB="lockB";

        new Thread(new MyThreadB(lockA,lockB),"T1").start();
        new Thread(new MyThreadB(lockB,lockA),"T2").start();
    }
}





class MyThreadB implements Runnable {

    private String lockA;
    private String lockB;

    public  MyThreadB(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "lock:" +
                    lockA+"==>get"+lockB);

            try{TimeUnit.SECONDS.sleep(2);}
            catch(InterruptedException e){
                e.printStackTrace();
            }


            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "lock:" +
                    lockB+"==>get"+lockA);

            }
        }
    }
}
```

> 解决问题

1、使用jps -l定位进程号

D:\Document\JAVA>jps -l
78628 Deadlocklearning
79572 sun.tools.jps.Jps
21292 
31388 org.jetbrains.jps.cmdline.Launcher





2、使用 jstack  +进程号    查看进行信息

Java stack information for the threads listed above:

"T2":
        at MyThreadB.run(Deadlocklearning.java:42)
        - waiting to lock <0x0000000716d8f588> (a java.lang.String)
                - locked <0x0000000716d8f5c0> (a java.lang.String)
                at java.lang.Thread.run(Unknown Source)
        "T1":
                at MyThreadB.run(Deadlocklearning.java:42)
                - waiting to lock <0x0000000716d8f5c0> (a java.lang.String)
                        - locked <0x0000000716d8f588> (a java.lang.String)
                        at java.lang.Thread.run(Unknown Source)

Found 1 deadlock.

排查问题：

1、日志

2、堆栈信息
