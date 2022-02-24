package com.mani.soni.dynamicprogramming;

/**
 * Another variation of 0/1 knapsack problem.
 */
public class SubsetSumProblem {
    public static void main(String[] args) {
//        int[] arr = {1,2, 3, 7};
//        int sum = 6;
        int[] arr = {2,2,1,1};
        int sum = 3;
        System.out.println(findSubSetSum(arr, sum));
        System.out.println(findSubSetSumUtilsDP(arr, sum));
    }

    private static boolean findSubSetSum(int[] arr, int sum) {

        return findSubSetSumUtils(arr, sum, 0);
    }

    private static boolean findSubSetSumUtils(int[] arr, int sum, int index) {

        if(index >= arr.length) {
            return false;
        }
        if(sum == 0) {
            return true;
        }
        return findSubSetSumUtils(arr, sum - arr[index], index + 1) || findSubSetSumUtils(arr, sum, index + 1);
    }

    private static boolean findSubSetSumUtilsDP(int[] arr, int sum) {

        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
//                if(j >= arr[i - 1]) {
//                    dp[i][j] = dp[i - 1][j - arr[i - 1]];
//                } else {
//                    dp[i][j] = dp[i - 1][j];
//                }

                if (dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j >= arr[i]) {
                    // else include the number and see if we can find a subset to get the remaining
                    // sum
                    dp[i][j] = dp[i - 1][j - arr[i]];
                }
            }
        }

        return dp[arr.length][sum];
    }
}
