


//懒汉式单例

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

public class LazyLearning {

    private static boolean qinjiang=false;
    //用锁解决反射问题
    //那如果 都用反射呢？
    private LazyLearning() {
        synchronized (LazyLearning.class) {
            if(qinjiang==false) {
                qinjiang=true;
            }else
            {
                throw  new RuntimeException("不要试图使用反射破坏异常");
            }
        }

        System.out.println(Thread.currentThread().getName()+"ok");
    }


    private volatile static LazyLearning lazyLearning;
    //双重检测锁模式的懒汉式单例  DCL懒汉式
    public static LazyLearning getInstance() {
        //要加锁
        if(lazyLearning == null) {
            synchronized(LazyLearning.class) {
                if (lazyLearning == null) {
            lazyLearning = new LazyLearning();
        }
            }
        }

        return lazyLearning;  //此时lazyman还没有完成构造
    }

    //单线程下 确实单例OK
    //多线程
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(()->{
//                lazyLearning.getInstance();   //不是原子性操作
//                /*
//                1、分配内存空间
//                2、执行构造方法，初始化对象
//                3、把这个对象指向这个空间
//                 */
//
//
//            }).start();
//
//        }
    //反射
    public static void main(String[] args) throws Exception {
        //LazyLearning lazyLearning = LazyLearning.getInstance();
        Field qinjiang1 = LazyLearning.class.getDeclaredField("qinjiang");
        qinjiang1.setAccessible(true);

        Constructor<LazyLearning> declaredConstructor=LazyLearning.class.getDeclaredConstructor(null);
        declaredConstructor.setAccessible(true);
        LazyLearning lazyLearning2 = declaredConstructor.newInstance();
        qinjiang1.set(lazyLearning2, false);
        LazyLearning lazyLearning3 = declaredConstructor.newInstance();


        System.out.println(lazyLearning3);
        System.out.println(lazyLearning2);
        //反射可以破坏单例

    }

}
