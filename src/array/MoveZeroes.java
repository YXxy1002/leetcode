package array;

/**
 * 283. 移动零
 *
 * @author xieyu
 * @keywords: 双指针
 * @ideas: 同27题思路, 不同的是需要交换元素
 * @since 2022-3-3 11:03:21
 */
public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int l = 0, r = 0;
        while (l < nums.length) {
            if (nums[l] != 0) {
                swap(nums, l, r);
                r++;
            }
            l++;
        }
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}