package com.mani.soni.dynamicprogramming;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/jump-game-ii/
 */
public class MinimumJumpsToReachEnd {

    private static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {
//        int[] arr = {3, 4, 2, 1, 2, 1};

//        int[] arr = {4, 1, 5, 3, 1, 3, 2, 1, 8};

//        int[] arr = {0};
//        int[] arr = {2, 1};

        int[] arr ={2,3,1,1,4};

//        int[] arr = {7,0,9,6,9,6,1,7,9,0,1,2,9,0,3};

        System.out.println(jumpGreedy(arr));
        System.out.println(jumpGreedy2(arr));
        System.out.println(countMinJumps(arr));

//        makeJumps(arr, 0, 0);

        if(min != Integer.MAX_VALUE) {
            System.out.println(min);
        } else {
            System.out.println(0);
        }
    }

    /**
     * The main idea is based on greedy. Let's say the range of the current jump is [curBegin, curEnd],
     * curFarthest is the farthest point that all points in [curBegin, curEnd] can reach.
     * Once the current point reaches curEnd, then trigger another jump, and set the new curEnd with curFarthest,
     * then keep the above steps, as the following:
     * @param nums
     * @return
     */
    private static int jumpGreedy2(int[] nums) {

        int currEnd = 0;
        int end = 0;
        int minJump = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            end = Math.max(nums[i] +  i, end);

            if(i == currEnd) {
                currEnd = end;
                minJump++;
            }
        }
        return minJump;
    }

    /**
     * Greedy implementation
     * @param nums
     * @return
     */
    public static int jumpGreedy(int[] nums) {

        int minJump = 0;

        int energyBooster = 0;

        int maxIndex = 0;

        // [2, 1]
        for (int i = 0; i < nums.length; i++) {
            // we get an booster or we spend it.
            // we will get high energy booster

            if(i == 0) {
                energyBooster = nums[i];
                maxIndex = i + 1;
                continue;
            }

            energyBooster--;

            if(energyBooster == 0) {

                if(nums[maxIndex] + maxIndex > i + nums[i]) {
                    energyBooster = nums[maxIndex] + maxIndex - i;
                } else {
                    energyBooster = nums[i];
                    maxIndex = i + 1;
                }

                minJump++;
                continue;
            } else if(i == nums.length - 1) {
                minJump++;
                break;
            }

            if(nums[maxIndex] + maxIndex <= i + nums[i]) {
                maxIndex = i;
            }

        }

        return minJump;
    }

    /**
     * DP implementation
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {


        int dp[] = new int[nums.length];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // dp[end] = Math.min(dp[end], dp[start]+1);
        // This is like LIC problem. We start looking backward.
        for(int i=0 ; i < nums.length; ++i) {
            for(int j = 0; j < i; j++) {

                if(nums[j] + j >= i) {
                    dp[i] = Math.min(dp[i] , dp[j] + 1);

                }

            }
        }

        return dp[nums.length - 1];
    }

    /**
     * Recursive implementation
     * @param arr
     * @param index
     * @param step
     */
    private static void makeJumps(int[] arr, int index, int step) {

        if(arr.length  - 1 == index + 1) {
            min = Math.min(min, step);
        }
        for (int i = index + 1; i < index  + arr[index]; i++) {
            if(arr[i] != 0) {
                makeJumps(arr, i, step + 1);
            }
        }
    }

    /**
     * Recursive solution
     *
     * TC: O(2n)
     * SC: O(n)
     *
     * @param jumps
     * @return
     */
    public static int countMinJumps(int[] jumps) {
        return countMinJumpsRecursive(jumps, 0);
    }

    private static int countMinJumpsRecursive(int[] jumps, int currentIndex) {
        // if we have reached the last index, we don't need any more jumps
        if( currentIndex == jumps.length - 1)
            return 0;

        if (jumps[currentIndex] == 0)
            return Integer.MAX_VALUE;

        int totalJumps = Integer.MAX_VALUE;
        int start = currentIndex + 1;
        int end = currentIndex + jumps[currentIndex];
        while(start < jumps.length && start <= end) {
            // jump one step and recurse for the remaining array
            int minJumps = countMinJumpsRecursive(jumps, start++);
            if(minJumps != Integer.MAX_VALUE)
                totalJumps = Math.min(totalJumps, minJumps + 1);
        }
        return totalJumps;
    }
}
