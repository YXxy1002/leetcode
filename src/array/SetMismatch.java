package array;

/**
 * 简单
 * 相关标签
 * 相关企业
 * 集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有一个数字重复 。
 * <p>
 * 给定一个数组 nums 代表了集合 S 发生错误后的结果。
 * <p>
 * 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,4]
 * 输出：[2,3]
 * 示例 2：
 * <p>
 * 输入：nums = [1,1]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 104
 * 1 <= nums[i] <= 104
 */
public class SetMismatch {
    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 4};
        int[] errorNums = findErrorNums(ints);
    }

    public static int[] findErrorNums(int[] nums) {
        // 用一个新数组记录每个数字出现次数,注意数字1对应的下标是0
        int[] arr = new int[nums.length];
        for (int num : nums) {
            arr[num - 1] += 1;
        }
        int[] res = new int[2];
        // 新数组中计数为2的是重复数字,记得+1
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 2) {
                res[0] = i + 1;
            }
            if (arr[i] == 0) {
                res[1] = i + 1;
            }
        }
        return res;
    }
}