package com.mani.soni.stack;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-string-balanced/
 *
 * You are given a 0-indexed string s of even length n. The string consists of exactly n / 2 opening brackets '[' and n / 2 closing brackets ']'.
 *
 * A string is called balanced if and only if:
 *
 * It is the empty string, or
 * It can be written as AB, where both A and B are balanced strings, or
 * It can be written as [C], where C is a balanced string.
 * You may swap the brackets at any two indices any number of times.
 *
 * Return the minimum number of swaps to make s balanced.
 */
public class MinSwapToMakeStringBalanced {
    public static void main(String[] args) {

    }

    public int minSwaps(String string) {

        // Stack is optional as we have only one type of chracter in the string.
        // Stack<Character> stack = new Stack<>();
        int open = 0;
        for(int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            if(ch == '[') {
                open++;
            } else if(ch == ']') {
                // If there are no element with [ present till now.
                if(open > 0) {
                    open--;
                }
            }
        }
        return (open + 1) / 2;
    }
}
