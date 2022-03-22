package com.mani.soni.queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueRemoval {

    public static void main(String[] args) {
        int n = 6;
        int[] arr = {1, 2, 2, 3, 4, 5};
        int x = 5;
        Queue<Element> queue = new LinkedList<>();

        for (int i = 0; i < arr.length; i++) {
            queue.add(new Element(arr[i], i + 1));
        }

        int result[] = new int[x];


        for (int i = 0; i < x; i++) {
            int j = x;
            int qSize = queue.size();
            int max = Integer.MIN_VALUE;

            Element maxEle = null;
            while(j > 0 && qSize > 0) {
                Element ele = queue.poll();
                if(max < ele.value) {
                    max = ele.value;
                    maxEle = ele;
                }
                j--;
                qSize--;
//                ele.value = ele.value == 0? 0 : ele.value - 1;
                queue.add(ele);
            }
            result[i] = maxEle.index;
            queue.remove(maxEle);
            qSize = queue.size();
            while(qSize > 0) {
                Element ele = queue.poll();
                ele.value = ele.value == 0? 0 : ele.value - 1;
                queue.add(ele);
                qSize--;
            }
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    static class Element {
        int value;
        int index;

        Element(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }
}
