package backtracking;


import java.util.ArrayList;
import java.util.List;

/**
 * 77. 组合
 *
 * @author xieyu
 * @keywords: 回溯
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class Combinations {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> path = new ArrayList<>();
        backtracking(path, n, k, 1);
        return res;
    }

    private void backtracking(List<Integer> path, int n, int k, int start) {
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i <= n - (k - path.size()) + 1; i++) {
            path.add(i);
            backtracking(path, n, k, i + 1);
            path.remove(path.get(path.size() - 1));
        }
    }
}