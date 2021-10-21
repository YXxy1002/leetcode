package _04.dp;

/**
 * 1014. 最佳观光组合
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: 因为 values[i] + values[j] + i - j = values[i] + i + values[j] - j, 所以随着遍历进行可以把values[i] + i的最大值记录下来, 后面的景点只要跟最大值比较结果就行
 * @since 2021-7-6 21:24:57
 */
public class BestSightseeingPair {
    public static int maxScoreSightseeingPair(int[] values) {
        int ans = values[0];
        int max = ans;
        for (int i = 1; i < values.length; i++) {
            ans = Math.max(ans, values[i] - i + max);
            max = Math.max(max, values[i] + i);
        }
        return ans;
    }
}