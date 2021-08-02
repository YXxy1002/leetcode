package _02.sort.bubble;

/**
 * 283. 移动零
 *
 * @author xieyu
 * @keywords: 双指针
 * @ideas:
 * @since 2021/07/29 下午 8:26
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int l = 0, r = 0, len = nums.length;
        while (r < len) {
            if (nums[r] != 0) {
                swap(nums, l, r);
                l++;
            }
            r++;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}