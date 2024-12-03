

/*
求和计算的任务！
3000  6000(Forkjoin)   9000(Stream) 工资
  如何使用forkjoin
  1、forkjoinPool  通过它来执行
  2、计算任务 forkjoinPool.execute(ForkJoinTask<?> task)
  3、计算类要继承ForkJoinTask

 */


import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinLearning extends RecursiveTask<Long> {
    public ForkJoinLearning(Long start, Long end) {
        this.end = end;
        this.start = start;
    }

    private Long start;    //1
    private Long end; //19909000000

    //临界值
    private Long temp=10000L;




    //计算方法
    @Override
    protected Long compute()
    {
       if((end-start)<temp)
        {
            Long sum=0L;
            for (Long i = start; i <=end; i++) {
                    sum+=i;
            }
            return sum;

        }else
        {
            //分支合并计算
            //递归
            long middle = (end+start)/2;
            ForkJoinLearning test1=new ForkJoinLearning(start,middle);
            test1.fork(); //拆分任务，把任务压入线程队列
            ForkJoinLearning test2=new ForkJoinLearning(middle+1,end);
            test2.fork();
            return test1.join()+test2.join();
        }
    }
}
