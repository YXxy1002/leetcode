package _04.dp;

/**
 * 45. 跳跃游戏 II
 *
 * @author xieyu
 * @keywords: dp表示到达i处所需最少步数, dp[i] = dp[earliest]+1, earliest表示最早能一步到达i处的位置, earliest在nums[earliest] + earliest < i的时候增加
 * @ideas: dp:
 * @since 2021-7-6 21:24:57
 */
public class JumpGameIi {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        int earliest = 0;
        for (int i = 1; i < nums.length; i++) {
            while (nums[earliest] + earliest < i) {
                earliest++;
            }
            dp[i] = dp[earliest] + 1;
        }
        return dp[dp.length - 1];
    }
}