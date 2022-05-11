package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 383. 赎金信
 *
 * @author xieyu
 * @keywords: hash
 * @ideas:
 * @since 2021-7-6 21:24:57
 */

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (char c : magazine.toCharArray()) {
            arr[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            arr[c - 'a']--;
            if (arr[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
