package hash;

import java.util.HashSet;

/**
 * 128. 最长连续序列
 *
 * @author xieyu
 * @keywords: hash
 * @ideas:
 * @since 2021-7-6 21:24:57
 */

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> hash = new HashSet<>();
        // 转成hash表
        for (int i : nums) {
            hash.add(i);
        }
        int res = 0;
        for (int i : hash) {
            int now = i;
            // 关键点,如果上一个数字存在说明自己不是连续串的起点,这时候直接跳过
            if (!hash.contains(now - 1)) {
                int consecutive = 1;
                // 如果上一个数字不在hash表中说明自己是第一个连续序列中的数字,这时候就一致枚举下一个连续数字,计算出最长连续串
                while (hash.contains(++now)) {
                    consecutive++;
                }
                res = Math.max(res, consecutive);
            }
        }
        return res;
    }
}
