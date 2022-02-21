package com.mani.soni.binarysearch;

import java.util.Random;

public class LowestIndex {

	//TC:Theta(log n)    SC:O(1)
	public static int lowestIndex(int[] in, int x) {
		int l = 0, r = in.length - 1;
		while (l < r) {
			int m = (l + r) / 2;
			if (in[m] == x)
				r = m;
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
		System.out.println(lowestIndex(in, x));

	}

}
