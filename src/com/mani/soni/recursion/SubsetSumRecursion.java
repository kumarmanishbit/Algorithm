package com.mani.soni.recursion;

public class SubsetSumRecursion {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 3, 6};
        int sum = 8;

        System.out.println(findSubset(arr, sum, 0));
    }

    private static boolean findSubset(int[] arr, int sum, int index) {

        // empty set {} has sum 0, and this is the subset of every set.
        if(index == arr.length - 1) {
            return (sum == 0) ? true: false;
        }
        return findSubset(arr, sum - arr[index],  index + 1) || findSubset(arr, sum, index + 1);
    }
}
