package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 503. 下一个更大元素 II
 *
 * @author xieyu
 * @keywords: 单调栈
 * @ideas: 单调栈 模拟2遍遍历数组
 * @since 2021-7-10 20:14:32
 */
public class NextGreaterElementIi {
    public int[] nextGreaterElements(int[] nums) {
        int[] res = new int[nums.length];
        Arrays.fill(res, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums.length * 2 - 1; i++) {
            int index = i % nums.length;
            int num = nums[index];
            while (!stack.isEmpty() && num > nums[stack.peek()]) {
                res[stack.pop()] = nums[index];
            }
            stack.push(index);
        }
        return res;
    }
}
