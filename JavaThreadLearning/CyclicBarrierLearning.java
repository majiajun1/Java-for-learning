import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierLearning {
    public static void main(String[] args) {
        //召唤龙珠的线程

        CyclicBarrier cyclicBarrier = new CyclicBarrier(2,
                ()->{System.out.println("召唤神龙成功");});


        for (int i = 1; i <=7; i++) {
            final int num = i;
            new Thread(()->{      //类操作不了i 只能用中间变量
                //System.out.println(num);
                System.out.println(Thread.currentThread().getName()+"收集第"+num+"个龙珠");
        try{
                cyclicBarrier.await();}
        catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
            }).start();

        }


    }
}
