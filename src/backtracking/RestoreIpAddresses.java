package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 *
 * @author xieyu
 * @keywords:
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class RestoreIpAddresses {
    LinkedList<String> path = new LinkedList<>();
    List<String> res = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {
        trackbacking(s, 0);
        return res;
    }

    private void trackbacking(String s, int start) {
        if (path.size() == 4) {
            if (start >= s.length()) {
                res.add(trans(path));
            }
            return;
        }
        for (int i = start; i < s.length(); i++) {
            // 剪枝, 不满足要求后面的不用看了
            String sub = s.substring(start, i + 1);
            if ((sub.length() > 1 && sub.startsWith("0")) || Integer.parseInt(sub) > 255) {// 0可以但01不行
                break;
            }
            path.add(sub);
            trackbacking(s, i + 1);
            path.removeLast();
        }
    }

    private String trans(LinkedList<String> path) {
        StringBuilder sb = new StringBuilder();
        for (String s : path) {
            sb.append(s).append(".");
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }
}
