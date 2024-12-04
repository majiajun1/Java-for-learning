

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.*;


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
