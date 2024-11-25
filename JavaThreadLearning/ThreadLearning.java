public class ThreadLearning {
    public static void main(String[] args) {
         new MyThread().start();  //测试重写的mythread  继承 耦合度高
         Runnable runnable = new Runnable1();
         Thread thread = new Thread(runnable);
         thread.start();
         Runnable runnable2 = new Runnable2();
         Thread thread2 = new Thread(runnable2);  //谁拿到CPU资源谁先实行
         thread2.start();



         Thread thread3 = new Thread(new Runnable() {  //匿名内部类
             @Override
             public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("runnable3==");
                }
             }
         });
         thread3.start();


         Thread thread4 = new Thread(()->{
             for (int i = 0; i < 10; i++) {
                 System.out.println("runnable4==");
             }
         });
         thread4.start();

         new Thread(()->{
             for (int i = 0; i < 10; i++) {
                 System.out.println("runnable5==");
             }
         }).start();





         Thread t1=new Thread(()->{for (int i = 0; i < 10; i++) {System.out.println("t1==");}});
         t1.start();

         try{
             t1.sleep(1000); // sleep写在main方法 所以休眠的是main 与调用者无关

         }catch (InterruptedException e){
             e.printStackTrace();
         }


         Thread t2=new Thread(()->{for (int i = 0; i < 10; i++) {System.out.println("t2==");}});
         t2.start();

    }

}
