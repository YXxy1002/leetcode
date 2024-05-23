package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. 数组的度
 * 简单
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个非空且只包含非负数的整数数组 nums，数组的 度 的定义是指数组里任一元素出现频数的最大值。
 * <p>
 * 你的任务是在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,2,3,1]
 * 输出：2
 * 解释：
 * 输入数组的度是 2 ，因为元素 1 和 2 的出现频数最大，均为 2 。
 * 连续子数组里面拥有相同度的有如下所示：
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组 [2, 2] 的长度为 2 ，所以返回 2 。
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,2,3,1,4,2]
 * 输出：6
 * 解释：
 * 数组的度是 3 ，因为元素 2 重复出现 3 次。
 * 所以 [2,2,3,1,4,2] 是最短子数组，因此返回 6 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * nums.length 在 1 到 50,000 范围内。
 * nums[i] 是一个在 0 到 49,999 范围内的整数。
 */
public class DegreeOfAnArray {
    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 3, 1, 4, 2};
        int findShortestSubArray = findShortestSubArray(ints);
    }

    public static int findShortestSubArray(int[] nums) {
        // map key为每位的数字    value为arr[3]   0为出现次数  1为首次出现index  2为最后出现index
        int res = nums.length;
        int max = 0;
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            int[] arr = map.get(n);
            if (arr == null) {
                arr = new int[]{1, i, i};
                map.put(n, arr);
            } else {
                arr[0]++;
                arr[2] = i;
            }
            max = Math.max(max, arr[0]);
        }
        for (int[] value : map.values()) {
            if (value[0] == max) {
                res = Math.min(res, value[2] - value[1] + 1);
            }
        }
        return res;

    }
}