package _02.sort.quick;

/**
 * 169. 多数元素
 *
 * @author xieyu
 * @keywords: 排序 投票
 * @ideas:
 * @since 2021-8-10 09:51:27
 */
public class MajorityElement {
    /**
     * 因为众数大于n/2,所以数组排序后的n/2位置一定是众数
     *
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length / 2];
    }

    /**
     * 投票选择法: 维护一个candidate和count,如果是candidate count++,如果不是就--,当count=0的时候更换candidate
     * 和投票一样,超过半数的人最后一定会当选
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        int candidate = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        return candidate;
    }


    private void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int i = l, j = r;
        while (i < j) {
            while (i < j && nums[j] >= nums[l]) {
                j--;
            }
            while (i < j && nums[i] <= nums[l]) {
                i++;
            }
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, i, l);
        quickSort(nums, l, i - 1);
        quickSort(nums, i + 1, r);
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}