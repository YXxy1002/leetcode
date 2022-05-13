package backtracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class combinationSumIii {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        backtrack(k, n, 1, 0);
        return res;
    }

    private void backtrack(int total, int target, int start, int sum) {
        // 减枝
        if (sum > target) {
            return;
        }

        if (path.size() == total) {
            if (sum == target) {
                res.add(new ArrayList<>(path));
            }
            return;
        }

        for (int i = start; i <= 9 - (total - path.size()) + 1; i++) {
            path.add(i);
            sum += i;
            backtrack(total, target, i + 1, sum);
            path.removeLast();
            sum -= i;
        }
    }
}