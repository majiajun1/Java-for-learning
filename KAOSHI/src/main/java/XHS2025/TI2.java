package XHS2025;

import java.util.ArrayList;
import java.util.*;
import java.util.Scanner;
public class TI2
{
    static final int MOD=1000000000+7;

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int num= sc.nextInt();
        StringBuilder result=new StringBuilder();


        for (int i = 0; i < num; i++) {
            long n = sc.nextLong();

            long a=sc.nextLong();
            long b=sc.nextLong();
            long c =sc.nextLong();
            List<String> resList=new ArrayList<>();
            for(long k=1;k<=n;k++)
            {
                long count=backtrack(k,a,b,c,new ArrayList<>());
                resList.add(String.valueOf(count%MOD));
            }
            result.append(String.join(" ",resList)).append("\n");



        }
        System.out.println(result.toString());
    }

    private static long backtrack(long k,long a,long b,long c,List<Long> current)
      {
        if(k==0)
        {
            for(int i=0;i<current.size()-1;i++)
            {
                if(current.get(i)==a&&current.get(i+1)==c)
                {
                    return 0;
                }
            }
            return 1;
        }
          long count=0;
          if(k>=a)
          {
              List<Long> newCurrent=new ArrayList<>(current);
              newCurrent.add(a);
              count=(count+backtrack(k-a,a,b,c,newCurrent))%MOD;
          }
           if(k>=b)
          {
              List<Long> newCurrent=new ArrayList<>(current);
              newCurrent.add(b);
              count=(count+backtrack(k-b,a,b,c,newCurrent))%MOD;
          }
          if(k>=c)
          {
              List<Long> newCurrent=new ArrayList<>(current);
              newCurrent.add(c);
              count=(count+backtrack(k-c,a,b,c,newCurrent))%MOD;
          }
          return count;
      }
}