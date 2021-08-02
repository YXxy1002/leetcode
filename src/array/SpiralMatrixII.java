package array;

/**
 * 螺旋矩阵2
 *
 * @author xieyu
 * @keywords: 模拟法
 * @ideas: 一共上下左右四个方向, 模拟爬格子的位置, 爬完一边该边的厚度就减一
 * @since 2021-6-22 11:46:01
 */
public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        // 声明4个边界
        int t = 0, r = n - 1, b = n - 1, l = 0;
        int num = 1;

        int[][] result = new int[n][n];
        while (num <= n * n) {
            // 从l到r
            for (int j = l; j <= r; j++) {
                result[t][j] = num++;
            }
            // top加一层
            t++;

            // 从t到b
            for (int j = t; j <= b; j++) {
                result[j][r] = num++;
            }
            // r减一层(因为r和b是从大到小遍历,所以要减一层)
            r--;

            // 从r到l
            for (int j = r; j >= l; j--) {
                result[b][j] = num++;
            }
            // b减一层
            b--;

            // 从b到t
            for (int j = b; j >= t; j--) {
                result[j][l] = num++;
            }
            // l加一层
            l++;
        }
        return result;
    }

}