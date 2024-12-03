import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class ForkJoinLearningTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //test1(); //6292
        //test2(); //1939
        test3(); //136
    }


    //普通程序员
    public static void test1()
    {
        Long sum = 0L;
        long start=System.currentTimeMillis();
        for (Long i=1L;i<=10_0000_0000L;i++)
        {
            sum+=i;
        }


        long end=System.currentTimeMillis();
        System.out.println("SUM= "+sum+"时间："+(end-start));
    }

    //会使用ForkJoin
    public static void test2 ()throws InterruptedException,ExecutionException
    {
        long start=System.currentTimeMillis();
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> task=new ForkJoinLearning(0L,10_0000_0000L);
        ForkJoinTask<Long> submit=forkJoinPool.submit(task);

        Long sum=submit.get();


        long end=System.currentTimeMillis();
        System.out.println("SUM= "+sum+"时间："+(end-start));
    }

    //Stream并行流
    public static void test3()
    {
        long start=System.currentTimeMillis();
        //Stream并行流    rangeClosed (]  区间不同 和range
        long sum =LongStream.rangeClosed(0L, 10_0000_0000L).parallel().reduce(0L, Long::sum);
        long end=System.currentTimeMillis();
        System.out.println("SUM= "+sum+"时间："+(end-start));
    }
}
