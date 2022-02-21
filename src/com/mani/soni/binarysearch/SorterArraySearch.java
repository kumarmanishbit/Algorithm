package com.mani.soni.binarysearch;

import java.util.Random;

public class SorterArraySearch {

	// TC:Theta(n) SC:O(1)
	public static boolean linearSearch(int[] in, int x) {
		for (int e : in) {
			if (e == x)
				return true;
		}
		return false;
	}

	// TC:Theta(log n) SC:O(1)
	public static boolean binarySearch(int[] in, int x) {
		int l = 0, r = in.length - 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (in[m] == x)
				return true;
			if (x < in[m])
				r = m - 1;
			else
				l = m + 1;
		}
		return false;
	}

	// TC:Theta(log 3 n) SC:O(1)
	public static boolean ternarySearch(int[] in, int x) {
		int l = 0, r = in.length - 1;
		while (l <= r) {
			int size = (r-l+1) / 3;
			int m1 = l + size;
			int m2 = r - size;
			if (in[m1] == x || in[m2] == x)
				return true;
			if (x < in[m1])
				r = m1 - 1;
			else if(x > in[m2])
				l = m2 + 1;
			else {
				l = m1 + 1;
				r = m2 -1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = Utils.sortedArray(n);
//		Utils.display(in);

//		int x = new Random().nextInt(n) + 1;
//		System.out.println(x);
//		System.out.println(binarySearch(in, x));
//
//		x = 0;
//		System.out.println(x);
//		System.out.println(binarySearch(in, x));
//		
//		x = new Random().nextInt(n) + 1;
//		System.out.println(x);
//		System.out.println(ternarySearch(in, x));
//
//		x = 0;
//		System.out.println(x);
//		System.out.println(ternarySearch(in, x));
		
		//worst case performance
		//binary search:10 million: 0 sec   100 million:0 sec   1 billion:0 sec
		//ternary search:10 million: 0 sec   100 million:0 sec   1 billion:0 sec
		int x = 0;
		long start = System.currentTimeMillis();
		System.out.println(ternarySearch(in, x));
		long end = System.currentTimeMillis();
		System.out.println("Time taken:" + (end-start)/1000.0 + "secs");

	}

}
