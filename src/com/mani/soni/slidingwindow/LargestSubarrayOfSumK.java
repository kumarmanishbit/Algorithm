package com.mani.soni.slidingwindow;

public class LargestSubarrayOfSumK {

    public static void main(String[] args) {
        int[] arr = {10, 5, 2, 7, 1, 9 };
        int k = 15;

        int j = 0, i = 0;
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        while(j < arr.length) {
            sum += arr[j];

            if(sum < k) {
                j++;
                continue;
            }

            if(sum == k) {
                maxSum = Math.max(maxSum, j - i + 1);
                j++;
            } else if (sum > k){
                while (sum > k && i < arr.length) {
                  sum -= arr[i];
                  i++;
                }
                j++;
            }
        }

        System.out.println(maxSum);
    }
}
