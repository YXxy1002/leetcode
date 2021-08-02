package greedy;


/**
 * 392. 判断子序列
 *
 * @author xieyu
 * @keywords: 贪心
 * @ideas: 每个字符都要在父字符串中
 * @since 2021-7-6 21:24:57
 */
public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int sIndex = 0, tIndex = 0;
        while (sIndex <= s.length() - 1 && tIndex <= t.length() - 1) {
            if (c1[sIndex] == c2[tIndex]) {
                sIndex++;
            }
            tIndex++;
        }
        return sIndex == s.length();
    }
}