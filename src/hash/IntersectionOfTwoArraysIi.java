package hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 350. 两个数组的交集 II
 *
 * @author xieyu
 * @keywords: hash
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class IntersectionOfTwoArraysIi {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 保证nums1是长度更小的数组,节约时间
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        // nums1放进map
        HashMap<Integer, Integer> m1 = new HashMap<>();
        for (int i : nums1) {
            Integer count = m1.get(i);
            if (count == null) {
                m1.put(i, 1);
            } else {
                m1.put(i, ++count);
            }
        }
        int[] res = new int[nums2.length];
        int resCount = 0;
        // map中存在则放进结果数组,并且将count-1
        for (int i : nums2) {
            Integer count = m1.get(i);
            if (count != null && count > 0) {
                res[resCount++] = i;
                m1.put(i, --count);
            }
        }
        return Arrays.copyOf(res, resCount);
    }
}
