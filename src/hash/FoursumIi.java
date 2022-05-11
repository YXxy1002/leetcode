package hash;

import java.util.HashMap;

/**
 * 454. 四数相加 II
 *
 * @author xieyu
 * @keywords: hash
 * @ideas: 将1234分组为 12 34
 * @since 2021-7-6 21:24:57
 */

public class FoursumIi {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                int sum = i + j;
                Integer count = map.get(sum);
                if (count == null) {
                    map.put(sum, 1);
                } else {
                    map.put(sum, ++count);
                }
            }
        }

        for (int i : nums3) {
            for (int j : nums4) {
                Integer count = map.get(-(i + j));
                if (count != null) {
                    res += count;
                }
            }
        }
        return res;
    }
}
