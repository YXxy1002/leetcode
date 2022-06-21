package stack;

import java.util.Stack;

/**
 * 232. 用栈实现队列
 *
 * @author xieyu
 * @keywords:
 * @ideas: 2个栈 添加只往栈1添加, pop的时候栈2有元素则去除,没有元素就要先把栈1的元素全取到栈2再取出
 * @since 2021-7-10 20:14:32
 */
public class ImplementQueueUsingStacks {
}

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        if (!stack2.isEmpty()) {
            return stack2.pop();
        }

        while (!stack1.isEmpty()) {
            int x = stack1.pop();
            stack2.push(x);
        }
        return stack2.pop();
    }

    public int peek() {
        if (!stack2.isEmpty()) {
            return stack2.peek();
        }
        while (!stack1.isEmpty()) {
            int x = stack1.pop();
            stack2.push(x);
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}