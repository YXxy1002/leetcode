package _04.dp;

/**
 * 70. 爬楼梯
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: 状态转移: dp[i] = dp[i-1] + dp[i-2]
 * @since 2021-7-6 21:24:57
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) {
            return n;
        }
        int pre = 1;
        int cur = 2;
        for (int i = 3; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}