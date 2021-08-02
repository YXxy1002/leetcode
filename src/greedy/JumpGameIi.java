package greedy;


/**
 * 45. 跳跃游戏 II
 *
 * @author xieyu
 * @keywords: 贪心
 * @ideas: 跳完一步后要选择能跳到最远的位置作为下一个跳到的位置
 * @since 2021-7-6 21:24:57
 */
public class JumpGameIi {
    public int jump(int[] nums) {
        int end = 0, max = 0, steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            // 每次更新能跳到的最大位置
            max = Math.max(max, nums[i] + i);
            if (i == end) {
                // 如果到边界了说明消耗一次跳跃,并把边界更新到现在能到的最远的地方
                steps++;
                end = max;
            }
        }
        return steps;
    }
}