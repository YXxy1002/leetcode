package _04.dp;

/**
 * 53. 最大子序和
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: dp:以当前位置为结束的数组的最大子序和  状态转移: dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
 * @since 2021-7-6 21:24:57
 */
public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], nums[i] + dp[i - 1]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}