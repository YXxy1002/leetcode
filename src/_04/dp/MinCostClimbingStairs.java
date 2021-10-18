package _04.dp;

/**
 * 746. 使用最小花费爬楼梯
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: dp[i] 表示达到下标 ii 的最小花费。状态转移: dp[i] = Math.min(dp[i-2]+cost[i-2],dp[i-1]+cost[i-1])
 * @since 2021-7-6 21:24:57
 */
public class MinCostClimbingStairs {
//    public int minCostClimbingStairs(int[] cost) {
//        int pre = 0;
//        int cur = 0;
//        for (int i = 2; i <= cost.length; i++) {
//            int sum = Math.min(cost[i - 1] + cur, cost[i - 2] + pre);
//            pre = cur;
//            cur = sum;
//        }
//        return cur;
//    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        dp[0] = dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}