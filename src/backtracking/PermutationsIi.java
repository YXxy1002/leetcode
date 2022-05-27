package backtracking;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 47. 全排列 II
 *
 * @author xieyu
 * @keywords: 回溯
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class PermutationsIi {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
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
            if (used[i]) {// 这个位置的数用过了就跳过
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                // 这个位置的数和前一个数一样并且前一个数在当前没被使用说明可以跳过,因为这个数在前面已经处理过了
                // 如果这里的user[i-1]为true的话则不能跳过因为题目允许重复的数字
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