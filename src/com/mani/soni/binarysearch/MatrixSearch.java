package com.mani.soni.binarysearch;

import java.util.Arrays;

public class MatrixSearch {

	// TC:Theta(n^2) SC:O(1)
	public static boolean matrixSearch1(int[][] in, int x) {
		for (int[] tmp : in) {
			for (int e : tmp) {
				if (e == x)
					return true;
			}
		}
		return false;
	}

	// TC:Theta(n log n) SC:O(1)
	public static boolean matrixSearch2(int[][] in, int x) {
		for (int i = 0; i < in.length; ++i) {
			if (Arrays.binarySearch(in[i], x) >= 0)
				return true;
		}
		return false;
	}

	// TC:Theta(log n) SC:O(1)
	public static boolean matrixSearch4(int[][] in, int x) {
		int l = 0, r = in.length * in.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			int tmp = in[m/in.length][m%in.length];
			if (tmp == x)
				return true;
			if (x < tmp)
				r = m - 1;
			else
				l = m + 1;
		}
		return false;

	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);

		int k = 1;
		int[][] in = new int[n][n];
		for (int i = 0; i < n; ++i) {
			for (int j = 0; j < n; ++j) {
				in[i][j] = k++;
			}
		}
//		Utils.display(in);
		int x = n;
//		System.out.println(x);
//		System.out.println(matrixSearch2(in, x));
//		
		// solution2: 0.032
		// solution1: 1.009
		//solution4: 0 sec
		x = 0;
//		System.out.println(x);
		long start = System.currentTimeMillis();
		System.out.println(matrixSearch4(in, x));
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end - start) / 1000.0 + "secs");

	}

}
