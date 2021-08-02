package _02.sort.selectction;

/**
 * 215. 数组中的第K个最大元素
 *
 * @author xieyu
 * @keywords: 选择排序
 * @ideas:
 * @since 2021-7-10 20:14:32
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        for (int i = 0; i < nums.length - 1; i++) {
            int select = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[select]) {
                    select = j;
                }
            }
            if (i == k - 1) {
                return nums[select];
            }
            swap(nums, select, i);
        }
        // 到这里说明数组是有序的  没有经过排序
        return nums[k - 1];
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}