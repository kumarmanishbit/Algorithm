package com.mani.soni.binarysearch;

import java.util.Arrays;
import java.util.Random;

public class Utils {
	
	public static int[] sortedArray(int n) {
		int[] in = new int[n];
		for(int i = 0; i < n; ++i)
			in[i] = i+1;
		return in;
	}
	
	public static int[] sortedRandomArray(int n) {
		int[] in = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(2*n) + 1;
		Arrays.sort(in);
		return in;		
	}
	
	public static int[] sortedRandomArrayWithDuplicates(int n) {
		int[] in = new int[n];
		Random r = new Random();
		for(int i = 0; i < n; ++i)
			in[i] = r.nextInt(5) + 1;
		Arrays.sort(in);
		return in;		
	}
	
	public static void display(int[] in) {
		System.out.println(Arrays.toString(in));
	}
	
	public static void display(int[][] in) {
		for(int i = 0; i < in.length; ++i)
			System.out.println(Arrays.toString(in[i]));
		System.out.println();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
