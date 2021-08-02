package greedy;


import java.util.Arrays;

/**
 * 分发饼干
 *
 * @author xieyu
 * @keywords: 贪心
 * @ideas: 每次都给出能满足条件的最小饼干
 * @since 2021-7-6 21:24:57
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int child = 0;
        int cookie = 0;
        while (child <= g.length - 1 && cookie <= s.length - 1) {
            if (g[child] <= s[cookie]) {
                child++;
                cookie++;
            } else {
                cookie++;
            }
        }
        return child;
    }
}