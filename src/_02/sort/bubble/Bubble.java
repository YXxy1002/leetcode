package _02.sort.bubble;

/**
 * 冒泡排序
 *
 * @author xieyu
 * @keywords: 冒泡
 * @ideas: 每次交换后把最大的移动到最后
 * @since 2021/07/29 下午 8:26
 */
public class Bubble {
    /**
     * 每次交换后把最大的移动到最后
     *
     * @param arr
     */
    public void bubbleSort1(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
    }

    /**
     * 每次交换后把最大的移动到最后,如果没发生交换说明已经有序,直接跳出
     *
     * @param arr
     */
    public void bubbleSort2(int[] arr) {
        boolean swapt = true;
        for (int i = 0; i < arr.length - 1; i++) {
            if (!swapt) {
                break;
            }
            swapt = false;
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapt = true;
                }
            }
        }
    }

    private void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}