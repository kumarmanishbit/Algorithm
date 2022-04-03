package com.mani.soni.stack;

/**
 * https://leetcode.com/problems/minimum-add-to-make-parentheses-valid/submissions/
 */
public class MinimumAddToMakeStringValid {
    public static void main(String[] args) {
        System.out.println(minAddToMakeValid("()))"));
    }

    public static int minAddToMakeValid(String expression) {
        int balanced = 0;
        int count = 0;
        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '(') {
                balanced++;
            } else if(ch == ')') {
                balanced--;
            }
            if(balanced < 0) {
                count++;
                balanced++;
            }
        }
        return count + balanced;
    }
}
