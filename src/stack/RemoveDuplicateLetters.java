package stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 *
 * @author xieyu
 * @keywords: 单调栈
 * @ideas: 单调栈 模拟2遍遍历数组
 * @since 2021-7-10 20:14:32
 */
public class RemoveDuplicateLetters {

    public static String removeDuplicateLetters(String s) {
        char[] cs = s.toCharArray();
        int[] map = new int[26];
        for (char c : cs) {
            map[c - 'a']++;
        }
        boolean[] exist = new boolean[26];
        Deque<Character> stack = new LinkedList<>();
        for (char c : cs) {
            if (exist[c - 'a']) {
                map[c - 'a']--;
                continue;
            }
            // 比前一个大可以尝试移除前一个,条件是
            while (!stack.isEmpty() && c < stack.peek() && map[stack.peek() - 'a'] > 0) {
                char pop = stack.pop();
                exist[pop - 'a'] = false;
            }
            stack.push(c);
            exist[c - 'a'] = true;
            map[c - 'a']--;
        }

        //返回

        char[] res = new char[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return new String(res);
    }
}
