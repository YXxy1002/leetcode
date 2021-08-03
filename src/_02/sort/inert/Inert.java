package _02.sort.inert;

/**
 * @author xieyu
 * @since 2021/08/02 20:24
 */
public class Inert {
    public void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            // 记录当前位置数字
            int curNum = arr[i];
            // 从前一个数字开始进行插入
            int j = i - 1;
            // 对当前位置之前的所有数字进行比较,如果比当前数字小就把这个数字后移
            while (j >= 0 && arr[j] > curNum) {
                arr[j + 1] = arr[j];
                j--;
            }
            // 结束循环说明j=-1或者已经没有比curNum大的数字了,就把curNum设置到j+1的位置
            arr[j + 1] = curNum;
        }
    }
}