package com.mani.soni.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * TC: O(n) time and SC: O(1) space.
 */
public class LinkedListCycleDetection {
    public static void main(String[] args) {
        LinkedListNode head = new LinkedListNode(1);
        head.next = new LinkedListNode(2);
        head.next.next = new LinkedListNode(3);
        head.next.next.next = new LinkedListNode(4);
        head.next.next.next = head.next;

        System.out.println(containsCycle(head));
        System.out.println(findNode(head).value);
    }

    public static LinkedListNode findNode(LinkedListNode firstNode) {

        LinkedListNode current = firstNode;

        Set<Integer> set = new HashSet<>();

        int res = 1;
        // until we hit the end of the list
        while (current != null) {
            res = res ^ current.hashCode();
            if(!set.add(res)) {
                return current;
            }
            current = current.next;
        }

        return null;
    }

    public static boolean containsCycle(LinkedListNode firstNode) {

        // start both runners at the beginning
        LinkedListNode slowRunner = firstNode;
        LinkedListNode fastRunner = firstNode;

        // until we hit the end of the list
        while (fastRunner != null && fastRunner.next != null) {
            slowRunner = slowRunner.next;
            fastRunner = fastRunner.next.next;

            // case: fastRunner is about to "lap" slowRunner
            if (fastRunner == slowRunner) {
                return true;
            }
        }

        // case: fastRunner hit the end of the list
        return false;
    }
}

class LinkedListNode {

    public int value;
    public LinkedListNode next;

    public LinkedListNode(int value) {
        this.value = value;
    }
}

