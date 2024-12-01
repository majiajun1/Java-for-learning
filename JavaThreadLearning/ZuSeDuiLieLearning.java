import java.util.Collections;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.TimeUnit;

public class ZuSeDuiLieLearning {
    public static void main(String[] args) throws InterruptedException  {
        //List
        //Set
        //BlockingQueue 不是新东西
        //test1();
        //test2();
        //test3();
        test4();

    }

    /**
     * 抛出异常
     */
    public static void test1() {

        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);

        System.out.println( blockingQueue.add("a"));
        System.out.println( blockingQueue.add("b"));
        System.out.println( blockingQueue.add("c"));
        //.IllegalStateException 多了
        //System.out.println( blockingQueue.add("c"));

        System.out.println( "===============");

        System.out.println( blockingQueue.remove());
        System.out.println( blockingQueue.remove());
        System.out.println( blockingQueue.remove());
        //查队首 空则异常
        //System.out.println( blockingQueue.element());
        //NoSuchElementException   队列空
        //System.out.println( blockingQueue.remove());
    }

    public static void test2() {

        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        System.out.println( blockingQueue.offer("a"));
        System.out.println( blockingQueue.offer("b"));
        System.out.println( blockingQueue.offer("c"));
        //offer方法 不抛异常，返回false
        //System.out.println( blockingQueue.offer("d"));

        System.out.println( "=================");

        System.out.println( blockingQueue.poll());
        System.out.println( blockingQueue.poll());
        System.out.println( blockingQueue.poll());
        //System.out.println( blockingQueue.peek());
        //
        //空的 返回Null
        //System.out.println( blockingQueue.poll());


    }

    /**
     * 等待 阻塞
     * 1、一直等待
     * 2、等待超时
     */
    public static void test3() throws InterruptedException
    {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        //一直阻塞
        blockingQueue.put("a");
        blockingQueue.put("b");
        blockingQueue.put("c");
        //blockingQueue.put("d"); //没有位置 不会返回值和异常
        // 一直等

        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.take());
        //System.out.println(blockingQueue.take()); //队列空 也会一直等待

    }

    public static void test4() throws InterruptedException
    {
        ArrayBlockingQueue blockingQueue = new ArrayBlockingQueue<>(3);
        //一直阻塞
        blockingQueue.put("a");
        blockingQueue.add("b");
        blockingQueue.put("c");
        blockingQueue.offer("d",3, TimeUnit.SECONDS);

        System.out.println("=================");
        //System.out.println(blockingQueue.take());
        //System.out.println(blockingQueue.take());
        //System.out.println(blockingQueue.take());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(2,TimeUnit.SECONDS)); //到时就不等了


    }
}
