package com.mani.soni.dynamicprogramming;

/**
 * Given an infinite supply of ‘n’ coin denominations and a total money amount, we are asked to find the total
 * number of distinct ways to make up that amount.
 *
 * Denominations: {1,2,3}
 * Total amount: 5
 * Output: 5
 * Explanation: There are five ways to make the change for '5', here are those ways:
 *   1. {1,1,1,1,1}
 *   2. {1,1,1,2}
 *   3. {1,2,2}
 *   4. {1,1,3}
 *   5. {2,3}
 */
public class CoinChangeDP {

    public static void main(String[] args) {
        int[] coins = {5, 10, 25, 100, 200};
        int sum = 94;

        System.out.println(noOfWays(coins, sum, coins.length - 1));
        System.out.println(canGetExactChange(sum, coins, coins.length - 1));
        System.out.println(findMaxNumberOfWays(coins, sum));
    }

    static boolean canGetExactChange(int sum, int[] coins, int i) {
        if(sum == 0) {
            return true;
        }

        if(i < 0) {
            return false;
        }

        if(i >= 0 && sum <= 0) {
            return false;
        }

        return canGetExactChange(sum - coins[i], coins, i) || canGetExactChange(sum, coins, i - 1);
    }

    private static int noOfWays(int[] coins, int sum, int i) {
        if(sum == 0) {
            return 1;
        }
        if(i < 0) {
            return 0;
        }
        if(i >= 0 && sum <= 0) {
            return 0;
        }
        return noOfWays(coins, sum - coins[i], i) + noOfWays(coins, sum, i - 1);
    }

    /**
     *
     * dp[index][t] = dp[index-1][t] + dp[index][t-denominations[index]]
     *
     * So for every possible total ‘t’ (0<= t <= Total) and for every possible coin index (0 <= index < denominations.length), we have two options:
     *
     * Exclude the coin. Count all the coin combinations without the given coin up to the total ‘t’ => dp[index-1][t]
     * Include the coin if its value is not more than ‘t’. In this case, we will count all the coin combinations to get the remaining total: dp[index][t-denominations[index]]
     * @param coins
     * @param value
     * @return
     */
    private static int findMaxNumberOfWays(int[] coins, int value) {

        int[][] dp = new int[coins.length + 1][value + 1];

        for (int i = 0; i < value + 1; i++) {
            dp[0][i] = 0;
        }

        // populate the total=0 columns, as we will always have an empty set for zero total
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        // process all sub-arrays for all capacities
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < value + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j >= coins[i - 1]) {
                    dp[i][j] += dp[i][j - coins[i - 1]];
                }

            }
        }

        return dp[coins.length][value];
    }
}
