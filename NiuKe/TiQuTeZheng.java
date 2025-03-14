import java.util.*;

public class TiQuTeZheng {
public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();

        for (int i=1;i<=n;i++)
        {
            int max=1;
            int N=in.nextInt();
            HashMap<Integer,HashMap<Integer, int[]>> map=new HashMap<>();

            for(int j=0;j<N;j++)
            {

                int Tezheng=in.nextInt();
                if(Tezheng==0)
                {
                    continue;
                }

                for(int k=0;k<Tezheng;k++)
                {
                    int a=in.nextInt();
                    Integer b=in.nextInt();
                    if(!map.containsKey(a))
                    {
                        map.put(a,new HashMap<>());
                        HashMap<Integer, int[]> map2 = map.get(a);



                        map2.put(b,new int[]{j,1});

                    }else
                    {
                         HashMap<Integer, int[]> map2 = map.get(a);

                        if(!map2.containsKey(b))
                         {
                             map2.put(b,new int[]{j,1});

                         }else
                         {
                              int[] record=map2.get(b);
                              if(record[0]==j-1)
                              {
                                  record[1]=record[1]+1;
                                  record[0]=j;
                                  if(record[1]>max)
                                  {
                                    max=record[1];
                                  }
                              }else
                              {
                                  record[1]=1;
                                  record[0]=j;
                              }
                         }

                    }

                }
            }





            System.out.println(max);

        }

    }
}
