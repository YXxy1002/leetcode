package _01.binarySearch;

/**
 * 367. 有效的完全平方数
 *
 * @author xieyu
 * @keywords: 二分查找
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class ValidPerfectSquare {
    public boolean isPerfectSquare(int num) {
        int l = 1, r = num;
        while (l <= r) {// 闭区间,所以要用<=而不是<
            int mid = l + (r - l) / 2;
            long product = (long) mid * mid;
            if (product == num) {
                return true;
            } else if (product > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
