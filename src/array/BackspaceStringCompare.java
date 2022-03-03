package array;

/**
 * 844. 比较含退格的字符串
 *
 * @author xieyu
 * @keywords: array
 * @ideas: 倒序遍历
 * @since 2022-3-3 11:03:21
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String s, String t) {
        int c1 = s.length() - 1, c2 = t.length() - 1;
        while (c1 >= 0 || c2 >= 0) {// 大条件: 任意一个字符串还没处理完
            int count1 = 0;
            while (c1 >= 0) {
                char c = s.charAt(c1);
                if (c == '#') {// 计算#个数
                    count1++;
                    c1--;
                } else {
                    if (count1 == 0) {// 没有#直接跳出
                        break;
                    } else {// 有#就执行退格
                        c1--;
                        count1--;
                    }
                }
            }
            // 和上面处理方式一样
            int count2 = 0;
            while (c2 >= 0) {
                char c = t.charAt(c2);
                if (c == '#') {
                    count2++;
                    c2--;
                } else {
                    if (count2 == 0) {
                        break;
                    } else {
                        c2--;
                        count2--;
                    }
                }
            }

            if (c1 >= 0 && c2 >= 0) {// 这时候退格都处理完了,如果两个char不同就可以返回false
                if (s.charAt(c1) != t.charAt(c2)) {
                    return false;
                }
            } else {// 如果有一个走完了另一个没走完也视为false
                if (c1 >= 0 || c2 >= 0) {
                    return false;
                }
            }
            c1--;
            c2--;
        }
        return true;// 全走完,都没走false,返回true
    }
}