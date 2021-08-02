package slidingWindow;

import java.util.Arrays;

/**
 * 替换后的最长重复字符
 *
 * @author xieyu
 * @keywords: 滑动窗口
 * @ideas:
 * @since 2021-7-10 20:14:32
 */
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        // 核心:每次都要算出当前最多的元素n,当n+k还大于窗口size的时候就可以继续扩张,否则窗口就要移动
        // 4个要素: 左右边界,arr(保存每个字母出现的次数) mostChar(保存出现最多次数的)
        int[] arr = new int[26];
        int mostChar = 0;
        int l = 0;
        char[] chars = s.toCharArray();
        // 1.右边界什么时候更新? 一直往右更新
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            // 2.更新右边界做什么? 放入arr,计算mostChar
            arr[c - 'A']++;
            mostChar = Math.max(mostChar, arr[c - 'A']);
            // 3.什么时候更新左边界? 每次都要算出当前最多的元素n,当n+k<size的时候说明左边界需要缩小了
            if (mostChar + k < i - l + 1) {
                arr[chars[l] - 'A']--;
                l++;
            }
        }
        return s.length() - l + 1;
    }

}