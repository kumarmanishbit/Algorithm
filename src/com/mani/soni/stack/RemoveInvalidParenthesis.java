package com.mani.soni.stack;

import java.util.*;
import java.util.stream.Collectors;

public class RemoveInvalidParenthesis {

    static List<String> finalValid = new ArrayList<>();

    public static void main(String[] args) {
        String expression = "(a)())()";

        StringBuilder stringBuilder = new StringBuilder(expression);
        findValidString(stringBuilder);

        finalValid = finalValid.stream().distinct().collect(Collectors.toList());
        for(String str : finalValid) {
            System.out.println(str);
        }
    }

    private static boolean isValid(StringBuilder stringBuilder) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < stringBuilder.length(); i++) {
            char ch = stringBuilder.charAt(i);
            if(ch == '(') {
                stack.push(ch);
                continue;
            }

            if(stack.isEmpty()){
                return false;
            }

            if(ch == ')') {
                if(stack.peek() != '(') {
                    return false;
                }
                stack.pop();
            }
        }
        return true;
    }

    public static void findValidString(StringBuilder builder) {

        if(isValid(builder)) {
            finalValid.add(builder.toString());
            return;
        }
        Queue<StringBuilder> exp = new LinkedList<>();
        boolean found =  false;
        for(int i = 0; i < builder.length(); i++) {
            char ch = builder.charAt(i);
            if(Character.isAlphabetic(ch)) {
                 continue;
            }
            StringBuilder temp = builder.deleteCharAt(i);
            if(isValid(temp)) {
                finalValid.add(builder.toString());
                found = true;
            } else {
                exp.add(temp);
            }
            temp.insert(i, ch);
        }

        if(!found) {
            while(!exp.isEmpty()) {
                findValidString(exp.poll());
            }
        }
    }
}
