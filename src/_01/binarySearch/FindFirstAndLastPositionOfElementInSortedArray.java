package _01.binarySearch;

import java.util.Arrays;

/**
 * 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author xieyu
 * @keywords: 二分查找
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class FindFirstAndLastPositionOfElementInSortedArray {
    public int[] searchRange(int[] nums, int target) {
        int firstTarget = bs(nums, target);
        int firstTargetAdd1 = bs(nums, target + 1);
        if (nums[firstTarget] == target) {
            if (nums[firstTargetAdd1] > target) {
                return new int[]{firstTarget, firstTargetAdd1 - 1};
            } else {
                return new int[]{firstTarget, firstTargetAdd1};
            }
        }
        return new int[]{-1, -1};
    }

    private int bs(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


}