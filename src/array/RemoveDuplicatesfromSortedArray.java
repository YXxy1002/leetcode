package array;

/**
 * 删除有序数组中的重复项
 *
 * @author xieyu
 * @keywords: 双指针
 * @ideas: 两个指针i=0,j=1,j一直往右,如果碰到不相等的数就可以把这个数移动到i+1的位置处
 * @since 2021/6/21 0021 上午 11:35
 */
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums) {
        // 两个指针
        int i = 0;
        int j = 1;
        while (j < nums.length) {
            // 相等j往下一个, 不相等就可以把j这个数字移到i+1处,并且2个指针都+1(优化点:j=i+1的时候不用复制)
            if (nums[j] != nums[i]) {
                if (j != i + 1) {
                    nums[i + 1] = nums[j];
                }
                i++;
            }
            j++;
        }
        return i + 1;
    }
}