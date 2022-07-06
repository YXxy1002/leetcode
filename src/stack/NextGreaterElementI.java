package stack;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 496. 下一个更大元素 I
 *
 * @author xieyu
 * @keywords: 单调栈
 * @ideas: 单调栈  map
 * @since 2021-7-10 20:14:32
 */
public class NextGreaterElementI {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // map记录nums2中每个数字的下一个更大元素
        Map<Integer, Integer> map = new HashMap<>();
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }
        // 看nums1中每个数字的下一个更大元素是否在map中,是就取值,否就设为-1
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            Integer num = map.get(nums1[i]);
            if (num != null) {
                res[i] = num;
            } else {
                res[i] = -1;
            }
        }
        return res;
    }
}
