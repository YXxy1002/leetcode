package _02.sort.merge;

/**
 * @author xieyu
 * @since 2021/08/12 16:34
 */
public class Merge2 {
    public void mergeSort(int[] arr) {
        int[] res = new int[arr.length];
        mergeSort(arr, 0, res.length - 1, res);
    }

    /**
     * 分左右2部分递归,并将结果放到res中,归并排序的第一个版本是生成了新的数组,而这里所有的变化都将在res中体现
     * 例如对于[3],[2]进行归并,第一个版本是生成了新的数组[2,3]并返回,而第二个版本是先声明好数组[0,0],然后将结果放进来变成[2,3]
     */
    private void mergeSort(int[] arr, int start, int end, int[] res) {
        // 退出条件:只有一个数的时候
        if (start == end) {
            return;
        }
        // 递归左右2部分
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid, res);
        mergeSort(arr, mid + 1, end, res);
        // 将2部分合并,注意经过上面的递归这里[start,mid],[mid+1,end]都已经是有序的了
        merge(arr, start, end, res);
    }

    /**
     * 这里为了更清晰逻辑可以把第二个参数改成start1,第三个参数改成end2,因为即将要对2个区间进行合并
     */
    private void merge(int[] arr, int start1, int end2, int[] res) {
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
    }


}