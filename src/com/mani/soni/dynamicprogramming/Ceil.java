package com.mani.soni.dynamicprogramming;

public class Ceil {
    public static void main(String[] args) {
        int[] arr = {1, 3,  5, 6, 10, 23, 25, 100, 201};

        int element = 99;
        System.out.println(arr[ceil(arr, 0 , arr.length - 1, element)]);
    }

    private static int ceil(int[] arr, int low, int high, int element) {

        int ceil = -1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == element) {
                return mid;
            }

            if (arr[mid] > element) {
                ceil = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ceil;
    }
}
