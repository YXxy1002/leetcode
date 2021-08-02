package _02.sort.bubble;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 *
 * @author xieyu
 * @keywords: 冒泡
 * @ideas: 两个相邻的数a, b如果字符串ab所表示的数字大于ba就要交换2个数字
 * @since 2021/07/29 下午 8:26
 */
public class BaShuZuPaiChengZuiXiaoDeShuLcof {

    public String minNumber(int[] nums) {
        boolean swap = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (!swap) {
                break;
            }
            swap = false;
            for (int j = 0; j < nums.length - 1 - i; j++) {
                // 如果ab>ba,就交换
                if (Long.parseLong("" + nums[j] + nums[j + 1]) > Long.parseLong("" + nums[j + 1] + nums[j])) {
                    swap(nums, j, j + 1);
                    swap = true;
                }
            }
        }
        StringBuilder ans = new StringBuilder();
        for (int num : nums) {
            ans.append(num);
        }
        return ans.toString();
    }

    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}