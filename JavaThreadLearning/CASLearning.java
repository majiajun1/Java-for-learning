import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CASLearning {
    //CAS  compareAndSet比较并交换！
    public static void main(String[] args) {
        //Interger  包装类的坑：使用了对象缓存机制，默认范围是-128至127
        // 超过这个区间都不会复用已有对象
        //所有包装类的对比 都是用equals更好
        //        AtomicInteger atomicInteger = new AtomicInteger(2020);
        AtomicStampedReference<Integer>  atomicInteger =
                new AtomicStampedReference<>(1,1);
        //public final boolean compareAndSet(int expect, int update) {
        //
        // 期望、更新
        //如果期望值达到了 就更新 否则不更新  CAS是CPU的并发原语
        //对于我们平时写的SQL : 乐观锁！
        //捣乱的线程===================
//        atomicInteger.compareAndSet(2020,2021);
//        System.out.println(atomicInteger.get());
//
//        System.out.println(atomicInteger.compareAndSet(2021, 2020));
//        System.out.println(atomicInteger.get());
//
//
//        //期望的线程===========================
//        System.out.println(atomicInteger.compareAndSet(2020, 6666));
//        System.out.println(atomicInteger.get());



        new Thread(()->{
            int stamp = atomicInteger.getStamp();//获得版本号
            System.out.println("a1=>"+stamp);
            try{
                TimeUnit.SECONDS.sleep(1);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            Lock lock = new ReentrantLock();
            //version+1
            System.out.println(atomicInteger.compareAndSet(1, 2,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println("a2=>"+atomicInteger.getStamp());

            System.out.println(atomicInteger.compareAndSet(2, 1,
                    atomicInteger.getStamp(), atomicInteger.getStamp() + 1));
            System.out.println("a3=>"+atomicInteger.getStamp());
        },"a").start();


         new Thread(()->{
            int stamp = atomicInteger.getStamp();//获得版本号
             System.out.println("b1=>"+stamp);
              try{
                TimeUnit.SECONDS.sleep(2);
            }catch (InterruptedException e){
                e.printStackTrace();
            }

             System.out.println(atomicInteger.compareAndSet(1, 6,
                     stamp, stamp + 1));

             System.out.println("b2=>"+atomicInteger.getStamp());

        },"b").start();

    }
}
