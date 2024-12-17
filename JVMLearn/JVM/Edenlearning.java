package JVM;
import java.util.Random;
public class Edenlearning {
    public static void main(String[] args) {
       String str="asas";
//-Xms8m -Xmx8m -XX:+PrintGCDetails

       while(true)
       {
           str+=str+new Random().nextInt(89888888)+new Random().nextInt(99999999);

       }
    }

//[GC (Allocation Failure) [PSYoungGen: 1529K->496K(2048K)] 1529K->815K(7680K), 0.0011605 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//[GC (Allocation Failure) [PSYoungGen: 1840K->510K(2048K)] 2159K->1243K(7680K), 0.0005586 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//[GC (Allocation Failure) [PSYoungGen: 1499K->416K(2048K)] 2232K->1940K(7680K), 0.0004696 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//[GC (Allocation Failure) [PSYoungGen: 1718K->416K(2048K)] 3242K->2889K(7680K), 0.0005911 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//[GC (Allocation Failure) [PSYoungGen: 1716K->512K(2048K)] 5455K->4908K(7680K), 0.0005875 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//[GC (Allocation Failure) --[PSYoungGen: 1178K->1178K(2048K)] 5574K->6215K(7680K), 0.0008119 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//[Full GC (Ergonomics) [PSYoungGen: 1178K->0K(2048K)] [ParOldGen: 5037K->2132K(5632K)] 6215K->2132K(7680K), [Metaspace: 3322K->3322K(1056768K)], 0.0028287 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//[Full GC (Ergonomics) [PSYoungGen: 1326K->0K(2048K)] [ParOldGen: 4664K->3851K(5632K)] 5990K->3851K(7680K), [Metaspace: 3334K->3334K(1056768K)], 0.0046460 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//[Full GC (Ergonomics) [PSYoungGen: 1326K->0K(2048K)] [ParOldGen: 5117K->3218K(5632K)] 6444K->3218K(7680K), [Metaspace: 3334K->3334K(1056768K)], 0.0043593 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//[GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] 3218K->3218K(7680K), 0.0003046 secs] [Times: user=0.00 sys=0.00, real=0.00 secs]
//[Full GC (Allocation Failure) [PSYoungGen: 0K->0K(2048K)] [ParOldGen: 3218K->3194K(5632K)] 3218K->3194K(7680K), [Metaspace: 3334K->3334K(1056768K)], 0.0047724 secs] [Times: user=0.02 sys=0.00, real=0.01 secs]
//Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
}
