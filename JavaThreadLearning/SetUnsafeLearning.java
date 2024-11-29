import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CopyOnWriteArraySet;


//一样并发修改异常

public class SetUnsafeLearning {
    public static void main(String[] args) {
       // HashSet<String> set = new HashSet<>();
        //Set<String> set = Collections.synchronizedSet(new HashSet<>());
       //Set<String> set = new CopyOnWriteArraySet<>();
       Set<String> set =ConcurrentHashMap.newKeySet();
        /*
        解决方法：
        1.Collection类转化
        2.JUC写法
        3.

         */
        for (int i = 0; i < 30; i++) {
            new Thread(()->{
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();

        }

    }
}
