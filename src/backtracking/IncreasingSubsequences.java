package backtracking;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 491. 递增子序列
 *
 * @author xieyu
 * @keywords: 回溯
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class IncreasingSubsequences {
    LinkedList<Integer> path = new LinkedList<>();
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> findSubsequences(int[] nums) {
        trackbacking(nums, 0);
        return res;
    }

    private void trackbacking(int[] nums, int start) {
        if (path.size() >= 2) {
            res.add(new ArrayList<>(path));
        }
        // 借助一个set来对本层元素进行去重, 使用过的元素不再继续使用
        Set<Integer> set = new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            // 比上一个元素小就跳过
            if (path.size() >= 1 && nums[i] < path.get(path.size() - 1)) {
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            trackbacking(nums, i + 1);
            path.removeLast();
        }
    }
}