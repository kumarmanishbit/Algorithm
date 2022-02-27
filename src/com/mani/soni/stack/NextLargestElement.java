package com.mani.soni.stack;

import java.util.Stack;

public class NextLargestElement {

    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 2, 8, 1, 2};

        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int prevMax = - 1;
        for (int i = arr.length - 2; i >= 0; i--) {

            if(arr[i] < arr[i + 1]) {
                prevMax = arr[i + 1];
            }
            stack.push(prevMax);
        }

        int[] result = new int[arr.length];

        int i = 0;
        while(!stack.isEmpty()) {
            result[i++] = stack.pop();
        }

        for (int j = 0; j < result.length; j++) {
//            System.out.println(result[j]);
        }

        circularNextElement();

    }

    public static void circularNextElement() {
        int arr[] = {5, 4, 3, 2, 1};
        int result[] = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            int element = arr[i];
            int j = i + 1;
            boolean found = false;

            while(j != i) {
                if(arr[j % (arr.length)] > arr[i]) {
                    found = true;
                    break;
                }
                j++;
                j = j % (arr.length);
            }
            if(found) {
                result[i] = arr[j % (arr.length)];
            } else {
                result[i] = -1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(result[i]);
        }

    }
}
