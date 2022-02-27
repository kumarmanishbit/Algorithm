package com.mani.soni.dynamicprogramming;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String str = "abdbca";

        System.out.println(findMinimumCut(str, 0, str.length() - 1));
    }

    /**
     * TC: O(2n)
     * SC: O(n)
     *
     * @param str
     * @param i
     * @param j
     * @return
     */
    private static int findMinimumCut(String str, int i, int j) {

        if(i >= j) {
            return 0;
        }

        // we don't need to cut the string if it is a palindrome
        if(isPalindrome(str, i, j)) {
            return 0;
        }

        // at max, we need to cut the string into its 'length-1' pieces
        int res = j - i;

        for (int k = i; k <= j; k++) {
            // If one side is palindrome then only cut make sense
            // eg:- we can't cut string like "abd" & "bcd"
            if(isPalindrome(str, i, k)) {
                // we can cut here as we have a palindrome from 'startIndex' to 'k'
                res = Math.min(res, 1 + findMinimumCut(str, k + 1, j));
            }
        }

        return res;
    }

    private static boolean isPalindrome(String str, int i, int j) {
        while(i < j) {
            if(str.charAt(i++) != str.charAt(j--)) {
                return false;
            }
        }
        return true;
    }

    private static int findMinimumCutTopDown(String str, int i, int j) {

        return 0;
    }
}
