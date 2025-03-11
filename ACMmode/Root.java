import java.util.Scanner;

public class Root {
//
//    static int Min=Integer.MAX_VALUE;
//    static int count=0;
    public static void main(String[] args) { //DFS?  DFS太慢   只能DP
//        Scanner in = new Scanner(System.in);
//        // 注意 hasNext 和 hasNextLine 的区别
//        int n=in.nextInt();
//        int[][] ticket=new int[n][n];
//        int ans=0;
//        for(int i=0;i<n;i++)
//        {
//            in.nextLine();
//            for(int j=0;j<n;j++)
//            {
//                ticket[i][j]=in.nextInt();
//            }
//        }

        int n = 4;
        int[] visited = new int[n];
        int[][] ticket = {
                {0, 2, 6, 5},
                {2, 0, 4, 4},
                {6, 4, 0, 2},
                {5, 4, 2, 0}
        };
        int[][] dp= new int[n+1][n];
        for(int i=0; i<n; i++){
            dp[i][0] = 0;
        }


    }
//        count=n;
//
//
//
//        for(int i=1;i<n;i++)
//        {
//            visited[i]=1;
//            count--;
//            DFS(0,i,ticket,0,visited );
//            count++;
//            visited[i]=0;
//
//        }
//        System.out.println(Min);
//
//
//    }
//    public static void DFS(int now,int next,int[][] ticket,int nowsum,int[] visited )
//    {
//        int sum=nowsum+ticket[now][next];
//        visited[next]=1;
//
//        if(count==1)
//        {
//            sum=sum+ticket[next][0];
//            if(sum<Min)
//            {
//                Min=sum;
//            }
//            return;
//        }else
//        {
//            for(int i=1;i<visited.length;i++)
//            {
//                if(visited[i]!=1)
//                {
//                    count--;
//                    DFS(next,i,ticket,sum,visited );
//                    count ++;
//                }
//            }
//        }
//        visited[next]=0;
//    }
}
