package com.mani.soni.dynamicprogramming;

import java.util.Arrays;

/**
 * Given a set of positive numbers, partition the set into two subsets with a
 * minimum difference between their subset sums.
 */
public class MaxSumSubsetDifference {
    public static void main(String[] args) {
        int[] arr = {1, 5, 3, 2, 4};
        int value = 0;

        findMaxSubSetDiff(arr, value);
    }

    private static void findMaxSubSetDiff(int[] arr, int value) {
        int sum = Arrays.stream(arr).sum();
        // if array is very large.
        // int sum = Arrays.stream(array).parallel().reduce(0,(a, b)->  a + b);
        System.out.println(findSubSetSumUtilsDP(arr, sum));
    }

    private static int findSubSetSumUtilsDP(int[] arr, int sum) {

        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][0] = true;
        }

        int min = Integer.MAX_VALUE;

        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j >= arr[i - 1]) {
                    // else include the number and see if we can find a subset to get the remaining
                    // sum
                    dp[i][j] = dp[i - 1][j - arr[i - 1]];
                }

                if(dp[i][j]) {
                    min = Math.min(min, Math.abs(sum - 2*j));
                }
            }
        }
        return min;
    }
}
