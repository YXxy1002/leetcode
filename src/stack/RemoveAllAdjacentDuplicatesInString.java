package stack;

import java.util.Stack;

/**
 * 1047. 删除字符串中的所有相邻重复项
 *
 * @author xieyu
 * @keywords: 栈
 * @ideas:
 * @since 2021-7-10 20:14:32
 */
public class RemoveAllAdjacentDuplicatesInString {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (stack.isEmpty()) {
                stack.push(c);
            } else {
                if (c == stack.peek()) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        char[] newChars = new char[stack.size()];
        int index = 0;
        for (char i : stack) {
            newChars[index++] = i;
        }
        return new String(newChars);
    }
}