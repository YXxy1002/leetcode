package bfs;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 130. 被围绕的区域
 *
 * @author xieyu
 * @keywords: bfs
 * @ideas: 先把外圈符合条件的全加入, 然后挨个处理每个元素的周边
 * @since 2021-7-6 21:24:57
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        int[] xMove = {1, -1, 0, 0};
        int[] yMove = {0, 0, 1, -1};
        // 把最外圈的O加入队列
        int w = board[0].length;
        int h = board.length;
        Queue<int[]> queue = new LinkedList<>();
        // 顶部和底部
        for (int i = 0; i < w; i++) {
            if (board[0][i] == 'O') {
                queue.offer(new int[]{0, i});
                board[0][i] = 'A';
            }
            if (board[h - 1][i] == 'O') {
                queue.offer(new int[]{h - 1, i});
                board[h - 1][i] = 'A';
            }
        }
        // 中间的
        for (int i = 1; i < h - 1; i++) {
            if (board[i][0] == 'O') {
                queue.offer(new int[]{i, 0});
                board[i][0] = 'A';
            }
            if (board[i][w - 1] == 'O') {
                queue.offer(new int[]{i, w - 1});
                board[i][w - 1] = 'A';
            }
        }
        // 遍历队列,找出所有相邻的0
        while (!queue.isEmpty()) {
            int[] o = queue.poll();
            int x = o[0];
            int y = o[1];
            for (int i = 0; i < 4; i++) {
                int mx = x + xMove[i];
                int my = y + yMove[i];
                if (mx >= 0 && my >= 0 && mx < h && my < w && board[mx][my] == 'O') {
                    queue.offer(new int[]{mx, my});
                    board[mx][my] = 'A';
                }
            }
        }
        // 把A变成O ,把O变成X
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
