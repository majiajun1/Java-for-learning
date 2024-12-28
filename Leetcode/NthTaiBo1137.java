public class NthTaiBo1137 {
    public static void main(String[] args) {

        int n=4;
        System.out.println(tribonacci(n));

    }

    public static int tribonacci(int n) {
        if(n == 0)return 0;
        if(n < 3)return 1;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];

    }
}
