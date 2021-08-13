package _02.sort.merge;

/**
 * 面试题 10.01. 合并排序的数组
 *
 * @author xieyu
 * @keywords: 倒序遍历
 * @ideas:
 * @since 2021-8-10 09:51:27
 */
public class SortedMergeLcci {
    public void merge(int[] A, int m, int[] B, int n) {
        // 如果从头遍历会出现覆盖掉A的现象,所以从后面开始遍历
        int index1 = m - 1;
        int index2 = n - 1;
        int index = A.length - 1;
        while (index1 >= 0 || index2 >= 0) {
            if (index1 < 0) {
                A[index] = B[index2--];
            } else if (index2 < 0) {
                A[index] = A[index1--];
            } else if (A[index1] >= B[index2]) {
                A[index] = A[index1--];
            } else {
                A[index] = B[index2--];
            }
            index--;
        }
    }
}