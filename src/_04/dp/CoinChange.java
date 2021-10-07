package _04.dp;

/**
 * 322. 零钱兑换
 *
 * @author xieyu
 * @keywords: dp
 * @ideas:
 * @since 2021-7-6 21:24:57
 */
public class CoinChange {
    // 从下往上
//    public int coinChange(int[] coins, int amount) {
//        int[] memo = new int[amount + 1];
//        for (int i = 1; i < memo.length; i++) {
//            int min = Integer.MAX_VALUE;
//            for (int coin : coins) {
//                // 遍历每个coin找到减去该coin后总硬币个数最小的值
//                int lastCost = i - coin;
//                if (lastCost >= 0 && memo[lastCost] != -1) {
//                    min = Math.min(min, memo[lastCost] + 1);
//                }
//            }
//            memo[i] = min != Integer.MAX_VALUE ? min : -1;
//        }
//        return memo[amount];
//    }


    // 从上往下
    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        return dfs(coins, amount, memo);
    }

    private int dfs(int[] coins, int amount, int[] memo) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        if (memo[amount] != 0) {
            return memo[amount];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int cost = dfs(coins, amount - coin, memo);
            if (cost != -1) {
                min = Math.min(min, cost + 1);
            }
        }
        min = min == Integer.MAX_VALUE ? -1 : min;
        memo[amount] = min;
        return min;
    }
}