package com.mani.soni.dynamicprogramming;

public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String str = "abdbca";

        System.out.println(findLongestPalindromic(str, 0));
    }

    private static int findLongestPalindromic(String str, int index) {

        int res = 0;

        int low = index, high = index;

        while(low >= 0 && high < str.length()) {
            if(str.charAt(low) != str.charAt(high)) {
                break;
            }
        }

        res = findLongestPalindromic(str, index + 1);

        return res;
    }
}
