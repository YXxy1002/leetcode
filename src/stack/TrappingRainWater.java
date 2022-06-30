package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 42. 接雨水
 *
 * @author xieyu
 * @keywords: 单调栈
 * @ideas: 按行算总数
 * @since 2021-10-26 16:32:54
 */
public class TrappingRainWater {
    public static int trap(int[] height) {
        Deque<Integer> stack = new LinkedList<>();
        int res = 0;
        for (int i = 0; i < height.length; i++) {
            // 栈维持单调递减, 如果递增就要算能接多少水
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                if (stack.size() == 1) {
                    // 栈只有一个元素,构不成凹槽,跳过
                    stack.pop();
                } else {
                    // 栈中第一个是左边第一个元素,第二个是左边第二个元素,这2个和当前元素共同构成一个凹槽
                    int bottomIndex = stack.pop();
                    int leftIndex = stack.peek();
                    int width = i - leftIndex - 1;
                    int _height = Math.min(height[i], height[leftIndex]) - height[bottomIndex];
                    res += width * _height;
                }
            }
            stack.push(i);
        }
        return res;
    }
}
