package com.mani.soni.dynamicprogramming;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] value = {10, 40, 30, 50};

        int[] weight = {5, 4, 6, 3};

        int knapsack = 10;

        System.out.println(findMaxValue(knapsack, value, weight, 0));

    }

    /**
     * Recursive solution for this problem.
     * @param knapsack
     * @param value
     * @param weight
     * @param index
     * @return
     */
    private static int findMaxValue(int knapsack, int[] value, int[] weight, int index) {

        if(knapsack <= 0) {
            return 0;
        }

        if(index >= value.length) {
            return 0;
        }
        int profit1 = 0;
        // This is important to check if we can include this item or not.
        if(knapsack >= weight[index]) {
             profit1 = value[index] + findMaxValue(knapsack - weight[index], value, weight, index + 1);
        }

        return Math.max(profit1,
                findMaxValue(knapsack, value, weight, index + 1));
    }
}
