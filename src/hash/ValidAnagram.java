package hash;

/**
 * 242. 有效的字母异位词
 *
 * @author xieyu
 * @keywords: hash
 * @ideas:
 * @since 2021-7-6 21:24:57
 */

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] record = new int[26];
        for (char c : s.toCharArray()) {
            record[c - 'a'] += 1;
        }
        for (char c : t.toCharArray()) {
            record[c - 'a'] -= 1;
        }
        for (int i : record) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
