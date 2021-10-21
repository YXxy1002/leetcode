package _04.dp;

/**
 * 152. 乘积最大子数组
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: dp: 包含该位置的最大乘积  状态转移: dp[i] = Math.max(nums[i],Math.max(minPro,maxPro)) 需要一个dpMin来记录最小乘积,用来处理当前位置是负数的场景
 * @since 2021-7-6 21:24:57
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int length = nums.length;
        int[] dpMax = new int[length];
        int[] dpMin = new int[length];
        dpMax[0] = nums[0];
        dpMin[0] = nums[0];
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int minPro = dpMin[i - 1] * nums[i];
            int maxPro = dpMax[i - 1] * nums[i];
            dpMax[i] = Math.max(nums[i], Math.max(minPro, maxPro));
            dpMin[i] = Math.min(nums[i], Math.min(minPro, maxPro));
            ans = Math.max(ans, dpMax[i]);
        }
        return ans;
    }
}