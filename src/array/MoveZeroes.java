package array;

/**
 * 283. 移动零
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 示例 2:
 * <p>
 * 输入: nums = [0]
 * 输出: [0]
 * <p>
 * <p>
 * 提示:
 * <p>
 * 1 <= nums.length <= 104
 * -231 <= nums[i] <= 231 - 1
 * <p>
 * <p>
 * 进阶：你能尽量减少完成的操作次数吗？
 */
public class MoveZeroes {
    public static void main(String[] args) {
        int[] ints = {1,2,0,0,5,5,6,0,0,1,1,2,0};
        moveZeroes(ints);
        System.out.println(111);
    }

    public static void moveZeroes(int[] nums) {
        // i遍历,j指向0
        int i = 0, j = 0;
        while (i < nums.length) {
            // 将j指向下一个0
            while (j < nums.length && nums[j] != 0) {
                j++;
            }
            // i不等于0且比j大
            if (nums[i] != 0 && i > j) {
                swap(nums, i, j);
            }

            i++;
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}