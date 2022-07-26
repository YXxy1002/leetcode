package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 695. 岛屿的最大面积
 *
 * @author xieyu
 * @keywords: bfs
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class MaxAreaOfIsland {
    int[] mx = {-1, 1, 0, 0};
    int[] my = {0, 0, 1, -1};
    int row;
    int col;

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        row = grid.length;
        col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    int num = bfs(grid, i, j);
                    res = Math.max(res, num);
                }
            }
        }
        return res;
    }

    private int bfs(int[][] grid, int x, int y) {
        // 到这里说当前结点一定是土地
        int res = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        grid[x][y] = 2;
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            for (int i = 0; i < 4; i++) {
                int newX = p[0] + mx[i];
                int newY = p[1] + my[i];
                if (newX >= 0 && newX < row && newY >= 0 && newY < col && grid[newX][newY] == 1) {
                    res++;
                    queue.offer(new int[]{newX, newY});
                    grid[newX][newY] = 2;
                }
            }
        }
        return res;
    }
}
