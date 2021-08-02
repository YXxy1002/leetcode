package _01.binarySearch;


/**
 * 爱吃香蕉的珂珂
 *
 * @author xieyu
 * @keywords: 二分查找
 * @ideas: 找出能吃完香蕉的最小速度(左边界)
 * @since 2021-7-6 21:24:57
 */
public class KokoEatingBananas {
    public int minEatingSpeed(int[] piles, int h) {
        // 先算出右边界
        int l = 1, r = 0;
        for (int pile : piles) {
            r = Math.max(r, pile);
        }
        while (l < r) {
            int mid = (l + r) >>> 1;
            if (canFinish(piles, h, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean canFinish(int[] piles, int h, int s) {
        for (int pile : piles) {
            int cost = (pile + s - 1) / s;
            h -= cost;
        }
        return h >= 0;
    }

}