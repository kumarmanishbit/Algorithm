package com.mani.soni.binarysearch;

public class FindKClosestElement {

    public static void main(String[] args) {
        int k = 1;
        int x = 2;
        int arr[] = {1 ,3};

        findKClosestElement(arr, k , x);
        findClosestElements(arr, k, x);
    }

    public static void findClosestElements(int[] A, int k, int x) {
        int left = 0, right = A.length - k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (x - A[mid] > A[mid + k] - x)
                left = mid + 1;
            else
                right = mid;
        }

        for (int i = left; i < k; i++) {
            System.out.println(A[i]);
        }
    }

    private static void findKClosestElement(int[] arr, int k, int x) {

        int crossOverPoint = crossOver(arr, x, false);

//        if(arr[crossOverPoint] != x) {
//          int floorPoint = crossOver(arr, x, false);
//          if(x - arr[floorPoint] <= crossOverPoint - x) {
//              crossOverPoint = floorPoint;
//          }
//        }

        int i = crossOverPoint;
        int j = crossOverPoint;

        while(k > 0 && i >= 0 && j < arr.length) {
            if(x - arr[i] > arr[j] - x) {
                System.out.println(arr[j]);
                j++;
            } else if (x - arr[i] <= arr[j] - x) {
                System.out.println(arr[i]);
                i--;
            }
            k--;
        }

        while(k > 0 && i >= 0) {
                System.out.println(arr[i]);
                i--;
                k--;
        }

        while(k > 0 && j < arr.length) {
            System.out.println(arr[j]);
            j++;
            k--;
        }
    }

    private static int crossOver(int[] arr, int x, boolean c) {

        if(x < arr[0]) {
            return 0;
        } else if (x > arr[arr.length - 1]) {
            return arr.length - 1;
        }

        int floor = -1;
        int ceil = -1;
        int low = 0;
        int high = arr.length - 1;

        while(low <= high) {

            int mid = (int) (low + Math.ceil((high - low) / 2.0));

            if(arr[mid] == x) {
                return mid;
            } else if(x > arr[mid]) {
                floor = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
                ceil = mid;
            }
        }

        System.out.println("floor is "+ floor);
        return c ? ceil : floor;
    }
}
