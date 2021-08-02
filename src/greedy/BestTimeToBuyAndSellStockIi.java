package greedy;


/**
 * 122. 买卖股票的最佳时机 II
 *
 * @author xieyu
 * @keywords: 贪心
 * @ideas: 每步的利益都要获取
 * @since 2021-7-6 21:24:57
 */
public class BestTimeToBuyAndSellStockIi {


    public int maxProfit(int[] prices) {
        if (prices.length == 1) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int p = prices[i] - prices[i - 1];
            if (p > 0) {
                profit += p;
            }
        }
        return profit;
    }
}