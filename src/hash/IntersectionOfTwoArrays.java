package hash;

import java.util.HashSet;
import java.util.Set;

/**
 * 349. 两个数组的交集
 *
 * @author xieyu
 * @keywords: hash
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> n1 = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i : nums1) {
            n1.add(i);
        }
        for (int i : nums2) {
            if (n1.contains(i)) {
                res.add(i);
            }
        }
        int[] ans = new int[res.size()];
        int count = 0;
        for (int i : res) {
            ans[count++] = i;
        }
        return ans;
    }
}
