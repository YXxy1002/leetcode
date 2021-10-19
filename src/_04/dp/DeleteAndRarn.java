package _04.dp;

/**
 * 740. 删除并获得点数
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: 构建出一个sumArr, sumArr[i] = nums中i的总和, 然后对sumArr进行打家劫舍
 * @since 2021-7-6 21:24:57
 */
public class DeleteAndRarn {
    public int deleteAndEarn(int[] nums) {
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int[] sumArr = new int[max + 1];
        for (int num : nums) {
            sumArr[num] += num;
        }
        return rob(sumArr);
    }

    public int rob(int[] nums) {
        int ans = 0;
        int pre = 0;
        int prePre = 0;
        for (int num : nums) {
            ans = Math.max(pre, num + prePre);
            prePre = pre;
            pre = ans;
        }
        return ans;
    }

}