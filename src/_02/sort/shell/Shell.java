package _02.sort.shell;

/**
 * @author xieyu
 * @since 2021/08/04 14:39
 */
public class Shell {
    /**
     * v1
     * 先算出增量序列最大值,然后在正常插入排序外层包一个[40,13,4,1](3n+1的增量 序列)逐渐缩小的循环
     *
     * @param arr
     */
    public void shellSort1(int[] arr) {
        // 确定最大增量序列
        int maxGap = 0;
        while (maxGap < arr.length) {
            int res = maxGap * 3 + 1;
            if (res > arr.length) {
                break;
            }
            maxGap = res;
        }
        for (int gap = maxGap; gap > 0; gap = (gap - 1) / 3) {
            for (int j = 1; j < arr.length; j++) {
                int curNum = arr[j];
                int end = j - 1;
                while (end >= 0 && arr[end] > curNum) {
                    arr[end + 1] = arr[end];
                    end--;
                }
                arr[end + 1] = curNum;
            }
        }
    }

    /**
     * v2
     * 在v1的基础上将正常插入排序的1都改成gap
     *
     * @param arr
     */
    public void shellSort(int[] arr) {
        // 确定最大增量序列
        int maxGap = 0;
        while (maxGap < arr.length) {
            int res = maxGap * 3 + 1;
            if (res > arr.length) {
                break;
            }
            maxGap = res;
        }
        for (int gap = maxGap; gap > 0; gap = (gap - 1) / 3) {
            for (int j = gap; j < arr.length; j += gap) {
                int curNum = arr[j];
                int end = j - gap;
                while (end >= 0 && arr[end] > curNum) {
                    arr[end + gap] = arr[end];
                    end -= gap;
                }
                arr[end + gap] = curNum;
            }
        }
    }
}