package com.mani.soni.tree;

public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.right = new TreeNode(60);
        diameter(root);
        System.out.println(res);
    }

    private static int res = Integer.MIN_VALUE;

    private static int diameter(TreeNode<Integer> node) {

        if(node == null) {
            return 0;
        }

        int left = diameter(node.left);
        int right = diameter(node.right);

        res = Math.max(left + right + 1, res);

        return 1 + Math.max(left, right);
    }
}
