package _01.binarySearch;


/**
 * 不动点
 *
 * @author xieyu
 * @keywords: 找出arr[i]大于等于i的第一个数(左边界)
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class FixedPoint {
    public int fixedPoint(int[] arr) {
        int l = 0, r = arr.length - 1;

        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] >= mid) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        if (arr[l] == l) {
            return l;
        } else {
            return -1;
        }
    }
}