package greedy;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 452. 用最少数量的箭引爆气球
 *
 * @author xieyu
 * @keywords: 贪心
 * @ideas: 每次都先把大钱找出去
 * @since 2021-7-6 21:24:57
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
        int begin = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if (point[0] > begin) {
                begin = point[1];
                ans++;
            }
        }
        return ans;
    }
}