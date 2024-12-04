
//自选锁


import java.util.concurrent.atomic.AtomicReference;

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
