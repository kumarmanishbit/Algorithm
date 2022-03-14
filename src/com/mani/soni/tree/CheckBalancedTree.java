package com.mani.soni.tree;

public class CheckBalancedTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(18);
        root.left = new TreeNode<>(4);
        root.right = new TreeNode<>(20);
        root.right.left = new TreeNode<>(13);
        root.right.right = new TreeNode<>(70);
//        root.right.right.right = new TreeNode<>(80);

        System.out.println(checkIfHeightBalanced(root));
        System.out.println(heightBalanced(root) != -1);
    }

    /**
     * TC: O(n^2)
     * @param root
     * @return
     */
    private static boolean checkIfHeightBalanced(TreeNode<Integer> root) {
        if(root == null) {
            return true;
        }

        int left = height(root.left);
        int right = height(root.right);

        if(Math.abs(left - right) > 1) {
            return false;
        }

        return checkIfHeightBalanced(root.left) && checkIfHeightBalanced(root.right);
    }

    /**
     * TC: O(n)
     * height function takes O(n) time
     * @param root
     * @return
     */
    private static int height(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static int heightBalanced(TreeNode<Integer> root) {
        if(root == null) {
            return 0;
        }
        int left = height(root.left);

        if(left == -1) {
           return -1;
        }
        int right = height(root.right);
        if(right == -1) {
           return -1;
        }

        if(Math.abs(left - right) > 1) {
            return -1;
        }

        return 1 + Math.max(left, right);
    }
}
