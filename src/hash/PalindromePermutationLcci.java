package hash;

import java.util.HashMap;

/**
 * 面试题 01.04. 回文排列
 *
 * @author xieyu
 * @keywords: hash
 * @ideas: 统计所有字符出现次数, 奇数最多只能出现一次
 * @since 2021-7-6 21:24:57
 */

public class PalindromePermutationLcci {
    public boolean canPermutePalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Integer count = map.getOrDefault(c, 0);
            map.put(c, ++count);
        }
        int odd = 0;
        for (Integer value : map.values()) {
            if (value % 2 == 1) {
                odd++;
            }
            if (odd > 1) {
                return false;
            }
        }
        return true;
    }
}
