package com.mani.soni.tree;

public class BinaryTreeHeight {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.right = new TreeNode(60);
        root.right.right.right = new TreeNode(70);

        System.out.println(height(root));
    }

    private static int height(TreeNode<Integer> root) {
        // Base Case
        if(root == null) {
            return 0;
        }

        // Hypothesis: height(root.left), height(root.right)
        // Induction
        return 1 + Math.max(height(root.left), height(root.right));
    }
}
