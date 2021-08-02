package greedy;


import java.util.Arrays;
import java.util.Comparator;

/**
 * 55. 跳跃游戏
 *
 * @author xieyu
 * @keywords: 贪心
 * @ideas: 每次找出能到的最远距离, 如果当前位置大于最远距离说明到不了了
 * @since 2021-7-6 21:24:57
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int furthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (furthest < i) {
                return false;
            }
            furthest = Math.max(furthest, nums[i] + i);
            if (furthest >= nums.length - 1) {
                return true;
            }
        }
        return true;
    }
}