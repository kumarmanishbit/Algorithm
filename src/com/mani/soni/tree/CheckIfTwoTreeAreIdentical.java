package com.mani.soni.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckIfTwoTreeAreIdentical {

    public static void main(String[] args) {
        List<Integer> firstList = Arrays.asList(3,5,4,6,1,0,2);
        List<Integer> secondList = Arrays.asList(3,1,5,2,4,6,0);

        System.out.println(checkIfTwoBSTAreSame(firstList, secondList));
    }

    // TC: O(N^2)
    // SC: O(n) :- For recursion stack
    private static boolean checkIfTwoBSTAreSame(List<Integer> firstList, List<Integer> secondList) {

        if(firstList.size() != secondList.size()) {
            return false;
        }

        // (firstList.isEmpty() && secondList.isEmpty())
        if(firstList.isEmpty()) {
            return true;
        }

        if(firstList.size() == 1) {
            return firstList.get(0) == secondList.get(0);
        }

        List<Integer> firstListLeft = new ArrayList<>();
        List<Integer> secondListLeft = new ArrayList<>();
        List<Integer> firstListRight = new ArrayList<>();
        List<Integer> secondListRight = new ArrayList<>();


        int rootElement = firstList.get(0);

        for (int i = 1; i < firstList.size(); i++) {
             if(rootElement > firstList.get(i)) {
                 firstListLeft.add(firstList.get(i));
             } else {
                 firstListRight.add(firstList.get(i));
             }

             if(rootElement > secondList.get(i)) {
                 secondListLeft.add(secondList.get(i));
             } else {
                 secondListRight.add(secondList.get(i));
             }
        }

        return checkIfTwoBSTAreSame(firstListLeft, secondListLeft) && checkIfTwoBSTAreSame(firstListRight, secondListRight);
    }
}
