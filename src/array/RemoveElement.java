package array;

/**
 * 27. 移除元素
 *
 * @author xieyu
 * @keywords: array
 * @ideas:
 * @since 2021-7-3 10:47:38
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        // 双指针
        int l = 0, r = 0;
        while (r < nums.length) {
            // 如果当前值和val一样l就会停下来,直到r找到一个和val不一样的数,并且和l交换位置,就达到了把和val相同的数移到后面的目的
            if (nums[r] != val) {
                nums[l] = nums[r];
                l++;
            }
            r++;
        }
        return l;
    }
}