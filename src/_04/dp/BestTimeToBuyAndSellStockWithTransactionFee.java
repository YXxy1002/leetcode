package _04.dp;

/**
 * 714. 买卖股票的最佳时机含手续费
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: dp: 不同状态对应的最大收益 dp[i][0]:当天买入股票后的最大收益  dp[i][1]:当天不持有股票(有可能卖出,有可能不操作)的最大收益
 * @since 2021-10-26 16:32:54
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {
    public int maxProfit(int[] prices, int fee) {
        // 0持有 //1不持有
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i]);
            int p = dp[i - 1][0] + prices[i] - fee;
            if (p >= 0) { // 收益大于0, 更新
                dp[i][1] = Math.max(dp[i - 1][1], p);
            } else { // 收益小于0, 说明支付不起手续费, 当天不能操作
                dp[i][1] = dp[i - 1][1];
            }
        }
        return dp[n - 1][1];
    }
}