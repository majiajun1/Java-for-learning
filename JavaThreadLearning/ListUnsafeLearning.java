import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

//并发修改异常

public class ListUnsafeLearning {

    public static void main(String[] args) {
        //List<String> list = new ArrayList<String>();
        //List<String> list = new Vector<>();
        //并发下 arraylist不安全的
        /*
        解决方法：
        1.用vector解决
        2.用synchronized解决？想多了 vector底层已经帮你写好了
        3.直接使用collections库的安全版
        4.JUC的方案
         */
        //List<String> list = Collections.synchronizedList(new ArrayList<>());
        List<String> list = new CopyOnWriteArrayList<>();
        //CopyOnWrite 写入时复制  COW   计算机程序设计优化策略
        //多个线程调用的时候，list，读取的时候，固定的，写入（覆盖）
        //在写入的时候避免覆盖 ，造成数据问题
        //读写分离
        // CopyOnWriteArrayList<>() 比vector厉害在哪里？
        //有synchronized的方法 速度慢一点  而前者用的LOCK锁，写入时复制
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(list);
            },String.valueOf(i)).start();

        }

    }
}
