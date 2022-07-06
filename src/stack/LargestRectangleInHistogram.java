package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 84. 柱状图中最大的矩形
 *
 * @author xieyu
 * @keywords: 单调栈
 * @ideas: 栈顶和栈顶的下一个元素以及要入栈的三个元素组成了我们要求最大面积的高度和宽度
 * @since 2021-7-10 20:14:32
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] heights) {
        // 给数组左右各加一个元素处理边界问题,比如全是递增,或者只有一个元素的情况
        int[] tmp = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            tmp[i + 1] = heights[i];
        }
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < tmp.length; i++) {
            // 当前元素比栈顶元素小, 此时当前元素
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int midIndex = stack.pop();
                int leftIndex = stack.peek();
                // 高度等于中间柱子的高度,宽度等于i到左边柱子的距离
                ans = Math.max(ans, (i - leftIndex - 1) * tmp[midIndex]);
            }
            stack.push(i);
        }
        return ans;
    }
}
