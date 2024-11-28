
/*

  8锁 就是八个锁的问题
 3、 增加了一个普通方法 没有synchronized  先发短信还是hello？ 先hello然后发短信
 原因：hello没有上锁 不是同步方法 不受锁的影响
 4、两个对象 两个同步方法  先call 后send  锁的是方法调用者 有两个调用者 互相不影响
    A延迟了4秒  A慢一点


 */


import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class EightLockB {

    public static void main(String[] args) {
        Phone2 phone=new Phone2();
        Phone2 phone2=new Phone2();
        //两个对象

        new Thread(()->{
            phone.sendSms();},"A").start();

       try{
           TimeUnit.SECONDS.sleep(1);}
       catch(InterruptedException e){
           e.printStackTrace();
       }

        new Thread(()->{
            phone2.call();},"B").start();


    }


}


class Phone2
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


    public void hello(){ //没有synchronized
        System.out.println("hello");
    }
}