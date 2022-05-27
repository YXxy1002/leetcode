package backtracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 46. 全排列
 *
 * @author xieyu
 * @keywords: 回溯
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class Permutations {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        used = new boolean[nums.length];
        trackbacking(nums);
        return res;
    }

    private void trackbacking(int[] nums) {
        if (path.size() == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {// 如果这个数用过了跳过
                continue;
            }
            used[i] = true;
            path.add(nums[i]);
            trackbacking(nums);
            path.removeLast();
            used[i] = false;
        }
    }
}