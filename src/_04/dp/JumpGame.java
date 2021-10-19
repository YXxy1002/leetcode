package _04.dp;

/**
 * 55. 跳跃游戏
 *
 * @author xieyu
 * @keywords: dp表示当前位置能跳的最大步数, 如果dp[i]=0表示无法跳, dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
 * @ideas: dp:
 * @since 2021-7-6 21:24:57
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] == 0) {
                return false;
            }
            dp[i] = Math.max(dp[i - 1] - 1, nums[i]);
            if (dp[i] + i >= nums.length) {
                return true;
            }
        }
        return true;
    }
}