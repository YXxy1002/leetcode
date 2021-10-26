package _04.dp;

/**
 * 309. 最佳买卖股票时机含冷冻期
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: dp: 当天操作完后最大收益 dp[i][0] = 当天操作完后持有股票, dp[i][1] = 当天操作完后不持有股票,且之后处于冷冻期 dp[i][2] = 当天操作完后不持有股票,且之后不处于冷冻期
 * @since 2021-10-26 16:16:03
 */
public class BestTimeToBuyAndSellStockWithCooldown {
    public int maxProfit(int[] prices) {
        // 0持有 1不持有,冷冻(说明当天卖出了) 2不持有,非冷冻(当天没操作)
        int[][] dp = new int[prices.length][3];
        dp[0][0] = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            dp[i][1] = dp[i - 1][0] + prices[i];
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        return Math.max(dp[prices.length - 1][1], dp[prices.length - 1][2]);
    }
}