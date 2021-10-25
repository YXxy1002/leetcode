package _04.dp;

/**
 * 121. 买卖股票的最佳时机
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: 一边记录最小值, 一边记录利润最大值
 * @since 2021-7-6 21:24:57
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            res = Math.max(res, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return res;
    }
}