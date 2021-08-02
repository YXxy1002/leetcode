package _02.sort.selectction;

/**
 * @author xieyu
 * @since 2021/07/30 下午 8:54
 */
public class Selection {
    public void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int select = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[select]) {
                    select = j;
                }
            }
            swap(arr, i, select);
        }
    }

    public static void main(String[] args) {
        Selection a = new Selection();
        int[] ints = {1, 7, 4, 7, 4, 3, 8};
        a.selectionSort(ints);
        System.out.println();
    }


    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}