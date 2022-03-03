package com.mani.soni;

import java.util.*;

public class Test {

    static int[][] memo = new int[7][7];

    public static void main(String[] args) {

       // System.out.println(solution(new int[]{180, -50, -25, -25}, new String[]{"2020-01-01", "2020-01-01", "2020-01-01", "2020-01-31"}));
        merge();
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
