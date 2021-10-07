package _04.dp;

/**
 * 509. 斐波那契数
 *
 * @author xieyu
 * @keywords: dp
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class FibonacciNumber {
    public int fib(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        int pre = 0;
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            int sum = pre + cur;
            pre = cur;
            cur = sum;
        }
        return cur;
    }
}