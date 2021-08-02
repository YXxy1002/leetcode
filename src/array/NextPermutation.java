package array;

/**
 * 下一个排列
 *
 * @author xieyu
 * @keywords: 从后开始遍历
 * @ideas: 从i=arr.length-1开始,从后往前遍历,直到arr[i]>arr[i-1],说明可以交换位置得到一个更大的数,但并不是交换这2个位置,
 * 而是从i之后找第一个比i-1大的数进行交换,交换完成后还要注意将i之后的数降序一些以得到最小的数据
 * @since 2021/6/21 0021 上午 11:35
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        // 从后往前, 先找出可以交换的2个数
        int i = nums.length - 1;
        while (i >= 1) {
            if (nums[i] > nums[i - 1]) {
                // 找到了相邻的两个数,但不是直接交换,要找i后面比i-1大的第一个数进行交换,这样才能保证交换之后的数最小
                int j = nums.length - 1;
                while (j > i - 1) {
                    if (nums[j] > nums[i - 1]) {
                        // 找到了第一个数,交换,并降序排列之后的数字
                        swap(nums, j, i - 1);
                        reverse(nums, i);
                        return;
                    }
                    j--;
                }
            }
            i--;
        }
        // 没有找到可交换的数,说明此时数组已经是最大,直接交换
        reverse(nums, i);
    }

    private void reverse(int[] nums, int begin) {
        int i = begin;
        int j = nums.length - 1;
        while (j > i) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }


    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}