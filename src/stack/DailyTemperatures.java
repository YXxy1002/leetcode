package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 739. 每日温度
 *
 * @author xieyu
 * @keywords: 单调栈
 * @ideas: 栈从头到底存储数组下标, 单调递增, 当当前元素比栈头元素大时则将所有比当前元素小的下标弹出
 * @since 2021-7-10 20:14:32
 */
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new LinkedList<>();
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                res[index] = i - index;
            }
            stack.push(i);
        }
        return res;
    }
}
