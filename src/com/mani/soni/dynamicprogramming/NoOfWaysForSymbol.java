package com.mani.soni.dynamicprogramming;

/**
 * Given a set of positive numbers (non zero) and a target sum ‘S’.
 * Each number should be assigned either a ‘+’ or ‘-’ sign. We need to
 * find out total ways to assign symbols to make the sum of numbers equal to
 * target ‘S’.
 */
public class NoOfWaysForSymbol {

    private static int count = 0;
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int sum=1;

        noOfWays(arr, sum, 0);
    }

    private static int noOfWays(int[] arr, int sum, int index) {

        arr[index] = (-1) * arr[index];
        if(noOfWays(arr, sum, index) == sum) {
            count++;
        }
        arr[index] = (-1) * arr[index];
        if(noOfWays(arr, sum, index) == sum) {
            count++;
        }

        return sum;
    }
}
