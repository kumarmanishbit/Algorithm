package com.mani.soni.dynamicprogramming;

import java.util.Arrays;

/**
 * Minimum coin change problem.
 * Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to
 * find the minimum number of coins needed to make up that amount.
 *
 * Denominations: {1,2,3}
 * Total amount: 5
 * Output: 2
 * Explanation: We need a minimum of two coins {2,3} to make a total of '5'
 *
 */
public class MinimumCoinChangeProblem {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 5;

        System.out.println(findMinCoinRequired(coins, sum));
    }

    /**
     *  dp[index][t] = min(dp[index-1][t], dp[index][t-denominations[index]] + 1)
     *
     * @param coins
     * @param sum
     * @return
     */
    private static int findMinCoinRequired(int[] coins, int sum) {
        int[][] dp = new int[coins.length + 1][sum + 1];

        for (int i = 0; i < coins.length + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        for (int i = 0; i < coins.length + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if(j >= coins[i - 1]) {
                    if(dp[i][j - coins[i - 1]] != Integer.MAX_VALUE) {
                        dp[i][j] = 1 + dp[i][j - coins[i - 1]];
                    }
                }

                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j]);
            }
        }

        return dp[coins.length][sum];
    }
}
