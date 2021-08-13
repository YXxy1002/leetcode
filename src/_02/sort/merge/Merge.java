package _02.sort.merge;

/**
 * 版本1: 每次合并返回新的数组,需要开辟额外的空间
 *
 * @author xieyu
 * @since 2021/08/12 16:34
 */
public class Merge {
    public void mergeSort(int[] arr) {
        if (arr.length == 0) {
            return;
        }
        int[] res = mergeSort(arr, 0, arr.length - 1);
        System.arraycopy(res, 0, arr, 0, arr.length);
    }

    private int[] mergeSort(int[] arr, int l, int r) {
        // 退出条件:只剩一个数字
        if (l == r) {
            return new int[]{arr[l]};
        }
        // 将数组分成两部分进行排序
        int mid = (l + r) / 2;
        int[] left = mergeSort(arr, l, mid);
        int[] right = mergeSort(arr, mid + 1, r);
        // 将左右2个有序数组合并
        return merge(left, right);
    }

    private int[] merge(int[] arr1, int[] arr2) {
        int[] res = new int[arr1.length + arr2.length];
        int index1 = 0, index2 = 0;
        // 将2个数组按照更小的数排在前面,直到任意一个数组完毕
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] <= arr2[index2]) {
                res[index1 + index2] = arr1[index1];
                index1++;
            } else {
                res[index1 + index2] = arr2[index2];
                index2++;
            }
        }
        // 将剩余数组加在res尾部
        while (index1 < arr1.length) {
            res[index2 + index1] = arr1[index1++];
        }
        while (index2 < arr2.length) {
            res[index2 + index1] = arr2[index2++];
        }
        return res;
    }
}