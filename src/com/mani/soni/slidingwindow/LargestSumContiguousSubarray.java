package com.mani.soni.slidingwindow;

public class LargestSumContiguousSubarray {

    public static void main(String[] args) {
        int[] arr = { -2, -3, 4, -1, -2, 1, 5, -3 };

        int maxEndingHere = 0;
        int maxSumTillNow = Integer.MIN_VALUE;

        int start = 0;
        int end = 0;

        int j = 0;

        while(j < arr.length) {

            // All calculation here is candidate of result
            maxEndingHere += arr[j];

            // condition
            // maxSumTillNow = Math.max(maxSumTillNow, maxEndingHere);

            if(maxSumTillNow < maxEndingHere) {
                maxSumTillNow = maxEndingHere;
                end = j;
            }
            // result can be violated if we got negative element.
            if(maxEndingHere < 0) {
                maxEndingHere = 0;
                start = j + 1;
                end = j + 1;
            }
            j++;
        }

        System.out.println(maxSumTillNow);
        System.out.println(end - start + 1);
    }
}
