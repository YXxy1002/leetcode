package backtracking;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * 332. 重新安排行程
 *
 * @author xieyu
 * @keywords: 回溯 treeMap
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class ReconstructItinerary {
    Map<String, TreeMap<String, Integer>> map = new HashMap<>();
    LinkedList<String> path = new LinkedList<>();

    public List<String> findItinerary(List<List<String>> tickets) {
        // 构建一个map   <出发点, TreeMap<到达点,次数>>
        for (List<String> list : tickets) {
            String from = list.get(0);
            String to = list.get(1);
            TreeMap<String, Integer> treeMap = map.get(from);
            if (treeMap == null) {
                treeMap = new TreeMap<>();
                treeMap.put(to, 1);
                map.put(from, treeMap);
            } else {
                Integer times = treeMap.get(to);
                if (times == null) {
                    treeMap.put(to, 1);
                } else {
                    treeMap.put(to, times + 1);
                }
            }
        }
        // 先把初始地放进去
        path.add("JFK");
        trackback(tickets.size());
        return path;
    }

    private boolean trackback(int size) {
        if (path.size() == size + 1) {
            // 飞了size+1趟表示到终点了
            return true;
        }
        String last = path.getLast();
        TreeMap<String, Integer> toMap = map.get(last);
        if (toMap == null) {
            // 为了防止最后一个递归last为空
            return false;
        }
        // 遍历所有到达点
        for (Map.Entry<String, Integer> entry : toMap.entrySet()) {
            Integer leftTimes = entry.getValue();
            if (leftTimes < 1) {
                // 次数小于1说明不能飞这里了
                continue;
            }
            // 找到一个字典顺序最前的到达地出发
            String to = entry.getKey();
            path.add(to);
            entry.setValue(leftTimes - 1);
            if (trackback(size)) {
                // 找到最佳路线就不用继续了
                return true;
            }
            path.removeLast();
            entry.setValue(leftTimes);
        }
        return false;
    }
}
