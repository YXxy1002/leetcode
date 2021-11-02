package _04.dp;

import java.util.List;

/**
 * 139. 单词拆分
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: dp: 0到当前位置的字符串能否被wordDict拆分 dp[i]=dp[j] && check(s[j..i−1])
 * @since 2021-10-26 16:32:54
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i < dp.length; i++) {
            // 从0到j-1的位置,判断j&&剩下的字符串在wordDict内则说明0到i可以被拆分
            for (int j = 0; j <= i - 1; j++) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[dp.length - 1];
    }
}