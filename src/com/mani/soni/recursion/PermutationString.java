package com.mani.soni.recursion;

public class PermutationString {

    public static void main(String[] args) {
        String str = "ABCD";

        findPermutation(str, 0);
    }

    private static void findPermutation(String str, int index) {

        if(index == str.length() - 1) {
            System.out.println(str);
            return;
        }

        for (int i = index; i < str.length(); i++) {
            findPermutation(swap(str, i, index), index + 1);
        }
    }

    private static String swap(String str, int i, int index) {
        char[] charArray = str.toCharArray();
        char tmp = charArray[i];
        charArray[i] = charArray[index];
        charArray[index] = tmp;
        return String.valueOf(charArray);
    }
}
