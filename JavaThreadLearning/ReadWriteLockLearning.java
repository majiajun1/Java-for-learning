import java.nio.channels.ScatteringByteChannel;
import java.util.concurrent.*;
import java.util.*;
import java.util.concurrent.locks.*;

/**
 * 独占锁（写锁）
 * 共享锁（读锁）
 * 读-读可以共存
 * 读-写不能共存
 * 写-写不能共存
 */
public class ReadWriteLockLearning {
    public static void main(String[] args) {
        //MyCache myCache = new MyCache();
        MyCacheLock myCache=new MyCacheLock();

        for (int i =  1; i < 5; i++) {

            final int temp = i;
            new Thread(() -> {
                myCache.put(temp+"",temp+"");
            }, String.valueOf(i)).start();
        }

        //读取
        for (int i = 1; i < 5; i++) {

            final int temp = i;
            new Thread(() -> {
                myCache.get(temp+"");
            }, String.valueOf(i)).start();
        }
    }
}


/**
 * 自定义缓存
 *
 */

class MyCache{

    private volatile Map<String,Object> map= new HashMap<>();
    //存， 写
    public void put(String key,Object value){
        System.out.println(Thread.currentThread().getName()+"写入"+key);
        map.put(key,value);
        System.out.println(Thread.currentThread().getName()+"写入OK");

    }


    //取，读
    public void get(String key){
        System.out.println(Thread.currentThread().getName()+"读取"+key);
        Object o=map.get(key);
        System.out.println(Thread.currentThread().getName()+"读取OK");

    }

}

class MyCacheLock{

    private volatile Map<String,Object> map= new HashMap<>();
    private Lock lock= new ReentrantLock(); //普通锁

    //读写锁 更细粒度的控制
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //存， 写 只希望同时只有一个线程写 所有人都可以读
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "写入" + key);
            map.put(key, value);
            System.out.println(Thread.currentThread().getName() + "写入OK");
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeLock().unlock();
        }
    }


    //取，读
    public void get(String key) {
        readWriteLock.readLock().lock();

        try {
            System.out.println(Thread.currentThread().getName() + "读取" + key);
            Object o = map.get(key);
            System.out.println(Thread.currentThread().getName() + "读取OK");

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readLock().unlock();
        }
    }

}