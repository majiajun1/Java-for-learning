
public class LockLearningB {
    //synchronized 默认非公平

    public static void main(String[] args) {
        PhoneB phoneB = new PhoneB();

        new Thread(()->{
            phoneB.sms();

        },"A").start();


        new Thread(()->{
            phoneB.sms();

        },"B").start();
    }

}



class PhoneB{

  public synchronized void sms()
  {
      System.out.println(Thread.currentThread().getName()+"sms");
      call();
  }

  public synchronized void call()
  {
      System.out.println(Thread.currentThread().getName()+"call");
  }


}