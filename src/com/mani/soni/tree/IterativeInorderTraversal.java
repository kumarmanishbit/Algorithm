package com.mani.soni.tree;

import java.util.Stack;

public class IterativeInorderTraversal {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(20);
        root.right = new TreeNode<>(30);
        root.left.left = new TreeNode<>(40);
        root.left.right = new TreeNode<>(50);
        root.right.left = new TreeNode<>(60);

        inOrder(root);
    }

    /**
     * We need some kind of data structure which can give access to last visited element easily.
     * and for this purpose we can use stack.
     * @param root
     */
    private static void inOrder(TreeNode<Integer> root) {
        Stack<Integer> stack = new Stack<>();


    }
}
