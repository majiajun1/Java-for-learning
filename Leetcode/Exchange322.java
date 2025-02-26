import java.util.Arrays;

public class Exchange322 {
    public int coinChange(int[] coins, int amount) {


        int[] dp = new int[amount + 1];
        Arrays.fill(dp,0);

        dp[0] = 0;


        for (int coin : coins) {
            for (int j = coin; j <= amount; j++) {
                dp[j] = Math.max(dp[j], dp[j - coin] + 1);
            }
        }

        return dp[amount] == amount + 1 ? -1 : dp[amount];



    }
}
