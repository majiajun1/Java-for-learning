
import java.util.concurrent.*;

public class CallableLearning {
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        //new Thread(new MyThread()).start(); Runable不能用了

        //new Thread().start();
        MyThread2 thread = new MyThread2();

        //适配类
        FutureTask futureTask = new FutureTask(thread);

        new Thread(futureTask, "A").start();
         new Thread(futureTask, "B").start(); //会打印几个call? 一个 结果会被缓存，效率高


            Integer o = (Integer) futureTask.get();  //get方法可能会产生阻塞 把他放到最后
        //或者使用异步通信来处理！
            System.out.println(o);

    }

}

/*
class MyThread implements Runnable {

    public void run() {

    }
}
*/

class MyThread2 implements Callable<Integer>{

    public Integer call(){
        System.out.println("Call()");
        //假设是耗时的操作 返回可能会产生阻塞
        return 1024;
    }
}