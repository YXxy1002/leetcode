package greedy;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 435.无重叠区间
 *
 * @author xieyu
 * @keywords: 贪心
 * @ideas: 每次都给出能满足条件的最小饼干
 * @since 2021-7-6 21:24:57
 */
public class NonOverLappingIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[1]));
        int remove = 0;
        int index = intervals[0][0];
        for (int[] interval : intervals) {
            // 如果头部小于上个尾部就要移除
            if (interval[0] < index) {
                remove++;
            } else {
                index = interval[1];
            }
        }
        return remove;
    }
}