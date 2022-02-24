package com.mani.soni.dynamicprogramming;

/**
 * Given a rod of length ‘n’, we are asked to cut the rod and sell the pieces in a way that will maximize the profit.
 * We are also given the price of every piece of length ‘i’ where ‘1 <= i <= n’.
 *
 * This is another variation of unbounded knapsack problem. This problem can be mapped to the Unbounded Knapsack
 * pattern. The ‘Weights’ array of the Unbounded Knapsack problem is equivalent to the ‘Lengths’ array, and Profits
 * is equivalent to Prices.
 */
public class RodCuttingProblem {

    public static void main(String[] args) {

        int length[] = {1, 2, 3, 4, 5};

        int prices[] =  {2, 6, 7, 10, 13};

        int rodLength = 5;

        System.out.println(findMaxProfit(length, prices, rodLength));
    }

    private static int findMaxProfit(int[] length, int[] prices, int rodLength) {
        int[][] dp = new int[prices.length + 1][rodLength + 1];

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < rodLength + 1; j++) {
                if(j >= length[i - 1]) {
                    dp[i][j] = prices[i - 1] + dp[i][j - length[i - 1]];
                }

                // Remember If we skip it, then we take the price from the cell right above it
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }

        return dp[prices.length][rodLength];
    }
}
