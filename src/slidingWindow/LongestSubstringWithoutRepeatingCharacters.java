package slidingWindow;

import java.util.HashMap;

/**
 * 无重复字符的最长子串
 *
 * @author xieyu
 * @keywords: 滑动窗口 双指针 map
 * @ideas: 2个指针来表示子串, 右指针一直向右,左指针遇到重复字符就移动来消除重复
 * @since 2021-7-6 21:24:57
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 2个指针,一左一右,右边的一直走,左边的在有重复的时候进行移动确保没有重复
        int l = 0, r = 0;
        // map用于判断重复和记录重复的位置
        HashMap<Character, Integer> map = new HashMap<>();
        // 结果长度
        int max = 0;
        while (r < s.length()) {
            char c = s.charAt(r);
            if (map.containsKey(c)) {
                // 这里很关键,如果map已经存在这个char了,应该把l移动到这个char位置和当前l位置中数值更大的那一个
                l = Math.max(l, map.get(c) + 1);
            }
            // 将char放进map,并计算当前数组长度
            map.put(c, r);
            max = Math.max(max, r - l + 1);
            r++;
        }
        return max;
    }
}