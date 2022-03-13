package com.mani.soni.tree;

/**
 * Format:-
 * 1) Base Condition
 * 2) Hypothesis
 * 3) Induction
 *
 */
public class MaxPathAnyNodeSum {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.right.right = new TreeNode(60);
        maxPathSum(root);
        System.out.println(res);
    }
    private static int res = Integer.MIN_VALUE;

    private static int maxPathSum(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }

        int leftResult = maxPathSum(root.left);
        int rightResult = maxPathSum(root.right);

        // temp result where this node can't answer
        int temp = Math.max(Math.max(leftResult, rightResult) + root.value, root.value);
        // result is max of result found till now and this node being a result.
        res = Math.max(res, Math.max(leftResult + rightResult + root.value, temp));

        return temp;
    }
}
