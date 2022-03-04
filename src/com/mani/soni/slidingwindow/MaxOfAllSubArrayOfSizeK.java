package com.mani.soni.slidingwindow;

import java.util.*;

public class MaxOfAllSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
//        getMaxOfSubArray(arr);
        getMaxOfSubArrayPriorityQueue(arr);
    }

    private static void getMaxOfSubArrayPriorityQueue(int [] arr) {
        int k = 3;

        // create a window of size k to hold the element
        Queue<Integer> window = new PriorityQueue<>(k, Comparator.reverseOrder());

        int j =0, i = 0;

        while(j < arr.length) {

            // Add small element to the first, and large element to the end of the queue.
            window.add(arr[j]);

            if(j - i + 1 < k) {
                j++;
            }else if(j - i + 1 == k) {
                System.out.println(window.peek());
                window.remove(arr[i]);
                i++;
            }
        }
    }

    private static void getMaxOfSubArray(int [] arr) {
        int k = 3;

        // create a window of size k to hold the element
        Deque<Integer> window = new ArrayDeque<>(k);

        int j =0, i = 0;
        window.add(arr[j]);

        while(j < arr.length) {

            // Add small element to the first, and large element to the end of the queue.
            if(!window.isEmpty() && window.peekFirst() > arr[j]){
                window.addFirst(arr[j]);
            }else if(!window.isEmpty() && window.peekLast() < arr[j]) {
                window.addLast(arr[j]);
            }

            if(j - i + 1 < k) {
                j++;
            }else if(j - i + 1 == k) {
                System.out.println(window.peekLast());
                window.pollFirst();
                i++;
            }
        }
    }
}
