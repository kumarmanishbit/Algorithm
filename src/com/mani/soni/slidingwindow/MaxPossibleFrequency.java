package com.mani.soni.slidingwindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MaxPossibleFrequency {
    public static void main(String[] args) {
        int k = 2;
        System.out.println(maxFrequency(new int[]{3, 6, 9}, k));
    }

    public static int maxFrequency(int[] arr, int k) {
        Arrays.sort(arr);
        // [3, 6, 9]
        int i = 0;
        int j = 0;
        int sum = arr[0];

        int max = Integer.MIN_VALUE;

        Map<Integer, Integer> freq = new HashMap<>();

        while(j < arr.length) {
            System.out.println(String.format("Processing %d", arr[j]));
            if((j - i + 1) * arr[j] <= k + sum) {
                max = Math.max(max , j - i + 1);
                System.out.println(String.format("Max %d", max));
                j++;
                sum += arr[j];
            } else if((j - i + 1) * arr[j] > k + sum) {
                while((j - i + 1) * arr[j] >= k + sum) {
                    sum -= arr[i];
                    i++;
                }
            }
        }
        return max;
    }
}
