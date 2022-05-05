package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 49. 字母异位词分组
 *
 * @author xieyu
 * @keywords: hash
 * @ideas:
 * @since 2021-7-6 21:24:57
 */

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            // 获得key
            String key = getKey(s);
            // 如果map存在则直接加入该组,否则生成新组
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
                list.add(s);
                res.add(list);
                map.put(key, list);
            } else {
                list.add(s);
            }
        }
        return res;
    }

    /**
     * 将s分解为每个字符和出现次数 例如 eaat 分解为 a2e1t1
     *
     * @param s
     * @return
     */
    private String getKey(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            arr[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            if (arr[i] != 0) {
                sb.append((char) ('a' + i));
                sb.append(arr[i]);
            }
        }
        return sb.toString();
    }
}
