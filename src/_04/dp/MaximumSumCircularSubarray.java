package _04.dp;

/**
 * 918. 环形子数组的最大和
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: 1.子数组在中间部分, 相当于求最大子序和 2.子数组在头尾, 相当于数组总和减去中间(最小子序和)
 * @since 2021-7-6 21:24:57
 */
public class MaximumSumCircularSubarray {
    public int maxSubarraySumCircular(int[] nums) {
        int pre1 = nums[0];
        int pre2 = nums[0];
        int max = nums[0];
        int min = nums[0];
        int arrSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int tmp1 = nums[i] + pre1;
            pre1 = nums[i] > tmp1 ? nums[i] : tmp1;
            max = max > pre1 ? max : pre1;
            int tmp2 = nums[i] + pre2;
            pre2 = nums[i] < tmp2 ? nums[i] : tmp2;
            min = min < pre2 ? min : pre2;
            arrSum += nums[i];
        }
        // 特殊情况, 数组全是负数, 应该返回max, 而不是min
        if (max < 0) {
            return max;
        }
        return Math.max(max, arrSum - min);
    }
}