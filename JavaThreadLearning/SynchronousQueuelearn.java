import java.sql.Time;
import java.util.concurrent.*;

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
