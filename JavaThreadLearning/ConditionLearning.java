

import java.util.concurrent.locks.*;

public class ConditionLearning {
    public static void main(String[] args) {
        Data3 data = new Data3();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        },"C").start();

    }





}




/*
 A执行完 调用B  B执行完调用C   C执行完调用A

 */
class Data3{
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();


    private int number=1;  //1A  2B 3C
    public void printA()
    {
        lock.lock();
        try {
            //业务代码，判断->执行->通知
            while(number!=1)
            {
                //等待
                condition1.await();
            }
            System.out.println(Thread.currentThread().getName()+"AAAAAA");
            //唤醒,只唤醒指定的人 B
            number=2;
            condition2.signal();
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        finally {
            lock.unlock();
        }

    }

    public void printB()
    {
        lock.lock();
        try {
            //业务代码，判断->执行->通知
                while(number!=2)
            {
                //等待
                condition2.await();
            }
            System.out.println(Thread.currentThread().getName()+"BBBBBBBB");
            //唤醒,只唤醒指定的人 B
            number=3;
            condition3.signal();
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        finally {
            lock.unlock();
        }
    }
    public void printC()
    {
        lock.lock();
        try {
            //业务代码，判断->执行->通知
               while(number!=3)
            {
                //等待
                condition3.await();
            }
            System.out.println(Thread.currentThread().getName()+"CCCCCCC");
            //唤醒,只唤醒指定的人 B
            number=1;
            condition1.signal();
        }
        catch (Exception e) {
            e.printStackTrace();

        }
        finally {
            lock.unlock();
        }
    }

        //生产线：下单->支付->交易->物流


}
