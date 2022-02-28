package com.mani.soni.stack;

import java.util.Stack;

public class NextSmallerElementLeft {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};

        findNextSmallerToLeft(arr);

    }

    /**
     * Find next smaller element to the left in order
     * @param arr
     */
    private static void findNextSmallerToLeft(int[] arr) {
        // {4, 5, 2, 10, 8};
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            // stack always hold the smaller element
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            // top of the stack will be the smaller element
            result[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
