package com.mani.soni.recursion;

import java.util.HashSet;
import java.util.Set;

public class MinimuNumberOfMerge {

    public static void main(String[] args) {
        String target = "123456789";

        Set<String> set= new HashSet<>();
        set.add("1");
        set.add("12");
        set.add("123");
        set.add("1234");
        set.add("5678");
        set.add("2345678");
        set.add("9");

//        System.out.println(findMin(set, target, 0));
        System.out.println((1 << 5) ^ 41);
    }

    public static int findMin(Set<String> set, String target, int index) {

        if(target == null || target == "") {
            return 0;
        }
        String chunk = "";

        int minResult = Integer.MAX_VALUE - 100;

        for (int i = 0; i < target.length(); i++) {
            chunk += target.charAt(i);
            if(set.contains(chunk)) {
                minResult = Math.min(minResult, 1 + findMin(set, target.substring(i + 1), i + 1));
            }
        }

        return minResult;
    }
}
