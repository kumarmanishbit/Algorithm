package com.mani.soni.tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreeTraversalSpiral {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(1);
        root.left = new TreeNode<>(2);
        root.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(4);
        root.left.right = new TreeNode<>(5);
        root.right.left = new TreeNode<>(6);
        root.right.right = new TreeNode<>(7);
        root.left.left.left = new TreeNode<>(8);
        root.left.left.right = new TreeNode<>(9);

        spiralTraversal(root);
    }

    private static void spiralTraversal(TreeNode<Integer> root) {
        Deque<TreeNode<Integer>> queue = new ArrayDeque<>();

        TreeNode<Integer> dummy = new TreeNode<>(-1);
        queue.add(root);
        queue.add(dummy);
        boolean evenLevel = false;

        while(!queue.isEmpty()) {
            TreeNode<Integer> element = null;
            if(evenLevel) {
                queue.addFirst(dummy);
                while (queue.peekLast().value != -1) {
                    element = queue.pollLast();
                    System.out.println(element.value);
                    if(element.right != null) {
                        queue.addFirst(element.right);
                    }
                    if(element.left != null) {
                        queue.addFirst(element.left);
                    }
                }
                queue.pollLast();
            } else {
                queue.addLast(dummy);
                while (queue.peekFirst().value != -1) {
                    element = queue.pollFirst();
                    System.out.println(element.value);
                    if (element.left != null) {
                        queue.add(element.left);
                    }
                    if (element.right != null) {
                        queue.add(element.right);
                    }
                }
                queue.pollFirst();
            }
            if(queue.size() == 1 && queue.peek().value == -1) {
                break;
            }
            evenLevel = !evenLevel;
        }
    }
}
