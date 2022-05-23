package backtracking;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 78. 子集
 *
 * @author xieyu
 * @keywords: 回溯
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class Subsets {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        trackbacking(nums, 0);
        return res;
    }

    private void trackbacking(int[] nums, int start) {
        // 将所有path上的元素加入结果集
        res.add(new ArrayList<>(path));
        for (int i = start; i < nums.length; i++) {
            path.add(nums[i]);
            trackbacking(nums, i + 1);
            path.removeLast();
        }
    }
}