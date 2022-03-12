package com.mani.soni.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfTwoTreeAreIdenticalSolution2 {

    public static void main(String[] args) {
        int[] firstArray = {3,5,4,6,1,0,2};
        int[] secondArray = {3,1,5,2,4,6,0};

        System.out.println(checkIfTwoBSTAreSame(firstArray, secondArray, 0, 0 , Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    // TC: O(N^2)
    // SC: O(n) :- For recursion stack
    private static boolean checkIfTwoBSTAreSame(int[] firstArray, int[] secondArray, int index1, int index2, int min, int max) {

        if(firstArray.length != secondArray.length) {
            return false;
        }

        int i, j;

        for (i = index1; i < firstArray.length; i++) {
            if(firstArray[i] > min && firstArray[i] < max) {
                break;
            }
        }

        for (j = index2; j < secondArray.length; j++) {
            if(secondArray[j] > min && secondArray[j] < max) {
                break;
            }
        }

        if(i == firstArray.length && j == secondArray.length) {
            return true;
        }

        // if we could not find element in one array.
        if(i == firstArray.length || j == secondArray.length) {
            return false;
        }

        if(firstArray[i] != secondArray[j]) {
            return false;
        }

        return checkIfTwoBSTAreSame(firstArray, secondArray, i + 1, j + 1 , min, firstArray[i]) &&
                checkIfTwoBSTAreSame(firstArray, secondArray, i + 1, j + 1 , firstArray[i], max);
    }
}
