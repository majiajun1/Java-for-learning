import java.util.Arrays;

public class BuySellStock121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }


     public static int maxProfit(int[] prices) {
         int[][] dp = new int[prices.length][2];
         dp[0][0] = -prices[0];
         dp[0][1] = 0;
         for (int i = 1; i < prices.length; i++) {
             dp[i][0] = Math.max(dp[i-1][0],  - prices[i]); //只能买卖一次
             dp[i][1] = Math.max(prices[i]+dp[i-1][0], dp[i-1][1]);
         }

        return dp[prices.length-1][1];
     }

}
