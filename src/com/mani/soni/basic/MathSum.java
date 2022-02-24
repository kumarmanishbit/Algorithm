package com.mani.soni.basic;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Locale;

public class MathSum {

    public static final NumberFormat FORMAT = NumberFormat.getInstance(Locale.US);

    public static long sumParallel(int[] array) {
        final long start = System.nanoTime();
        int sum = Arrays.stream(array).parallel().reduce(0,(a, b)->  a + b);
        final long end = System.nanoTime();
        System.out.println(sum);
        return  end - start;
    }

    public static long sumStream(int[] array) {
        final long start = System.nanoTime();
        int sum = Arrays.stream(array).reduce(0,(a,b)->  a + b);
        final long end = System.nanoTime();
        System.out.println(sum);
        return  end - start;
    }

    public static long sumLoop(int[] array) {
        final long start = System.nanoTime();
        int sum = 0;
        for (int v: array) {
            sum += v;
        }
        final long end = System.nanoTime();
        System.out.println(sum);
        return  end - start;
    }

    public static long sumArray(int[] array) {
        final long start = System.nanoTime();
        int sum = Arrays.stream(array) .sum();
        final long end = System.nanoTime();
        System.out.println(sum);
        return  end - start;
    }

    public static long sumStat(int[] array) {
        final long start = System.nanoTime();
        int sum = 0;
        final long end = System.nanoTime();
        System.out.println(sum);
        return  end - start;
    }


    public static void test(int[] nums) {
        System.out.println("------");
        System.out.println(FORMAT.format(nums.length) + " numbers");
        long p = sumParallel(nums);
        System.out.println("parallel " + FORMAT.format(p));
        long s = sumStream(nums);
        System.out.println("stream " +  FORMAT.format(s));
        long ar = sumArray(nums);
        System.out.println("arrays " +  FORMAT.format(ar));
        long lp = sumLoop(nums);
        System.out.println("loop " +  FORMAT.format(lp));

    }

    public static void testNumbers(int howmany) {
        int[] nums = new int[howmany];
        for (int i =0; i < nums.length;i++) {
            nums[i] = (i + 1)%100;
        }
        test(nums);
    }

    public static void main(String[] args) {
        testNumbers(3);
        testNumbers(300);
        testNumbers(3000);
        testNumbers(30000);
        testNumbers(300000);
        testNumbers(3000000);
        testNumbers(30000000);
        testNumbers(300000000);
    }
}