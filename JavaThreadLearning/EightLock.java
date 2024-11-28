
/*

  8锁 就是八个锁的问题
  1、标准情况下 两个线程先打电话还是先短信？答案是先发短信然后打电话 原因是锁的问题

  2、sendSms延迟4秒，还是先打吗？ 依然是先发短信再打电话
 */


import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class EightLock {

    public static void main(String[] args) {
        Phone phone=new Phone();

        new Thread(()->{
            phone.sendSms();},"A").start();

       try{
           TimeUnit.SECONDS.sleep(1);}
       catch(InterruptedException e){
           e.printStackTrace();
       }

        new Thread(()->{
            phone.call();},"B").start();


    }


}


class Phone
{
    //synchronized的对象是方法的调用者
    //两个方法用的是同一个锁，谁先拿到谁执行  A先拿到锁
    //
    public synchronized void sendSms()
    {
        try {
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("sendSms");
    }

    public synchronized void call()
    {
        System.out.println("call");
    }
}