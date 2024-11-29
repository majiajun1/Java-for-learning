import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapunsafeLearning {
    public static void main(String[] args) {

        //Map是这样用的吗？默认等价于什么？
        //工作中不用Hashmap

        //Map<String,String> map = new HashMap<>();
        //加载因子、初始化容量
        //0.75、16

        //Collections.synchronizedMap(map);实现不了
        //没有copyonwrite

        Map<String,String> map = new ConcurrentHashMap<>();
        for(int i=0;i<=30;i++)
        {
            new Thread(()-> {
                map.put(Thread.currentThread().getName()
                        ,UUID.randomUUID().toString().substring(0,5));
                System.out.println(map);
            },String.valueOf(i)).start();
        }

    }
}
