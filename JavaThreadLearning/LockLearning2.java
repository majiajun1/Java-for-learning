import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockLearning2 {

    public static void main(String[] args) {


        //并发：多线程操作同一资源类  把资源类丢入线程
        Ticket2 ticket = new Ticket2();

        //@FunctionalInterface 函数式接口, jdk1.8  lambda表达式 ()->{代码}
        new Thread(
                ()->{  for(int i=1;i<40;i++){ticket.sale();}},"A"
        ).start();
        new Thread(()->{for(int i=1;i<40;i++){ticket.sale();}},"B").start();
        new Thread(()->{ for(int i=1;i<40;i++){ticket.sale();}},"C").start();


    }
}

// 资源类OOP
//1、 new ReentrantLock();
//2、 lock.lock(); 加锁
//3  finally  unlock 解锁
class Ticket2
{
    //属性、方法
    private int number=30;
    Lock lock=new ReentrantLock();

    //卖票方法
     public   void sale()  //传统synchronized  本质：队列、锁
     {
         lock.lock();

         //lock.tryLock();

         try {
             //业务代码在这里
             if (number > 0) {
                 System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票,剩余: " + number);
             }
         }
         catch (Exception e) {
             e.printStackTrace();
         }finally {

             lock.unlock();
         }
     }
}

