import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockLearningB2 {
     public static void main(String[] args) {
        PhoneB2 phoneB2 = new PhoneB2();

        new Thread(()->{
            phoneB2.sms();

        },"A").start();


        new Thread(()->{
            phoneB2.sms();

        },"B").start();
    }

}







class PhoneB2{

    Lock lock = new ReentrantLock();

      public void sms() {
          lock.lock();   //细节问题 两把锁
          //锁必须配对，否则就会死在里面
        try {
            System.out.println(Thread.currentThread().getName() + "sms");
            call();
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
        lock.unlock();
        }


      }
      public void call()
      {
          lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "call");
        }
        catch (Exception e) {
            e.printStackTrace();
        }finally {
        lock.unlock();
        }

      }
}