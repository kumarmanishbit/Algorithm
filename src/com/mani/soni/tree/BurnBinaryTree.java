package com.mani.soni.tree;

/**
 *  Similar to finding diameter of the tree.
 *  https://practice.geeksforgeeks.org/tracks/DSASP-Tree/?batchId=154&tab=1
 */
public class BurnBinaryTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(20);
        root.right = new TreeNode<>(30);
        root.left.left = new TreeNode<>(40);
        root.left.right = new TreeNode<>(50);
        root.right.right = new TreeNode<>(60);
        burnTree(root, new Distance(-1), 50);
        System.out.println(res);
    }

    private static int res = Integer.MIN_VALUE;

    private static int burnTree(TreeNode<Integer> root, Distance dist, int leaf) {

        if(root == null) {
            return 0;
        }

        if(root.value == leaf) {
            dist.value = 0;
            return 1;
        }
        Distance leftDistance = new Distance(-1);
        Distance rightDistance = new Distance(-1);

        int leftHeight = burnTree(root.left, leftDistance, leaf);
        int rightHeight = burnTree(root.right, rightDistance, leaf);

        if(leftDistance.value != -1) {
            dist.value = leftDistance.value + 1;
            res = Math.max(res, 1 + leftHeight);
        } else if(rightDistance.value != -1) {
            dist.value = rightDistance.value + 1;
            res = Math.max(res, 1 + rightHeight);
        }
        return 1 + Math.max(leftHeight, rightHeight);
    }

    static class Distance {
        int value;
        Distance(int value) {
            this.value = value;

        }
    }
}
