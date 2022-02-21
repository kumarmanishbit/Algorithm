package com.mani.soni.dynamicprogramming;

public class CoinChangeDP {

    public static void main(String[] args) {
        int[] coins = {2,5,3,6};
        int sum = 10;

        System.out.println(noOfWays(coins, sum));
    }

    private static int noOfWays(int[] coins, int sum) {
        if(sum <= 0) {
            return 0;
        }

        int ways = 0;

        for (int i = 0; i < coins.length; i++) {
            ways += noOfWays(coins, sum - coins[i]);
        }

        return  ways;
    }
}
