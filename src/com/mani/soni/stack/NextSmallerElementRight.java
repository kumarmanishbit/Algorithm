package com.mani.soni.stack;

import java.util.Stack;

public class NextSmallerElementRight {
    public static void main(String[] args) {
        int[] arr = {4, 8, 5, 2, 25};

        findNextSmallerToRight(arr);

    }

    /**
     * Find next smaller element to the right in order
     * @param arr
     */
    private static void findNextSmallerToRight(int[] arr) {
        // {4, 5, 2, 10, 8};
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {
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
