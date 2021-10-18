package _04.dp;

/**
 * 1137. 第 N 个泰波那契数
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: 状态转移: dp[i] = dp[i-1] + dp[i-2] + dp[i-3]
 * @since 2021-7-6 21:24:57
 */
public class NThTribonacciNumber {
    public int tribonacci(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int prePre = 0;
        int pre = 1;
        int cur = 1;
        for (int i = 3; i <= n; i++) {
            int sum = prePre + pre + cur;
            prePre = pre;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}