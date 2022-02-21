package com.mani.soni.binarysearch;

public class BinarySearchBug {

	public static int binarySearch(int[] in, int x) {
		int l = 0, r = in.length - 1;
		while (l <= r) {
			//int m = (l + r) / 2;
			//fix1
			//int m = l + (r-l)/2;
			//fix2
			int m  = (l+r) >>> 1;
			if (in[m] == x)
				return m;
			if (x < in[m])
				r = m - 1;
			else
				l = m + 1;
		}
		return -1;

	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i+1;
		int x = n;
		//System.out.println(Integer.MAX_VALUE);
		System.out.println(binarySearch(in, x));
	}

}
