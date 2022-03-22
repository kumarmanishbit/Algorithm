package com.mani.soni.binarysearch;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

public class FindElementOnLeft {

    public static void main(String[] args) {
        Integer[] arr = {3, 4, 1, 6, 2};

//        Collections.reverse(Arrays.asList(arr));

        Integer[] GREL = findGreaterElementToLeft(arr);
        Integer[] GRER = findGreaterElementToRight(arr);

        int[] count = new int[arr.length];

        // [1, 3, 1, 5, 1]
        for (int i = 0; i < GREL.length; i++) {

            int left = i - (GREL[i] + 1);
            int right = GRER[i] == - 1? arr.length - 1 - i : GRER[i] - 1 - i;
            count[i] = left + right + 1;
        }
    }

    private static Integer[] findGreaterElementToRight(Integer[] arr) {
        Integer[] GRE = new Integer[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            if(stack.isEmpty()) {
                GRE[i] = -1;
            } else if(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                GRE[i] = stack.peek();
            } else if(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    GRE[i] = -1;
                } else {
                    GRE[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        return GRE;
    }

    private static Integer[] findGreaterElementToLeft(Integer[] arr) {
        Integer[] GRE = new Integer[arr.length];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            if(stack.isEmpty()) {
                GRE[i] = -1;
            } else if(!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                GRE[i] = stack.peek();
            } else if(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    GRE[i] = -1;
                } else {
                    GRE[i] = stack.peek();
                }
            }
            stack.push(i);
        }

        return GRE;
    }
}
