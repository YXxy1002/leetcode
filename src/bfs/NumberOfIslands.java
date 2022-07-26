package bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 200. 岛屿数量
 *
 * @author xieyu
 * @keywords: bfs
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    grid[i][j] = '2';
                    bfs(grid, i, j);
                    count++;
                }
            }
        }

        return count;
    }

    private void bfs(char[][] grid, int i, int j) {
        int[] xM = {1, -1, 0, 0};
        int[] yM = {0, 0, 1, -1};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            for (int k = 0; k < 4; k++) {
                int newX = x + xM[k];
                int newY = y + yM[k];
                if (newX >= 0 && newX < grid.length && newY >= 0 && newY < grid[0].length) {
                    if (grid[newX][newY] == '1') {
                        grid[newX][newY] = '2';
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
    }
}
