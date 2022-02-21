package com.mani.soni.dynamicprogramming;

public class Floor {
    public static void main(String[] args) {
        int[] arr = {1, 3,  5, 6, 10, 23, 25, 100, 201};

        int element = 11;
        System.out.println(arr[floor(arr, 0 , arr.length - 1, element)]);
    }

    private static int floor(int[] arr, int low, int high, int element) {

        int floor = -1;

        while(low <= high) {

            int mid = low + (high - low) / 2;

            if (arr[mid] == element) {
                return mid;
            }

            if (arr[mid] > element) {
                high = mid - 1;
            } else {
                floor = mid;
                low = mid + 1;
            }
        }
        return floor;
    }
}
