package array;

/**
 * 453. 最小操作次数使数组元素相等
 * 给你一个长度为 n 的整数数组，每次操作将会使 n - 1 个元素增加 1 。返回让数组所有元素相等的最小操作次数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：3
 * 解释：
 * 只需要3次操作（注意每次操作会增加两个元素的值）：
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1,1]
 * 输出：0
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * 答案保证符合 32-bit 整数
 */
public class MinimumMovesToEqualArrayElements {
    public static void main(String[] args) {
        int[] ints = {1, 2, 3};
        int i = minMoves(ints);
    }

    public static int minMoves(int[] nums) {
        // 基本原理:使 n - 1 个元素增加1相当于将某个元素减1其他的不变,所以题目变成计算所有元素和最小元素的差值
        int min = nums[0];
        for (int j : nums) {
            min = Math.min(min, j);
        }
        int res = 0;
        for (int num : nums) {
            if (num != min) {
                res += num - min;
            }
        }
        return res;
    }
}
