
/*

  8锁 就是八个锁的问题
7、普通同步方法+静态同步方法    先call后发短信 一个对象
原因是：前者是锁方法调用者  后者锁class  两个锁

8.两个对象+普通同步方法+静态同步方法    先打电话
跟7一样

其实他说的不明白 static是锁多对象的  不static是锁单对象的    static锁的类模板 所有这个类调用这个方法时只有一个实例能用这个方法  而普通方法锁的是调用者 一般只对同一个对象有用
9、自己新加的 两种方法 同一对象调用两个方法：
先call 原因是两把锁 同7
 */


import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class EightLockD {

    public static void main(String[] args) {
        Phone4 phone=new Phone4();
        Phone4 phone2=new Phone4();

        //两个对象的class类模板只有一个，static锁的是class

        new Thread(()->{
            phone2.sendSms();},"A").start();

       try{
           TimeUnit.SECONDS.sleep(1);}
       catch(InterruptedException e){
           e.printStackTrace();
       }

        new Thread(()->{
            phone2.call();},"B").start();


    }


}

//Phone3 唯一的一个class对象
class Phone4
{
    //synchronized的对象是方法的调用者
    // static 静态方法
    //类一加载就有了 锁的是class 所有实例都会只有这一把锁


    public static synchronized void sendSms()
    {
        try {
            TimeUnit.SECONDS.sleep(4);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" sendSms");
    }

    public synchronized void call() //锁的调用者
    {

        System.out.println(Thread.currentThread().getName()+" call");
    }



}