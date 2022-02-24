package com.mani.soni.dynamicprogramming;

public class CountOfSubSetSum {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 1, 2, 3};

        int value =4;

        System.out.println(countSubsetSum(arr, value));
    }

    private static int countSubsetSum(int[] arr, int sum) {

        boolean[][] dp = new boolean[arr.length + 1][sum + 1];

        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][0] = true;
        }

        int count = 0;

        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if (dp[i - 1][j]) {
                    dp[i][j] = dp[i - 1][j];
                } else if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]];
                }
                if(dp[i][j] && j == sum) {
                    count++;
                }
            }
        }

        return count;
    }
}
