package com.mani.soni.stack;

import java.util.Arrays;

public class MinimumComplexity {

    private static int n, d;
    private static int[][] memo;

    public static void main(String[] args) {

        int length[] = {1, 2, 3, 4, 5, 6};

        int prices[] =  {6,5,4,3,2,1};

        int rodLength = 6;

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
