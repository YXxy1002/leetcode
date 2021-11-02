package _04.dp;

/**
 * 42. 接雨水
 *
 * @author xieyu
 * @keywords: dp
 * @ideas: 2个dp: 当前位置的左边最大高度和右边最大高度 当前位置能接雨水量=Math.min(left,right)-当前位置的高度
 * @since 2021-10-26 16:32:54
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int leftMax = height[0];
        left[0] = leftMax;
        for (int i = 1; i < left.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            left[i] = leftMax;
        }

        int rightMax = height[height.length - 1];
        right[0] = rightMax;
        for (int i = height.length - 1; i >= 0; i--) {
            rightMax = Math.max(rightMax, height[i]);
            right[i] = rightMax;
        }

        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            ans += Math.min(left[i], right[i]) - height[i];
        }
        return ans;
    }
}