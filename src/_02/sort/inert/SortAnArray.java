package _02.sort.inert;

/**
 * 912. 排序数组
 *
 * @author xieyu
 * @keywords: 插入排序
 * @ideas:
 * @since 2021/08/02 20:35:16
 */
public class SortAnArray {
    public int[] sortArray(int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            // 记录当前位置数字
            int curNum = nums[i];
            // 从前一个数字开始进行插入
            int j = i - 1;
            // 对当前位置之前的所有数字进行比较,如果比当前数字小就把这个数字后移
            while (j >= 0 && nums[j] > curNum) {
                nums[j + 1] = nums[j];
                j--;
            }
            // 结束循环说明j=-1或者已经没有比curNum大的数字了,就把curNum设置到j+1的位置
            nums[j + 1] = curNum;
        }
        return nums;
    }
}