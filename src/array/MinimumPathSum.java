package array;

/**
 * @author xieyu
 * @keywords: 动态规划
 * @ideas: 先算出第一行和第一列每个格子的到达路径, 然后算出其他格子的到达路径
 * @since 2021/6/22 0022 下午 8:37
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[][] sum = new int[grid.length][grid[0].length];
        // 第一个数要手动设置
        sum[0][0] = grid[0][0];
        // 行
        for (int i = 1; i < grid[0].length; i++) {
            sum[0][i] = sum[0][i - 1] + grid[0][i];
        }
        // 列
        for (int i = 1; i < grid.length; i++) {
            sum[i][0] = sum[i - 1][0] + grid[i][0];
        }
        // 其他格子
        for (int i = 1; i < sum.length; i++) {
            for (int j = 1; j < sum[0].length; j++) {
                // 等于上面和左边最小的和本身加起来
                sum[i][j] = grid[i][j] + Math.min(sum[i - 1][j], sum[i][j - 1]);
            }
        }
        return sum[sum.length - 1][sum[0].length - 1];
    }
}