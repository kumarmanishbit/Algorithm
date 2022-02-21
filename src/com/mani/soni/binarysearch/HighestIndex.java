package com.mani.soni.binarysearch;

import java.util.Random;

public class HighestIndex {

	//TC:Theta(log n)    SC:O(1)
	public static int highestIndex(int[] in, int x) {
		int l = 0, r = in.length - 1;
		while (l < r) {
			int m = (int) Math.ceil( (l + r) / 2.0);
			if (in[m] == x)
				l = m;
			else if (x < in[m])
				r = m - 1;
			else
				l = m + 1;
		}
		if(in[l] == x) return l;
		return -1;
	}

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		int[] in = Utils.sortedRandomArrayWithDuplicates(n);
		Utils.display(in);
		int x = new Random().nextInt(5) + 1;
		System.out.println(x);
		System.out.println(highestIndex(in, x));

	}

}
