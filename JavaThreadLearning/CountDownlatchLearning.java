import java.util.concurrent.CountDownLatch;

public class CountDownlatchLearning {
    public static void main(String[] args) throws InterruptedException {
        //倒计时 总是是6
        //执行任务的时候再使用
        CountDownLatch countDownLatch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName()+"Go out");
                countDownLatch.countDown();//数量减一
            },String.valueOf(i)).start();
        }
        countDownLatch.await();//等待计数器归零 然后向下执行 没这个 就提前关门了
        System.out.println("close door");

    }
}
