import java.sql.Time;
import java.util.concurrent.TimeUnit;

public class Deadlocklearning {
    public static void main(String[] args) {

        String lockA="lockA";
        String lockB="lockB";

        new Thread(new MyThreadB(lockA,lockB),"T1").start();
        new Thread(new MyThreadB(lockB,lockA),"T2").start();
    }
}





class MyThreadB implements Runnable {

    private String lockA;
    private String lockB;

    public  MyThreadB(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA) {
            System.out.println(Thread.currentThread().getName() + "lock:" +
                    lockA+"==>get"+lockB);

            try{TimeUnit.SECONDS.sleep(2);}
            catch(InterruptedException e){
                e.printStackTrace();
            }


            synchronized (lockB) {
                System.out.println(Thread.currentThread().getName() + "lock:" +
                    lockB+"==>get"+lockA);

            }
        }
    }
}