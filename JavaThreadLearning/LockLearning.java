/**
*公司的开发 要降低耦合性
*线程就是一个单独的资源类 没有任何附属的操作
*1、属性、方法
*/
public class LockLearning {
    public static void main(String[] args) {


        //并发：多线程操作同一资源类  把资源类丢入线程
        Ticket ticket = new Ticket();

        //@FunctionalInterface 函数式接口, jdk1.8  lambda表达式 ()->{代码}
        new Thread(
                ()->{  for(int i=1;i<40;i++){ticket.sale();}},"A"
        ).start();
        new Thread(()->{for(int i=1;i<40;i++){ticket.sale();}},"B").start();
        new Thread(()->{ for(int i=1;i<40;i++){ticket.sale();}},"C").start();


    }
}

// 资源类OOP
class Ticket
{
    //属性、方法
    private int number=30;

    //卖票方法
     public synchronized void sale()  //传统synchronized  本质：队列、锁
     {
         if(number>0)
         {
             System.out.println(Thread.currentThread().getName()+"卖出了"+(number--)+"票,剩余: "+number);
         }
     }
}