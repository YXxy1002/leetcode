package _04.dp;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: dp: 当天卖出或者买入后的最大收益 dp[i][0] = 当天买入股票后的最大收益, dp[i][1] = 当天卖出股票后的最大收益
 * @since 2021-7-6 21:24:57
 */
public class BestTimeToBuyAndSellStockIi {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        for(int i=1; i<prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][1]-prices[i],dp[i-1][0]);
            dp[i][1] = Math.max(dp[i-1][0]+prices[i],dp[i-1][1]);
        }
        return dp[prices.length-1][1];
    }
}