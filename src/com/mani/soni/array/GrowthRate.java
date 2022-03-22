package com.mani.soni.array;

public class GrowthRate {
    public static void main(String[] args) {
        System.out.println(getBillionUsersDay(new float[]{1.5f}));
    }

    private static double userOnDay(float rate, int day) {
        return Math.pow(rate, day);
    }

    public static int getBillionUsersDay(float[] growthRates) {
        // Write your code here
        int start = 1;
        int end = 2_000;
        double target = 1_000_000_000;

        while (start < end) {
            double total = 0;
            int mid = start + (end - start) / 2;

            // calculate mid value
            for (float growthRate : growthRates) {
                total += userOnDay(growthRate, mid);
            }

            if (total == target) {
                return mid;
            }
            if (total > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }
}
