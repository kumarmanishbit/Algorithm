package com.mani.soni.educative;

import java.util.HashSet;
import java.util.Set;

/**
 * find if a subarray with a sum equal to 0 exist.
 *
 * TC: O(n) Linear time complexity.
 */
public class ZeroSum {
    public static void main(String[] args) {
        int[] arr = {6, 4, -7, 3, 12, 9};
        System.out.println(findSubZero(arr));
    }

    public static boolean findSubZero(int[] arr) {

        Set<Integer> set = new HashSet<Integer>();
        int sum = 0;

        for(int i= 0; i < arr.length; i++) {
            sum += arr[i];
            if(!set.add(sum)) {
                return true;
            }
        }

        return sum == 0 ? true: false;
    }
}
