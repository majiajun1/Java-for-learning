import java.util.concurrent.atomic.AtomicInteger;

public class VolatileLearning {


    //private volatile   static  int num=0;
    private volatile static AtomicInteger num=new AtomicInteger();
    public   static void add()
    {
         //num++;
        //num++不是原子性操作
        num.getAndIncrement();  //atomicinteger +1方法


    }


    public static void main(String[] args) {
        //不保证原子性
        //理论上 number结果为两万 但实际不是
        //synchronized化方法能解决 能保证原子性
        //volatile化参数仍然不行 不保证原子性  只能看见 不能加锁
        //
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }


        while(Thread.activeCount()>2)  //main gc
        {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+":"+num);

    }
}
