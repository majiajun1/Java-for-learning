public class DuoMiNuo790 {
    public static void main(String[] args) {
        int n=5;
        System.out.println(numTilings(5));

    }


   static int MOD = (int)1e9+7;
    public static int  numTilings(int n) {
        int[][] dp = new int[n + 10][4];

        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % MOD + dp[i - 1][2]) % MOD + dp[i - 1][3]) % MOD;
        }
        return dp[n][3];
    }
}
