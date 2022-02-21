package com.mani.soni.dynamicprogramming;

import java.util.Arrays;

/**
 * Recursive solution: Here for every element we get two choice.
 * either pick it up or leave it.
 * so we use both choice, and get the maximum result.
 */
public class LongestIncreasingSubSequence {

    private static int[][] memo;

    public static void main(String[] args) {
//        int[] arr = {3, 4, 2, 8, 10};
        int[] arr = {4, 10, 6, 5, 8, 11, 2, 20};
        memo = new int[arr.length][arr.length + 1];

        System.out.println(findLIS(arr, 0, -1));
        System.out.println(memo[0]);
        System.out.println(memo[0][0]);
    }

    /**
     * This recursive solution start from beginning.
     * @param arr
     * @param start
     * @param prev
     * @return
     *
     */
    private static int findLIS(int[] arr, int start, int prev) {

        // when we exhaust the array then simply return 0.
        if(start > arr.length - 1) {
            return 0;
        }

        if(memo[start][prev + 1] >  0) {
            return memo[start][prev + 1];
        }

            //   return memo[start][prev];
            int res1 = 0, res2 = 0;

            if (prev == -1 || arr[start] > arr[prev]) {
                // If we find any candidate then pick one or ignore it.
                res1 = 1 + findLIS(arr, start + 1, start);
                // if we did not find one then we must ignore it.
            }

            res2 = findLIS(arr, start + 1, prev);

            memo[start][prev + 1] = Math.max(res1, res2);


        return memo[start][prev + 1];
    }

    /**
     * This recursive solution start from end.
     * LIS(i) = 1 + max ( LIS(j) ) where  0 < j < i and arr[i] > arr[j]
     * LIS[i] = 1 : for all element
     *
     *
     * Input  : arr[] = {3, 10, 2, 11}
     * f(i): Denotes LIS of subarray ending at index 'i'
     *
     * (LIS(1)=1)
     *
     *       f(4)  {f(4) = 1 + max(f(1), f(2), f(3))}
     *   /    |    \
     * f(1)  f(2)  f(3) {f(3) = 1, f(2) and f(1) are > f(3)}
     *        |      |  \
     *       f(1)  f(2)  f(1) {f(2) = 1 + max(f(1)}
     *               |
     *             f(1) {f(1) = 1}
     */
    public int findAnotherRecursiveSolution(int[] arr, int n) {
        int res = 0;

        for (int i = 0; i < n; i++) {

        }
        return res;
    }

}
