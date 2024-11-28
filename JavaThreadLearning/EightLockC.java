
/*

  8锁 就是八个锁的问题
 5、两个静态方法的同步方法 只有一个对象  先发短信 然后打电话

  6、两个对象 两个静态方法的同步方法  先发短信 再打电话
 
 */


import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class EightLockC {

    public static void main(String[] args) {
        Phone3 phone1=new Phone3();
        Phone3 phone2=new Phone3();

        //两个对象的class类模板只有一个，static锁的是class

        new Thread(()->{
            phone1.sendSms();},"A").start();

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
class Phone3
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
        System.out.println("sendSms");
    }

    public static synchronized void call()
    {
        System.out.println("call");
    }



}