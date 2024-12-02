import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


// Executors 工具类
//使用了线程池之后 要使用线程池来创建线程
public class ThreadLakeLearning {
    public static void main(String[] args) {
        Executors.newSingleThreadExecutor(); //单个线程
       // Executors.newFixedThreadPool(5); //创建固定的线程池大小
       // Executors.newCachedThreadPool();//可伸缩的


        //ExecutorService threadPool = Executors.newSingleThreadExecutor();
        //ExecutorService threadPool  = Executors.newFixedThreadPool(5);
        //ExecutorService threadPool  = Executors.newCachedThreadPool();
        System.out.println(Runtime.getRuntime().availableProcessors());



        ExecutorService threadPool = new ThreadPoolExecutor(2,5,
                3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(3),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy() );

        try{
        for (int i = 0; i < 15; i++) { //最大承载：Deque+max
            //用了线程池 不用new Thread
            threadPool.execute(()->{
                System.out.println(Thread.currentThread().getName()+" OK");
            });
        }}
        catch(Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();

        }

        //线程池用完 程序结束 要关闭线程池

    }
}
