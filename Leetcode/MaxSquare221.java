public class MaxSquare221 {
     public int maximalSquare(char[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        int ans=0;
        for(int i=0;i<n;i++)
        {
            for (int j=0;j<m;j++)
            {
                 if(matrix[i][j]=='1')
                 {
                     if (i==0||j==0) {   //思路是 一个正方形可以退化成一个点的状态
                         //对角线元素，上面的元素和左边的元素  一个初始的2x2正方形，如果上下 左上都是1 则 2x2正方形都为1成立
                         //保存这个状态     左上对角线都为1，上面都是1，左面都是1，则成立。
                         dp[i][j] = 1;  //给两个边初始化
                     }else
                     {
                         dp[i][j] = Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]))+1;

                     }
                    ans=Math.max(ans,dp[i][j]);
                 }
            }
        }
        return ans*ans;
    }
}
