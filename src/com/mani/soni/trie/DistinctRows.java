package com.mani.soni.trie;

import java.util.HashMap;
import java.util.Map;

/***
 * Count Distinct Rows in a Binary Matrix
 * TC: O(m * n)
 * SC: O(m * n)
 */
public class DistinctRows {

    public static void main(String[] args) {
        int[][] matrix = {{1,0,0}, {1,1,1}, {1,0,0}, {1,1,1}};

        findDuplicate(matrix);
    }

    private static void findDuplicate(int[][] matrix) {
        // Get the empty node of the trie.
        Node root = new Node();

        int count = 0;

        for (int row=0; row< matrix.length ;row++) {
            if(add(root, matrix[row])) {
                count++;
            }
        }

        System.out.println(count);
    }

    private static boolean add(Node node, int[] matrix) {

        Node curr = node;
        boolean isFound = true;

        for (int i = 0; i < matrix.length; i++) {
            if(!curr.child.containsKey(matrix[i])) {
                curr.child.put(matrix[i], new Node());
                isFound = false;
            }
            curr = curr.child.get(matrix[i]);
        }

        if(isFound) {
            curr.isEnd = true;
        }

        return isFound;
    }

    static class Node {
        Map<Integer, Node> child;
        // isEnd is not required here, as size of all the element is same.
        boolean isEnd;

        Node() {
            this.child = new HashMap<>();
            this.isEnd = false;
        }
    }
}
