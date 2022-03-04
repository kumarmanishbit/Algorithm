package com.mani.soni.queue;

import java.util.ArrayDeque;
import java.util.Deque;

public class FirstCircularTour {
    public static void main(String[] args) {
        int[] petrol = {4, 8, 7, 4};
        int[] dist = {6, 5, 3, 5};

//        int[] petrol = {8, 9, 4};
//        int[] dist = {5, 10, 12};
//        System.out.println(canTour(petrol, dist));
        System.out.println(canTourDeQueueApproach(petrol, dist));
    }

    public static boolean canTour(int[] petrol, int[] dist) {
        for (int i = 0; i < petrol.length; i++) {

            int point = i;
            int p = petrol[point] - dist[point];
            while(true) {
                point = ++point % petrol.length;

                p += petrol[point] - dist[point];
                // if we exhaust the petrol then we will break.
                if(p < 0) {
                    break;
                }

                if(point == i) {
                    return true;
                }
            }
        }

        return false;
    }

    public static int canTourDeQueueApproach(int[] petrol, int[] dist) {
        Deque<Integer> deque = new ArrayDeque<>();

        int currentPetrol = 0;

        for (int i = 0; i < petrol.length; i++) {
            currentPetrol += petrol[i] - dist[i];
            if(currentPetrol > 0) {
                deque.add(i);
            } else {
              while(!deque.isEmpty() && currentPetrol < 0) {
                  int front = deque.poll();
                  currentPetrol -= petrol[front] - dist[front];
              }
            }
        }

        return deque.isEmpty()? -1 : deque.peek();
    }
}
