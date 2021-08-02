package _01.binarySearch;


/**
 * x 的平方根
 *
 * @author xieyu
 * @keywords: 二分查找
 * @ideas: 1.找出平方小于x的最大的数 2.使用寻找右边界的模板
 * @since 2021-7-6 21:24:57
 */
public class Sqrtx {
    public int mySqrt(int x) {
        int l = 0, r = x;
        while (l < r) {
            int mid = (l + r + 1) / 2;
            if (x / mid >= mid) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return l;
    }
}