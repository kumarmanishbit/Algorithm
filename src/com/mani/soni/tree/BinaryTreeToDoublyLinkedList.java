package com.mani.soni.tree;

public class BinaryTreeToDoublyLinkedList {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(5);
        root.right = new TreeNode<>(20);
        root.right.left = new TreeNode<>(30);
        root.right.right = new TreeNode<>(35);
        TreeNode<Integer> head = convertToDoublyLL(root);

        TreeNode<Integer> curr = head;

        while(curr != null) {
            System.out.println(curr.value);
            curr = curr.right;
        }
    }

    private static TreeNode<Integer> prev = null;

    private static TreeNode<Integer>  convertToDoublyLL(TreeNode<Integer> root) {

        if(root == null) {
           return null;
        }
        TreeNode<Integer> head  = convertToDoublyLL(root.left);

        if(prev == null) {
           head = root;
        } else {
            root.left = prev;
            prev.right = root;
        }
        prev = root;
        convertToDoublyLL(root.right);

        return head;
    }
}
