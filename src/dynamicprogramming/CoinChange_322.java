package dynamicprogramming;

import java.util.Arrays;

class CoinChange_322 {
    // 暴力递归
    int coinChange1(int[] coins, int amount) {
        return dp1(coins, amount);
    }

    // 要凑出金额 amount，至少要 dp[coins, n]个硬币
    int dp1(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp1(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }


    // 带备忘录的递归
    int[] memo;

    int coinChange2(int[] coins, int amount) {
        memo = new int[amount + 1];
        // 备忘录初始化为一个不会被取到的值
        Arrays.fill(memo, -666);

        return dp2(coins, amount);
    }

    int dp2(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;

        // 查备忘录
        if (memo[amount] != -666)
            return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题
            int subProblem = dp2(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }


    // dp 数组的迭代解法
    int coinChange3(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有值
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange_322 coinChange = new CoinChange_322();
        int[] coins = {1,2,5};
        int amount = 11;
        System.out.println(coinChange.coinChange1(coins,amount));
        System.out.println(coinChange.coinChange2(coins,amount));
        System.out.println(coinChange.coinChange3(coins,amount));
    }
}
