import java.lang.*;
import java.util.concurrent.locks.*;

public class ProducerAndconsumerB  {
    public static void main(String[] args) {
    Data2 data = new Data2();
    new Thread(()->{ for (int i=0;i<10;i++)
        {
            try{
                data.increment();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        },"A").start();

         new Thread(()->{for (int i=0;i<10;i++)
        {
            try{
                data.decrement();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

         },"B").start();

          new Thread(()->{for (int i=0;i<10;i++)
        {
            try{
                data.increment();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

         },"C").start();

           new Thread(()->{for (int i=0;i<10;i++)
        {
            try{
                data.decrement();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

         },"D").start();
    }

}


//等待，业务，通知

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


}