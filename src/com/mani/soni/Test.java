package com.mani.soni;

import java.util.*;

public class Test {

    static int[][] memo = new int[7][7];

    public static void main(String[] args) {

        int[] arr = {3, 4, 1, 6, 2};

        int[] count = new int[arr.length];

        Queue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < arr.length; i++) {
            if(!pq.isEmpty() && pq.peek() < arr[i]) {
                count[i] += pq.size();
            }
            count[i] += 1;
            pq.add(arr[i]);
        }
        pq.clear();
        for (int i = arr.length - 1; i >= 0; i--) {
            if(!pq.isEmpty() && pq.peek() < arr[i]) {
                count[i] += pq.size();
            }
            pq.add(arr[i]);
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
        }
//        System.out.println(rotationalCipher("Zebra-493", 3));
    }

    private static String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder string = new StringBuilder();

        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);

            if(ch >= 'A' && ch <= 'Z') {
                //ch - 'A'
                string.append(Character.toString(('A' + (ch - 'A' + rotationFactor) % 26)));
            } else if(ch >= 'a' && ch <= 'z') {
                string.append(Character.toString(('a' + (ch - 'a' + rotationFactor) % 26)));
            } else if(Character.isDigit(ch)) {
                string.append((Integer.parseInt(String.valueOf(ch)) + rotationFactor) % 10);
            } else {
                string.append(ch);
            }
        }

        return string.toString();
    }

    private static void swap(int[] arr , int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void merge() {


        int[] size = {1, 3};
        int position[] = {2, 6};
        int start = 1;
        int end = 5;

//        int[] size = {2, 1};
//        int position[] = {5, 1};
//        int start = 2;
//        int end = 6;

        List<Range> rangeList = new ArrayList<>();

        for (int i = 0; i < position.length; i++) {
             rangeList.add(new Range(position[i] - size[i], position[i] + size[i]));
        }

        mergeRanges(rangeList);

        for(Range range : rangeList) {
            if(range.getLeftEnd() <= start && range.getRightEnd() >= end) {
                System.out.println("true");
                break;
            }
        }
    }

    public static List<Range> mergeRanges(List<Range> sortedCraneRanges) {

        Collections.sort(sortedCraneRanges, Comparator.comparingInt(Range::getLeftEnd));

        List<Range> mergedRanges = new ArrayList<>();
        mergedRanges.add(sortedCraneRanges.get(0));
        for (Range currentRange : sortedCraneRanges) {
            Range lastRange = mergedRanges.get(mergedRanges.size() - 1);

            if (currentRange.getLeftEnd() <= lastRange.getRightEnd()) {
                lastRange.setRightEnd(Math.max(lastRange.getRightEnd(), currentRange.getRightEnd()));
            } else {
                mergedRanges.add(currentRange);
            }
        }
        return mergedRanges;
    }

    static class Range {
        private int leftEnd;
        private int rightEnd;
        public Range(int startTime, int endTime) {
            this.leftEnd = startTime;
            this.rightEnd = endTime;
        }
        public int getLeftEnd() {
            return leftEnd;
        }
        public void setLeftEnd(int leftEnd) {
            this.leftEnd = leftEnd;
        }
        public int getRightEnd() {
            return rightEnd;
        }
        public void setRightEnd(int rightEnd) {
            this.rightEnd = rightEnd;
        }
    }
}
