package greedy;


/**
 * 738. 单调递增的数字
 *
 * @author xieyu
 * @keywords: 贪心
 * @ideas: 找到最后一个需要改变的数字, 然后将后续数字置为9
 * @since 2021-7-6 21:24:57
 */
public class MonotoneIncreasingDigits {
    public int monotoneIncreasingDigits(int n) {
        char[] chars = (n + "").toCharArray();
        int last = -1;
        for (int i = chars.length - 1; i >= 1; i--) {
            if (chars[i] < chars[i - 1]) {
                chars[i - 1] -= 1;
                last = i - 1;
            }
        }
        if (last != -1) {
            for (int i = last + 1; i < chars.length; i++) {
                chars[i] = '9';
            }
        }
        return Integer.parseInt(new String(chars));
    }

    public static void main(String[] args) {
        int a = 6;
        int b = 1;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(b);
        System.out.println(a);
    }
}