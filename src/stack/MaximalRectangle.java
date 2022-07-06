package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 85. 最大矩形
 *
 * @author xieyu
 * @keywords: 单调栈
 * @ideas: 在84的基础上,每行计算最大面积,求最大值,见图片https://pic.leetcode-cn.com/aabb1b287134cf950aa80526806ef4025e3920d57d237c0369ed34fae83e2690-image.png
 * @since 2021-7-10 20:14:32
 */
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int[] heights = new int[matrix[0].length];
        int ans = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            ans = Math.max(ans, largestRectangleArea(heights));
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int[] tmp = new int[heights.length + 2];
        for (int i = 0; i < heights.length; i++) {
            tmp[i + 1] = heights[i];
        }
        Deque<Integer> stack = new LinkedList<>();
        int ans = 0;
        for (int i = 0; i < tmp.length; i++) {
            while (!stack.isEmpty() && tmp[i] < tmp[stack.peek()]) {
                int midIndex = stack.pop();
                int leftIndex = stack.peek();
                ans = Math.max(ans, (i - leftIndex - 1) * tmp[midIndex]);
            }
            stack.push(i);
        }
        return ans;
    }
}
