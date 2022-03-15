package com.mani.soni.tree;

public class KthSmallestInBST {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(50);
        root.left = new TreeNode<>(20);
        root.left.left = new TreeNode<>(10);
        root.left.right = new TreeNode<>(40);
        root.right = new TreeNode<>(100);
        root.right.right = new TreeNode<>(120);
        root.right.left = new TreeNode<>(70);
        root.right.left.left = new TreeNode<>(60);
        root.right.left.right = new TreeNode<>(80);
        int k = 3;

        findKthElement(root, k);
    }

    private static Integer count = 0;

    /**
     *
     * TC: O(height + k) :- height because you are going down, and k if for another k element scan.
     *
     * @param root
     * @param k
     */
    private static void findKthElement(TreeNode<Integer> root, int k) {
        if(root == null) {
            return;
        }

        findKthElement(root.left, k);
        // If you came here, it means you are processing this current node.
        count++;
        if(k == count) {
            System.out.println(root.value);
            return;
        }

        findKthElement(root.right, k);
    }
}
