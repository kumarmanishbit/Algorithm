package com.mani.soni.stack;

import java.util.Stack;

public class StringBalanced {
    public static void main(String[] args) {
        String str = ")";
        System.out.println(isBalanced(str));
    }

    private static boolean isBalanced(String str) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
                continue;
            }

            if(stack.isEmpty()) {
                return false;
            }

            if(ch == '}' && stack.peek() != '{') {
                return false;
            } else if(ch == ')' && stack.peek() != '(') {
                return false;
            } else if(ch == ']' && stack.peek() != '[') {
                return false;
            }

            stack.pop();
        }

        return true;
    }

}
