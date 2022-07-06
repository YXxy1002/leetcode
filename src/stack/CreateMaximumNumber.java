package stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 321. 拼接最大数
 *
 * @author xieyu
 * @keywords: 单调栈
 * @ideas:
 * @since 2021-7-10 20:14:32
 */
public class CreateMaximumNumber {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int shortLen;
        int longLen;
        int[] shortArr;
        int[] longArr;
        if (nums1.length > nums2.length) {
            shortLen = nums2.length;
            longLen = nums1.length;
            shortArr = nums2;
            longArr = nums1;
        } else {
            shortLen = nums1.length;
            longLen = nums2.length;
            shortArr = nums1;
            longArr = nums2;
        }
        int[] res = null;
        int begin = Math.max(k - longLen, 0);
        int end = Math.min(k, shortLen);
        for (int i = begin; i <= end; i++) {
            int[] merge = merge(max(shortArr, i), max(longArr, k - i));
            if (res == null) {
                res = merge;
            } else {
                res = gt(res, merge) ? res : merge;
            }
        }
        return res;
    }

    /**
     * 比较2个数组大小
     *
     * @param num1
     * @param num2
     * @return
     */
    private boolean gt(int[] num1, int[] num2) {
        for (int i = 0; i < num1.length; i++) {
            if (num1[i] == num2[i]) {
                continue;
            }
            return num1[i] > num2[i];
        }
        return true;
    }

    /**
     * 单调栈取某个数组的前k个最大数
     *
     * @param num
     * @param k
     * @return
     */
    private int[] max(int[] num, int k) {
        int remove = num.length - k;
        Deque<Integer> stack = new LinkedList<>();
        for (int n : num) {
            while (!stack.isEmpty() && stack.peek() < n && remove > 0) {
                stack.pop();
                remove--;
            }
            stack.push(n);
        }
        while (remove > 0) {
            stack.pop();
            remove--;
        }
        int len = stack.size();
        int[] res = new int[len];
        for (int i = len - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }


    /**
     * 合并两个降序数组,保证合并后也是降序
     *
     * @param num1
     * @param num2
     * @return
     */
    private int[] merge(int[] num1, int[] num2) {
        int[] res = new int[num1.length + num2.length];
        int resCur = 0, cur1 = 0, cur2 = 0;
        while (cur1 < num1.length && cur2 < num2.length) {
            if (gt(num1, num2, cur1, cur2)) {
                res[resCur++] = num1[cur1++];
            } else {
                res[resCur++] = num2[cur2++];
            }
        }
        while (cur1 < num1.length) {
            res[resCur++] = num1[cur1++];
        }
        while (cur2 < num2.length) {
            res[resCur++] = num2[cur2++];
        }
        return res;
    }

    /**
     * 比较2个数组的某一个位置的数字大小,如果相等,则比较下一个位置的数字大小
     *
     * @param num1
     * @param num2
     * @param cur1
     * @param cur2
     * @return
     */
    private boolean gt(int[] num1, int[] num2, int cur1, int cur2) {
        if (cur1 >= num1.length) {
            return false;
        }
        if (cur2 >= num2.length) {
            return true;
        }
        if (num1[cur1] > num2[cur2]) {
            return true;
        } else if (num1[cur1] < num2[cur2]) {
            return false;
        } else {
            // 相等的时候比较下一个
            return gt(num1, num2, cur1 + 1, cur2 + 1);
        }
    }
}
