package com.mani.soni.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStringWithKUniqueCharacter {

    public static void main(String[] args) {
        int[] arr = {6, 5, 1, 2, 3, 2, 1, 4, 5};

        int k = 3;

        Map<Integer, Integer> frequency = new HashMap<>();

        int j = 0;
        int i = 0;

        int maxUnique = Integer.MIN_VALUE;

        while (j < arr.length) {

            int freq = frequency.getOrDefault(arr[j], 0);
            frequency.put(arr[j], freq + 1);

            if(frequency.size() < k) {
                maxUnique = Math.max(maxUnique, j - i + 1);
                j++;
            }else if(frequency.size() == k) {
                maxUnique = Math.max(maxUnique, j - i + 1);
                j++;
            } else if(frequency.size() > k) {
                while(frequency.size() > k) {
                    int lastFrequency = frequency.get(arr[i]);
                    if(lastFrequency == 0) {
                        frequency.remove(arr[i]);
                    } else {
                        frequency.put(arr[i], lastFrequency - 1);
                    }
                }
                i++;
            }
        }
        System.out.println(maxUnique);
    }
}

class Meeting implements Comparable<Meeting> {

    @Override
    public int compareTo(Meeting o) {
        return 0;
    }
}