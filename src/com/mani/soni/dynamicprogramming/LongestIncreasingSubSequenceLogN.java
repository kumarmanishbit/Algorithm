package com.mani.soni.dynamicprogramming;

/**
 * Recursive solution: Here for every element we get two choice.
 * either pick it up or leave it.
 * so we use both choice, and get the maximum result.
 */
public class LongestIncreasingSubSequenceLogN {

    public static void main(String[] args) {
        int[] arr = {4, 10, 6, 5, 8, 11, 2, 20};

        System.out.println(findLISLogN(arr));

    }

    private static int findLISLogN(int[] arr) {

        int[] tail = new int[arr.length];

        int index = 0;
        tail[index] = arr[index];
        for (int i = 1; i < arr.length; i++) {
            if(tail[index] < arr[i]) {
                tail[++index] = arr[i];
            } else {
                int ceil = findCeil(tail, 0, index, arr[i]);
                tail[ceil] = arr[i];
            }
        }

        return index + 1;
    }

    private static int findCeil(int[] tail, int low, int high, int element) {

        int ceil = -1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if(tail[mid] == element) {
                return mid;
            } else if(tail[mid] > element) {
                ceil = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ceil;
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
