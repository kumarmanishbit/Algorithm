package com.mani.soni.recursion;

public class RopeCuttingProblem {

    public static void main(String[] args) {
        int n = 9, a = 2, b = 2, c = 2;

        System.out.println(findCut(n, a, b, c));
    }

    private static int findCut(int n, int a, int b, int c) {

        if(n == 0) {
            return 0;
        }

        int resA = Integer.MIN_VALUE, resB = Integer.MIN_VALUE, resC = Integer.MIN_VALUE;

        if(n - a >= 0) {
            resA =  1 + findCut(n - a, a, b, c);
        }
        if(n - b >= 0) {
            resB =  1 + findCut(n - b, a, b, c);
        }
        if(n - c >= 0) {
            resC = 1 + findCut(n - c, a, b, c);
        }

        return Math.max(resA , Math.max(resB, resC));
    }
}
