package com.mani.soni.array;

import java.util.Arrays;

public class RevenueMileStone {

    public static void main(String[] args) {
        int[] revenues = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};
        int[] milestones = {100, 200, 500};

        int[] revenueSum = new int[revenues.length];
        revenueSum[0] = revenues[0];
        for (int i = 1; i < revenues.length; i++) {
            revenueSum[i] = revenueSum[i -1] + revenues[i];
        }
        int[] result = new int[milestones.length];

        for (int i = 0; i < milestones.length; i++) {
            int pos = Arrays.binarySearch(revenueSum, milestones[i]);
            if(pos < 0) {
                result[i] = Math.abs(pos + 1) + 1;
            } else {
                result[i] = pos + 1;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
