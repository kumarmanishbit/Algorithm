package com.mani.soni.dynamicprogramming;

public class EqualSetPartition {

    public static void main(String[] args) {
        System.out.println(new Solution().canPartition(new int[]{1,2,2,1}));
    }
}

class Solution {
    public boolean canPartition(int[] nums) {

        int sum = 0;

        for(int i=0; i< nums.length;i++) {
            sum += nums[i];
        }

        if(sum % 2 != 0) {
            return false;
        }
        else {
            return findSubSetSumUtilsDP(nums, sum / 2);
        }
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
                if(j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[arr.length][sum];
    }
}
