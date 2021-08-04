package _02.sort.shell;

/**
 * 506. 相对名次
 *
 * @author xieyu
 * @keywords: 排序 二分
 * @ideas:
 * @since 2021/08/04 15:06
 */
public class RelativeRanks {
    public String[] findRelativeRanks(int[] score) {
        int[] sortedScore = score.clone();
        shellSort(sortedScore);
        String[] ans = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int rank = score.length - bs(sortedScore, score[i]);
            if (rank == 1) {
                ans[i] = "Gold Medal";
            } else if (rank == 2) {
                ans[i] = "Silver Medal";
            } else if (rank == 3) {
                ans[i] = "Bronze Medal";
            } else {
                ans[i] = rank + "";
            }
        }
        return ans;
    }


    private int bs(int[] arr, int i) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (arr[mid] == i) {
                return mid;
            }
            if (arr[mid] > i) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private void shellSort(int[] arr) {
        int maxGap = 0;
        while (maxGap < arr.length) {
            maxGap = maxGap * 3 + 1;
        }
        maxGap = (maxGap - 1) / 3;
        for (int gap = maxGap; gap > 0; gap = (gap - 1) / 3) {
            for (int i = gap; i < arr.length; i += gap) {
                int curNum = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > curNum) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = curNum;
            }
        }
    }
}