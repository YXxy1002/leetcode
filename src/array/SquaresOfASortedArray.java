package array;

/**
 * 977. 有序数组的平方
 *
 * @author xieyu
 * @keywords: array
 * @ideas: 头尾指针
 * @since 2022-3-3 11:03:21
 */
public class SquaresOfASortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        // 从头尾开始遍历,大的放res尾部
        int l = 0, r = nums.length - 1, cur = r;
        while (l <= r) {
            int ll = nums[l] * nums[l];
            int rr = nums[r] * nums[r];
            if (ll >= rr) {
                res[cur] = ll;
                l++;
            } else {
                res[cur] = rr;
                r--;
            }
            cur--;
        }
        return res;
    }
}