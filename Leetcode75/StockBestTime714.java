public class StockBestTime714 {
    public static void main(String[] args) {
        int[] prices={1,3,2,8,4,9};
        int fee=2;
        System.out.println(maxProfit(prices,fee));
    }


    public static int maxProfit(int[] prices, int fee) {
        int n=prices.length;

        int[][] dp=new int[n ][2];
        dp[0][0]=0;
        dp[0][1]=-prices[0];
        for(int i=1;i<n;i++) {
            dp[i][0]=Math.max(dp[i-1][0],dp[i-1][1]+prices[i]-fee);
            dp[i][1]=Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        }

        return dp[n-1][0];
    }

     public static int maxProfit2(int[] prices, int fee) {
        int n = prices.length;
        int sell = 0, buy = -prices[0];
        for (int i = 1; i < n; ++i) {
            sell = Math.max(sell, buy + prices[i] - fee);
            buy = Math.max(buy, sell - prices[i]);
        }
        return sell;
    }

}
