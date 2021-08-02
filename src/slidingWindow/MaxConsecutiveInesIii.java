package slidingWindow;

/**
 * 最大连续1的个数 III
 *
 * @author xieyu
 * @keywords: 滑动窗口
 * @ideas:
 * @since 2021-7-10 20:14:32
 */
public class MaxConsecutiveInesIii {
    public int longestOnes(int[] nums, int k) {
        int l = 0, zeroCount = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            // 当0的个数超过限制时左指针滑动
            if (zeroCount > k) {
                // 把l移动到取消一个0为止
                while (nums[l] == 1) {
                    l++;
                }
                l += 1;
                zeroCount--;
            }
            // 每次都要计算当前最大1的个数
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}