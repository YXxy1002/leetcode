package backtracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class PalindromePartitioning {
    LinkedList<String> path = new LinkedList<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        trackbacking(s, 0);
        return res;
    }

    private void trackbacking(String s, int start) {
        // 能切到最后说明获得了一个全是回文的list,即可加入res
        if (start >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 当前不是回文串就没必要往下切分了
            if (!isPalindromes(s, start, i)) {
                continue;
            }
            path.add(s.substring(start, i + 1));
            trackbacking(s, i + 1);
            path.removeLast();
        }
    }

    private boolean isPalindromes(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
