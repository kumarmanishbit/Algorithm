package com.mani.soni.stack;

import java.util.*;
import java.util.stream.IntStream;

public class MinOperation {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3};
        int[] target = IntStream.rangeClosed(1, 10).toArray();
        System.out.println(Arrays.toString(target));

        Set<String> set = new HashSet<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(arr);

        int[] cloned = arr.clone();

        set.add(Arrays.toString(arr));

        while(!queue.isEmpty()) {



        }

    }
}
