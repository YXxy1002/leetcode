package queue;

import java.util.ArrayDeque;

/**
 * 239. 滑动窗口最大值
 *
 * @author xieyu
 * @keywords: 单调队列  滑动窗口
 * @ideas:
 * @since 2021-7-10 20:14:32
 */
public class SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            // 如果i>=k,就要从左侧删除一个元素
            if (!queue.isEmpty() && i >= k && queue.peek() == nums[i - k]) {
                queue.poll();
            }
            // 保证单调
            int num = nums[i];
            while (!queue.isEmpty() && queue.peekLast() < num) {
                queue.pollLast();
            }
            // 加入元素
            queue.offer(num);

            if (i >= k - 1) {
                res[i - k + 1] = queue.peek();
            }
        }
        return res;
    }
}