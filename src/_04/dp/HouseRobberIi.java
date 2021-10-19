package _04.dp;

/**
 * 213. 打家劫舍 II
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: dp:当前能偷到的最高金额, 状态转移: dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]), 在打家劫舍 I的基础上, res = Math.max(去掉数组第一个,去掉数组最后一个)
 * @since 2021-7-6 21:24:57
 */
public class HouseRobberIi {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob(int[] nums, int start, int end) {
        int ans = 0;
        int pre = 0;
        int prePre = 0;
        for (int i = start; i <= end; i++) {
            ans = Math.max(pre, nums[i] + prePre);
            prePre = pre;
            pre = ans;
        }
        return ans;
    }
}