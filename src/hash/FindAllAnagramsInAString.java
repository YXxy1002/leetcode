package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @author xieyu
 * @keywords: hash
 * @ideas: 一直滑动, 比较当前窗口和p是否是异位词
 * @since 2021-7-6 21:24:57
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int pLen = p.length();
        int sLen = s.length();
        // 特殊情况
        if (pLen > sLen) {
            return res;
        }
        // 数组用来比较是否异位词
        int[] sArr = new int[26];
        int[] pArr = new int[26];
        for (int i = 0; i < pLen; i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        // 判断第一个是否是异位
        if (Arrays.equals(sArr, pArr)) {
            res.add(0);
        }
        // 继续滑动
        for (int i = pLen; i < sLen; i++) {
            sArr[s.charAt(i) - 'a']++;
            sArr[s.charAt(i - pLen) - 'a']--;
            if (Arrays.equals(sArr, pArr)) {
                res.add(i - pLen + 1);
            }
        }
        return res;
    }
}
