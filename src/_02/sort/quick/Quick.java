package _02.sort.quick;

import java.util.Queue;

/**
 * @author xieyu
 * @since 2021/08/04 14:39
 */
public class Quick {
    /**
     * v1
     * 先算出增量序列最大值,然后在正常插入排序外层包一个[40,13,4,1](3n+1的增量 序列)逐渐缩小的循环
     *
     * @param arr
     */
    public void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int l, int r) {
        // 退出条件: 排序区间小于等于1
        if (r <= l) {
            return;
        }
        int i = l, j = r;
        // 选取最左边的数作为基准数
        int base = arr[l];
        // 两指针向里移动
        while (i < j) {
            // 注意这两个while不能交换位置,必须j先行.反例:[1,2,3,4,5],如果i先行将会排序成[2,1,3,4,5]
            // 从右边开始一直找到比base更小的数停下
            while (i < j && arr[j] >= base) {
                j--;
            }
            // 从左边开始一直找到比base更大的数停下
            while (i < j && arr[i] <= base) {
                i++;
            }
            // 如果两个指针未重合就交换i,j
            if (i < j) {
                swap(arr, i, j);
            }
        }
        // 最后需要交换base和i
        swap(arr, l, i);
        sort(arr, l, i - 1);
        sort(arr, i + 1, r);
    }

    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}