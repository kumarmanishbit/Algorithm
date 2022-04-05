package com.mani.soni.stack;

import java.util.*;

public class MaxChunkToSorted {
    public static void main(String[] args) {
//        System.out.println(maxChunksToSorted(new int[]{0,4,5,2,1,3}));
        System.out.println(maxChunksToSorted1(new int[]{1,1,0,0,1}));
    }

    public static int maxChunksToSorted(int[] arr) {
        int count = 0;

        int i = 0;

        while (i < arr.length) {
            int element = arr[i];

            if(element != i) {
                i = Math.max(element + 1, ++i);
            } else {
                i++;
                count++;
            }
        }
        return count;
    }

    /**
     * This is for the array like this: [2,1,3,4,4]
     * Input: arr = [2,1,3,4,4]
     * Output: 4
     * Explanation:
     * We can split into two chunks, such as [2, 1], [3, 4, 4].
     * However, splitting into [2, 1], [3], [4], [4] is the highest number of chunks possible.
     * @param arr
     * @return
     */
    public static int maxChunksToSorted1(int[] arr) {
        int count = 0;

        int[] arr1 = Arrays.copyOf(arr, arr.length);

        Arrays.sort(arr1);
        Integer[] sortedArray = Arrays.stream(arr1).boxed().toArray(Integer[]::new);


        Map<Integer, List<Integer>> map = new HashMap<>();

        for(int i = 0; i < sortedArray.length; i++) {
            List<Integer> list = map.getOrDefault(sortedArray[i], new ArrayList<>());
            list.add(i);
            map.put(sortedArray[i], list);
        }

        int max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++) {
            int element = arr[i];

            List<Integer> indices = map.get(element);

            Integer index = indices.get(0);
            max = Math.max(max, index);

            indices.remove(index);
            map.put(element, indices);

            if(max == i) {
                count++;
            }
        }


        return count;

    }

    /**
     * TC: O(n)
     * SC: O(n)
     * @param arr
     * @return
     */
    public static int maxChunksToSorted3(int[] arr) {

        int count = 0;

        int[] sortedArray = Arrays.copyOf(arr, arr.length);

        Arrays.sort(sortedArray);

        int sum1= 0 ;
        int sum2 = 0;

        for(int i = 0; i < sortedArray.length; i++) {
            sum1 += sortedArray[i];
            sum2 += arr[i];

            // if we get equal sum at any point then we are found a partition.
            if(sum1 == sum2) {
                count++;
            }
        }
        return count;
    }
}
