public class Stock309 {

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][4];
        //4个状态分别表示持有股票、不持有股票且当天卖出后处于冷冻期、不持有股票且不处于冷冻期、不持有股票且处于冷冻期
        dp[0][0] = -prices[0];//其余初始化为0
        for(int i=1;i<prices.length;++i){
            dp[i][0] = Math.max(dp[i-1][0],Math.max(dp[i-1][2]-prices[i],dp[i-1][3]-prices[i]));
            dp[i][1] = dp[i-1][0] + prices[i];
            dp[i][2] = Math.max(dp[i-1][2],dp[i-1][3]);
            dp[i][3] = dp[i-1][1];
        }

        return Math.max(dp[prices.length-1][1],Math.max(dp[prices.length-1][2],dp[prices.length-1][3]));//当天卖出、当天不持有、当天冷冻期


    }


}
