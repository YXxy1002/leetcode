package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 合并区间
 *
 * @author xieyu
 * @keywords: idea only
 * @ideas: 1.将数组按第一个元素升序排序 2.依次将元素放入新数组,如果元素跟新数组中的最后一个元素可以合并就合并,不能就直接加入新数组
 * @since 2021-7-3 10:47:38
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }
        // 先排序,保证arr[0]是升序
        Arrays.sort(intervals, Comparator.comparingInt(interval -> interval[0]));
        List<int[]> result = new ArrayList<>();
        for (int[] e : intervals) {
            if (result.isEmpty()) {
                result.add(e);
            } else {
                // 取最后一个元素跟当前元素比较,如果可以合并就合并后再放入result
                int[] last = result.get(result.size() - 1);
                if (e[0] <= last[1]) {
                    // merge
                    result.set(result.size() - 1, new int[]{last[0], Math.max(e[1], last[1])});
                } else {
                    result.add(e);
                }
            }
        }
        return result.toArray(new int[0][]);
    }
}