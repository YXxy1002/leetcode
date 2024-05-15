package array;

/**
 * 189. 轮转数组
 * 尝试过
 * 中等
 * 相关标签
 * 相关企业
 * 提示
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右轮转 1 步: [7,1,2,3,4,5,6]
 * 向右轮转 2 步: [6,7,1,2,3,4,5]
 * 向右轮转 3 步: [5,6,7,1,2,3,4]
 * 示例 2:
 * <p>
 * 输入：nums = [-1,-100,3,99], k = 2
 * 输出：[3,99,-1,-100]
 * 解释:
 * 向右轮转 1 步: [99,-1,-100,3]
 * 向右轮转 2 步: [3,99,-1,-100]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 105
 * -231 <= nums[i] <= 231 - 1
 * 0 <= k <= 105
 * <p>
 * <p>
 * 进阶：
 * <p>
 * 尽可能想出更多的解决方案，至少有 三种 不同的方法可以解决这个问题。
 * 你可以使用空间复杂度为 O(1) 的 原地 算法解决这个问题吗？
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] ints = {-1, -100, 3, 99};
        rotate(ints, 2);
    }

    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        // 对于长度4的数组 右移2位和6位效果一样
        k = k % len;
        if (k == 0) {
            return;
        }
        // 统计被右移元素的数量,全部右移完成要终止循环
        int cnt = 0;

        // 从0开始替换元素    假设元素4个,k=2   0->2->0  1->3->1
        for (int i = 0; i < nums.length; i++) {
            if (cnt >= nums.length) {
                break;
            }

            // 从i开始,将i位置的元素右移k,因为会超出数组所以取模,循环终止的条件是j又回到了i的位置
            int j = i;
            int tmp = nums[j];
            do {
                int t = (j + k) % nums.length;
                int tTmp = nums[t];
                nums[t] = tmp;
                tmp = tTmp;
                j = t;
                cnt++;
            } while (j != i);
        }

    }
}
