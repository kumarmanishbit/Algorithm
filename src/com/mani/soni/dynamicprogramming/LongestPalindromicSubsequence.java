package com.mani.soni.dynamicprogramming;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String str = "abdbca";

        System.out.println(findLongestPalindromic(str, 0, str.length() - 1));
    }

    /**
     * Recursive solution
     * TC: O(2n)
     * SC: O(n)
     * @param str
     * @param start
     * @param end
     * @return
     */
    private static int findLongestPalindromic(String str, int start, int end) {

        if(start > end) {
            return 0;
        }

        // every sequence with one element is a palindrome of length 1
        if(start == end) {
            return 1;
        }

        // case 1: elements at the beginning and the end are the same
        if(str.charAt(start) == str.charAt(end)) {
             return  2 + findLongestPalindromic(str, start + 1, end - 1);
        }

        // case 2: skip one element either from the beginning or the end
        return Math.max(findLongestPalindromic(str, start, end - 1), findLongestPalindromic(str, start + 1, end));
    }
}
