package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. 组合总和
 *
 * @author xieyu
 * @keywords: 回溯
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class NQueens {

    List<List<String>> res = new ArrayList<>();
    char[][] path;

    public List<List<String>> solveNQueens(int n) {
        path = new char[n][n];
        for (char[] chars : path) {
            Arrays.fill(chars, '.');
        }
        trackback(0);
        return res;
    }

    private void trackback(int row) {
        if (row == path.length) {
            res.add(build(path));
        }
        for (int i = 0; i < path.length; i++) {
            if (valid(i, row)) {
                path[row][i] = 'Q';
                trackback(row + 1);
                path[row][i] = '.';
            }
        }
    }

    private boolean valid(int column, int row) {
        // 竖线
        for (int i = 0; i <= row - 1; i++) {
            if (path[i][column] == 'Q') {
                return false;
            }
        }
        // 横线
        for (int i = 0; i <= column - 1; i++) {
            if (path[row][i] == 'Q') {
                return false;
            }
        }
        // 左上斜线
        int tmpColumn = column;
        int tmpRow = row;
        while (tmpColumn >= 0 && tmpRow >= 0) {
            if (path[tmpRow][tmpColumn] == 'Q') {
                return false;
            }
            tmpColumn--;
            tmpRow--;
        }
        // 右上斜线
        tmpColumn = column;
        tmpRow = row;
        while (tmpColumn <= path.length - 1 && tmpRow >= 0) {
            if (path[tmpRow][tmpColumn] == 'Q') {
                return false;
            }
            tmpColumn++;
            tmpRow--;
        }
        return true;
    }

    private List<String> build(char[][] path) {
        List<String> res = new ArrayList<>();
        for (char[] chars : path) {
            StringBuilder sb = new StringBuilder();
            for (char aChar : chars) {
                sb.append(aChar);
            }
            res.add(sb.toString());
        }
        return res;
    }
}
