package com.mani.soni.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumDifference {

    public static void main(String[] args) {
        int[] arr = {5, 10, 6, 8};
        Arrays.sort(arr);
        // {5, 6, 8, 10}
        // {5, 8, 10 ,6}
        // 3 + 2 + 4 + 1 = 10
        // [6, 5, 8, 10] = 1 + 3 + 2 + 4= 6
        List<Integer> seq = new ArrayList<>();

        seq.add(arr[0]);
        int last = arr[1];

        for (int i = 2; i < arr.length; i++) {
            seq.add(arr[i]);
        }

        seq.add(last);

        int max = Integer.MIN_VALUE;

        max = Math.max(Math.abs(seq.get(1) - seq.get(0)), Math.abs(seq.get(seq.size() - 1) - seq.get(0)));

        for (int i = 1; i < seq.size() - 1; i++) {
            max = Math.max(max, Math.max(Math.abs(seq.get(i) - seq.get(i + 1)), Math.abs(seq.get(i - 1) - seq.get(i))));
        }

        System.out.println(max);
    }
}
