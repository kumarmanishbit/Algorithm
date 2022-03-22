package com.mani.soni.array;

import java.awt.geom.PathIterator;
import java.util.*;

public class UniquePairSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 3};
//        int[] arr = {1, 5, 3, 3, 3};
        int k = 6;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int count = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();

            if(key * 2 == k) {
                if(map.get(key) > 1) {
                    count = count + map.get(key) *2 ;
                }
            } else {
                if(map.containsKey(k - key)) {
                        count += 1;
                }
            }
        }
        System.out.println(count / 2);
    }

    static class Pair {
        int first;
        int second;
        int posFirst;
        int posSecond;

        Pair(int first, int second, int posFirst, int posSecond) {
            this.first = first;
            this.second = second;
            this.posFirst = posFirst;
            this.posSecond = posSecond;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return (posFirst == pair.posFirst || posFirst == pair.posSecond) && (posSecond == pair.posFirst || posSecond == pair.posSecond);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second) ^ Objects.hash(second, first);
        }
    }
}
