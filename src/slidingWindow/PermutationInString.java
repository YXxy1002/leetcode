package slidingWindow;

import java.util.Arrays;
import java.util.function.Predicate;

/**
 * 字符串的排列
 *
 * @author xieyu
 * @keywords: 滑动窗口 双指针 map
 * @ideas: 2个指针来表示子串, 右指针一直向右,左指针遇到重复字符就移动来消除重复
 * @since 2021-7-6 21:24:57
 */
public class PermutationInString {
    public static void main(String[] args) {
        PermutationInString s = new PermutationInString();
        boolean b = s.checkInclusion("ab", "eidbaooo");
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] s1Counts = new int[26];
        int s1Sum = 0;
        for (int i = 0; i < s1.toCharArray().length; i++) {
            s1Sum += s1.toCharArray()[i];
            s1Counts[s1.toCharArray()[i] - 'a']++;
        }
        int l = 0, r = s1.length() - 1;
        while (r < s2.length()) {
            int sum = getSum(s2, l, r);
            if (sum == s1Sum) {
                int[] tmpCounts = new int[26];
                for (int i = l; i <= r; i++) {
                    tmpCounts[s2.toCharArray()[i] - 'a']++;
                }
                if (Arrays.equals(s1Counts, tmpCounts)) {
                    return true;
                }
            }
            l++;
            r++;
        }
        return false;
    }

    private int getSum(String s1, int l, int r) {
        int sum = 0;

        char[] chars = s1.toCharArray();

        for (int i = l; i <= r; i++) {
            sum += chars[i];
        }
        return sum;
    }

}