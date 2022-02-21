package com.mani.soni;

import com.mani.soni.disjoint.UnionFind;

import java.util.Arrays;

public class Test {

    static int[][] memo = new int[7][7];

    public static void main(String[] args) {

        for (int i = 0, len = memo.length; i < len; i++)
            Arrays.fill(memo[i], -1);

        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        System.out.println(lcs(s1, s2, 0, 0 ));
    }

    private static int lcs(String s1, String s2, int i, int j) {

        if(i > s1.length() - 1 || j > s2.length() - 1) {
            return 0;
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = lcs(s1, s2, i + 1, j + 1) + 1;
            return memo[i][j];
        }

        memo[i][j] =  Math.max(lcs(s1, s2, i + 1, j), lcs(s1, s2, i, j + 1));

        return memo[i][j];
    }

}
