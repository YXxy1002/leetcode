package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 402. 移掉 K 位数字
 *
 * @author xieyu
 * @keywords: 单调栈
 * @ideas:
 * @since 2021-10-26 16:32:54
 */
public class RemoveKDigits {
    public static String removeKdigits(String num, int k) {
        int remain = num.length() - k;
        Deque<Character> stack = new LinkedList<>();
        char[] cs = num.toCharArray();
        for (char c : cs) {
            while (k > 0 && !stack.isEmpty() && c < stack.peek()) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }
        // 从单调栈中获取remain个元素
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int i = 0; i < remain; i++) {
            char c = stack.pollLast();
            // 去除先导0
            if (flag && c == '0') {
                continue;
            }
            flag = false;
            sb.append(c);
        }
        // 没有数据需要返回0
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }
}
