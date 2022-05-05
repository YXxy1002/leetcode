package string;

/**
 * 13. 罗马数字转整数
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-6 21:24:57
 */

public class RomanToInteger {
    public int romanToInt(String s) {
        int res = 0;
        char[] chars = s.toCharArray();
        int lastValue = char2Int(chars[chars.length - 1]);
        for (int i = chars.length - 1; i >= 0; i--) {
            int value = char2Int(chars[i]);
            // 规则: 如果比上个数小说明是特殊情况,这时候不是加而是减
            if (value < lastValue) {
                res -= value;
            } else {
                res += value;
            }
        }
        return res;
    }

    private int char2Int(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            default:
                return 1000;
        }
    }
}
