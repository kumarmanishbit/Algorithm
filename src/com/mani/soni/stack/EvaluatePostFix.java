package com.mani.soni.stack;

import java.util.Stack;

public class EvaluatePostFix {
    public static void main(String[] args) {
        String[] str = {"10", "2", "*", "3", "+"};

        // Stack for operator
        Stack<Integer> stack = new Stack<>();

        for (String s: str) {
            // push operand to the stack
            if(isNumeric(s)) {
                stack.push(Integer.parseInt(s));
                continue;
            }
            // if its operator then pop the operand and then compute the result.
            switch (s) {
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
            }
        }

        System.out.println(stack.pop());
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
