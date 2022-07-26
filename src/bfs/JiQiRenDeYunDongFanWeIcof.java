package bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 剑指 Offer 13. 机器人的运动范围
 *
 * @author xieyu
 * @keywords: bfs
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class JiQiRenDeYunDongFanWeIcof {
    public int movingCount(int m, int n, int k) {
        int res = 1;
        int[] mx = {0, 1};
        int[] my = {1, 0};
        boolean[][] arr = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] p = queue.poll();
            int x = p[0];
            int y = p[1];
            for (int i = 0; i < 2; i++) {
                int newX = x + mx[i];
                int newY = y + my[i];
                if (newX < m && newY < n && cal(newX) + cal(newY) <= k && !arr[newX][newY]) {
                    queue.offer(new int[]{newX, newY});
                    arr[newX][newY] = true;
                    res++;
                }
            }
        }
        return res;
    }

    /**
     * 计算位数之和
     *
     * @param num
     * @return
     */
    public int cal(int num) {
        int res = 0;
        while (num != 0) {
            res += num % 10;
            num /= 10;
        }
        return res;
    }

}
