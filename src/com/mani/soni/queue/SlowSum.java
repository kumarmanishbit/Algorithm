package com.mani.soni.queue;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class SlowSum {
    public static void main(String[] args) {
        int[] arr = {4, 2, 1, 3};
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        int penalty = 0;

        while(queue.size() != 1 && !queue.isEmpty()) {
            int first = queue.poll();
            int second = 0;
            if(!queue.isEmpty()) {
                second = queue.poll();
            }

            penalty += first + second;
            queue.add(first + second);
        }

        System.out.println(penalty);
    }
}
