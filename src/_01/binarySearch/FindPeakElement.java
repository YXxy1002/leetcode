package _01.binarySearch;

/**
 * 寻找峰值
 *
 * @author xieyu
 * @keywords: 二分查找
 * @ideas:
 * @since 2021-7-16 20:22:33
 */
public class FindPeakElement {
    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) / 2;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}