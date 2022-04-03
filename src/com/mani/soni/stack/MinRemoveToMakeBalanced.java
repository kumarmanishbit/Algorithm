package com.mani.soni.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://leetcode.com/problems/minimum-remove-to-make-valid-parentheses/
 *
 * To make the string valid with minimum removals, we need to get rid of all parentheses that do not have a matching pair.
 *
 * Push char index into the stack when we see '('.
 *
 * Pop from the stack when we see ')'.
 *
 * If the stack is empty, then we have ')' without the pair, and it needs to be removed.
 * In the end, the stack will contain indexes of '(' without the pair, if any. We need to remove all of them too.
 *
 */
public class MinRemoveToMakeBalanced {
    public static void main(String[] args) {
        System.out.println(minRemoveToMakeValid("lee(t(c)o)de)"));
    }

    public static String minRemoveToMakeValid(String string) {
        // lee(t(c)o)de)
        Stack<Integer> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder(string);

        for(int i = 0; i < stringBuilder.length(); i = i + 1) {
            char ch = string.charAt(i);

            if(ch == '(') {
                stack.push(i);
            } else if(ch == ')') {
                if(!stack.isEmpty() && stringBuilder.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stringBuilder.setCharAt(i, '#');
                }
            }
        }

        while(!stack.isEmpty()) {
            stringBuilder.setCharAt(stack.pop(), '#');
        }

        return stringBuilder.toString().replaceAll("\\#", "");
    }
}
