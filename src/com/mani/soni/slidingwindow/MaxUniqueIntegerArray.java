package com.mani.soni.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class MaxUniqueIntegerArray {
    public static void main(String[] args) {
      //  System.out.println(totalFruit(new int[] {3,3,3,1,2,1,1,2,3,3,4}));
        System.out.println(longestSubstring("aaabb", 3));
    }

    public static int longestSubstring(String s, int k) {

        int i = 0;
        int j = 0;

        char[] charArray = s.toCharArray();

        int[] freq = new int[26];

        int max = Integer.MIN_VALUE;

        while(j < charArray.length) {
            freq[charArray[j] - 'a']++;

            if(!isValid(freq, k)) {
                j++;
            } else {
                max = Math.max(max, j - i + 1);
                j++;
            }
        }

        return max;
    }

    private static boolean isValid(int[] freq, int k) {
        for(int i = 0 ; i < 26; i++) {
            if(freq[i] < k && freq[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public static int totalFruit(int[] fruits) {

        int i = 0;
        int j = 0;
        int k = 2;

        Map<Integer, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;

        while(j < fruits.length) {
            map.put(fruits[j], map.getOrDefault(fruits[j], 0) + 1);
            if(map.size() < 2) {
                j++;
            } else if(map.size() == 2) {
                max = Math.max(max, j - i + 1);
                j++;
            } else if (map.size() > 2) {
                while(map.size() > 2) {
                    if(map.get(fruits[i]) == 1) {
                        map.remove(fruits[i]);
                    } else {
                        map.put(fruits[i], map.get(fruits[i]) - 1);
                    }
                    i++;
                }
                System.out.println("Map size "+ map.size());
                //     max = Math.max(max, j - i + 1);
                j++;
            }
        }

        return max;
    }
}
