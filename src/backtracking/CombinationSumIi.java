package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 40. 组合总和 II
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class CombinationSumIi {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        tackbacking(candidates, target, 0, 0);
        return res;
    }

    private void tackbacking(int[] candidates, int target, int sum, int start) {
        if (sum == target) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            // 重复数字直接continue
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            if (sum + candidates[i] > target) {
                break;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            tackbacking(candidates, target, sum, i + 1);
            sum -= candidates[i];
            path.removeLast();
        }
    }
}
