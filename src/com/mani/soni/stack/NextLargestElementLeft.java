package com.mani.soni.stack;

import java.util.Stack;

public class NextLargestElementLeft {

    public static void main(String[] args) {
        int[] arr = {4, 6, 3, 2, 8, 1, 2};

        findNextElementInOrderToLeft(arr);
    }

    /**
     * Find next greater element in order
     * @param arr
     */
    private static void findNextElementInOrderToLeft(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];

        // To find the result in order we have to traverse from end.
        for (int i = 0; i < arr.length; i++) {

            // stack always hold the greater element
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // top of the stack will be the greater element
            result[i] = stack.empty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
