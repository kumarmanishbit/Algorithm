package com.mani.soni.stack;

import java.util.Stack;

public class StringBalanced {
    public static void main(String[] args) {
        String str = ")";
        System.out.println(isBalanced(str));
        System.out.println(isBalancedWithOneTypeOfCharacter("))))"));
    }

    private static boolean isBalancedWithOneTypeOfCharacter(String expression) {
        int balanced = 0;

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch == '(') {
                balanced++;
            } else if (ch == ')') {
                balanced--;
            }
            // Early fail, if we found more closing bracket than opening one.
            if(balanced < 0) {
                return false;
            }
        }
       return balanced == 0;
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
