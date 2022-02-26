package com.mani.soni.binarysearch;

/**
 * https://leetcode.com/problems/find-peak-element/
 *
 * A peak element is an element that is strictly greater than its neighbors.
 * Given an integer array nums, find a peak element, and return its index. If the array contains multiple peaks,
 * return the index to any of the peaks.
 *
 *
 * Fact: There will always be an element which is peak in the array.
 */
public class PeakElement {

    public static void main(String[] args) {
        int[] arr = {1};

       findPeakElement(arr);

    }

    /**
     * TC: O(n)
     * SC: O(1)
     * @param arr
     */
    private static void findPeakElement(int[] arr) {
        int prev = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            if(i == arr.length - 1 && arr[i] >= prev && arr[i] >= Integer.MIN_VALUE) {
                System.out.println(arr[i]);
            } else if(i < arr.length - 1 && prev <= arr[i] && arr[i] >= arr[i + 1]) {
                prev = arr[i];
                System.out.println(arr[i]);
            }
        }
    }

    static int findPeakElementEfficient(int[] num)
    {
        int low = 0;
        int high = num.length - 1;

        while(low < high)
        {
            int mid1 = (low+high)/2;
            int mid2 = mid1+1;
            if(num[mid1] < num[mid2])
                low = mid2;
            else
                high = mid1;
        }
        return low;
    }
}
