package JVM;

public class Duitest {
    public static void main(String[] args) {
        long max=Runtime.getRuntime().maxMemory();
        System.out.println(max/(double)1024/1024); //默认1/4
        long total=Runtime.getRuntime().totalMemory();
        System.out.println(total/(double)1024/1024); //默认 1/64

        //调堆的大小
        //JVM 堆内存的初始大小。   JVM 堆内存的最大大小。   打印详细的垃圾回收日志输出。
        //-Xms1024m -Xmx1024m -XX:+PrintGCDetails
        //305664K+699392K =1005056k=981.5MB
    }
}
