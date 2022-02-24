package com.mani.soni.dynamicprogramming;

/**
 * Given the weights and profits of ‘N’ items, we are asked to put these
 * items in a knapsack that has a capacity ‘C’. The goal is to get the maximum
 * profit from the items in the knapsack. The only difference between the 0/1
 * Knapsack problem and this problem is that we are allowed to use an unlimited
 * quantity of an item.
 *
 */
public class UnboundedKnapsack {

    public static void main(String[] args) {
        int[] weight = {1, 2, 3};

        int[] profits = {15, 20, 50};

        int capacity = 5;

        System.out.println(findUnboundedMaxProfit(weight, profits, capacity));

    }

    /**
     *  dp[index][c] = max (dp[index-1][c], profit[index] + dp[index][c-weight[index]])
     * @param weight
     * @param profits
     * @param capacity
     * @return
     */
    private static int findUnboundedMaxProfit(int[] weight, int[] profits, int capacity) {

        int[][] dp = new int[weight.length + 1][capacity + 1];

        for (int i = 0; i < capacity + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < capacity + 1; j++) {

                if(j >= weight[i - 1]) {
                    // The only difference between 0/1 knapsack and this is that here
                    // we can include this element many number of times. thus: dp[i]
                    // in 0/1 knapsack this code was dp[i - 1][j - weight[i - 1]]
                    dp[i][j] = profits[i - 1] + dp[i][j - weight[i - 1]];
                }

                // Remember If we skip it, then we take the item from the cell right above it
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
            }
        }

        return dp[weight.length][capacity];
    }
}
