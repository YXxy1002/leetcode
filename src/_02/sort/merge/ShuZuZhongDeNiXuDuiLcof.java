package _02.sort.merge;

/**
 * 剑指 Offer 51. 数组中的逆序对
 *
 * @author xieyu
 * @keywords: 归并排序
 * @ideas: 在Merge2的基础上, 在每次合并2和有序数组的时候, 如果右边的小于左边的, 就计算出逆序对
 * @since 2021-8-13 19:40:14
 */
public class ShuZuZhongDeNiXuDuiLcof {
    public int reversePairs(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] res = new int[nums.length];
        return mergeSort(nums, 0, nums.length - 1, res);
    }


    private int mergeSort(int[] arr, int start, int end, int[] res) {
        // 退出条件:只有一个数的时候
        if (start == end) {
            return 0;
        }
        // 递归左右2部分
        int mid = (start + end) / 2;
        int left = mergeSort(arr, start, mid, res);
        int right = mergeSort(arr, mid + 1, end, res);
        // 将2部分合并,注意经过上面的递归这里[start,mid],[mid+1,end]都已经是有序的了
        int merge = merge(arr, start, end, res);
        return left + right + merge;
    }


    private int merge(int[] arr, int start1, int end2, int[] res) {
        int count = 0;
        int originStart = start1;
        // 补充好2个区间的开始和结束
        int end1 = (start1 + end2) / 2;
        int start2 = end1 + 1;
        // 声明在新数组的下标
        int resStart = start1;
        while (start1 <= end1 && start2 <= end2) {
            if (arr[start1] <= arr[start2]) {
                res[resStart++] = arr[start1++];
            } else {
                res[resStart++] = arr[start2++];
                count += end1 - start1 + 1;
            }
        }
        while (start1 <= end1) {
            res[resStart++] = arr[start1++];
        }
        while (start2 <= end2) {
            res[resStart++] = arr[start2++];
        }
        // 把res的数据复制到arr去,这里发现已经丢失了开始的start,所以在上面先记录下这2个值
        while (originStart <= end2) {
            arr[originStart] = res[originStart++];
        }
        return count;
    }
}