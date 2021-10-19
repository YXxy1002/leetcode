package _04.dp;

/**
 * 198. 打家劫舍
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: dp:当前能偷到的最高金额, 状态转移: dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i])
 * @since 2021-7-6 21:24:57
 */
public class HouseRobber {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 1) {
            return nums[0];
        }
        int[] dp = new int[length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[length - 1];
    }
}