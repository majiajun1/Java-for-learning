/**
 * 异步调用：Ajax
 * //异步执行
 * //成功回调
 * //失败回调
 *
 * 现在用的是CompletableFuture
 */
import java.sql.SQLOutput;
import java.util.concurrent.*;


public class YibuDemo {
    public static void main(String[] args)  throws InterruptedException,ExecutionException {

        //发起一个请求
        //没有返回值的runAsync异步回调
/*       CompletableFuture<Void> completableFuture=CompletableFuture.runAsync(
               ()->{
                   try{
                       TimeUnit.SECONDS.sleep(2);
                   }catch (InterruptedException e)
                   {
                       e.printStackTrace();
                   }
                    System.out.println(Thread.currentThread().getName()+"runAsync=>Void");
               });
        System.out.println("11111");
        completableFuture.get();  //获取阻塞执行结果*/
        //有返回值的异步回调 supplyAsync
        //ajax,成功和失败的回调
        //返回的是错误信息
        CompletableFuture<Integer> completableFuture= CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"==>Integer");
            int i=10/0;
            return 1024;});

        System.out.println(completableFuture.whenComplete((t, u) -> {
            System.out.println("t=>" + t);   //t代表正常的返回结果
            System.out.println("u=>" + u);   //u代表异常错误信息
        }).exceptionally((e) -> {
            e.getMessage();
            return 233;   //可以获取到错误的返回结果
        }).get());

        /*
          succee code 200
          code 400
         */

    }
}
