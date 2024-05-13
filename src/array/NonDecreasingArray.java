package array;

/**
 * 665. 非递减数列
 * 中等
 * 相关标签
 * 相关企业
 * 给你一个长度为 n 的整数数组 nums ，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * <p>
 * 我们是这样定义一个非递减数列的： 对于数组中任意的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,2,3]
 * 输出: true
 * 解释: 你可以通过把第一个 4 变成 1 来使得它成为一个非递减数列。
 * 示例 2:
 * <p>
 * 输入: nums = [4,2,1]
 * 输出: false
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * <p>
 * <p>
 * 提示：
 * <p>
 * n == nums.length
 * 1 <= n <= 104
 * -105 <= nums[i] <= 105
 */
public class NonDecreasingArray {
    public static void main(String[] args) {
        int[] ints = {1,4,1,2};
        boolean b = checkPossibility(ints);
        System.out.println(111);
    }

    public static boolean checkPossibility(int[] nums) {
        // 基本原理:计算有几个数字破坏了递增的特性
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                // 如果第2个数字破坏了,则将第1个数字改变
                if (i == 1) {
                    nums[i - 1] = nums[i];
                } else {
                    // 如果第3个及以后的数字破坏了,如果当前数字比前2个数字小,那就必须改当前数字,如果比前2个数字大就可以改上一个数字,注意
                    // 当前数字和前2个数字相等的情况,这种情况应该改上一个数字 . 一切都是为了让数字更小来保证递增的特性
                    if (nums[i] < nums[i - 2]) {
                        nums[i] = nums[i - 1];
                    } else {
                        nums[i - 1] = nums[i];
                    }
                }
                cnt++;
            }
            if (cnt > 1) {
                return false;
            }
        }
        return true;
    }
}
