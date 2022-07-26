package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 463. 岛屿的周长
 *
 * @author xieyu
 * @keywords: bfs
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class IslandPerimeter {
    int[] xm = {-1, 1, 0, 0};
    int[] ym = {0, 0, 1, -1};
    int row;
    int col;

    public int islandPerimeter(int[][] grid) {
        row = grid.length;
        col = grid[0].length;
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        // 把四周加起来
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    grid[i][j] = 2;
                }
            }
        }
        // bfs
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            // 四边长
            int add = 4;
            for (int i = 0; i < 4; i++) {
                int newX = x + xm[i];
                int newY = y + ym[i];
                if (newX < 0 || newX >= row || newY < 0 || newY >= col) {
                    continue;
                }
                // 如果周边不是水则计算周长-1
                if (grid[newX][newY] != 0) {
                    add--;
                }
                if (grid[newX][newY] == 1) {
                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = 2;
                    add--;
                }
            }
            res += add;
        }
        return res;
    }
}
