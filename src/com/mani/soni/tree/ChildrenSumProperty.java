package com.mani.soni.tree;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(20);
        root.left = new TreeNode<>(8);
        root.right = new TreeNode<>(12);
        root.left.left = new TreeNode<>(3);
        root.left.right = new TreeNode<>(5);

        System.out.println(findChildrenSumProperty(root));
    }

    /**
     * TC: O(n)
     * SC: O(height of the tree)
     * @param root
     * @return
     */
    private static boolean findChildrenSumProperty(TreeNode<Integer> root) {

        if(root == null) {
            return true;
        }

        if(root.left == null && root.right == null) {
            return true;
        }

        int leftValue = 0;

        if(root.left != null) {
            leftValue = root.left.value;
        }

        int rightValue = 0;

        if(root.right != null) {
            rightValue = root.right.value;
        }

        return leftValue + rightValue == root.value && findChildrenSumProperty(root.left) && findChildrenSumProperty(root.right);
    }
}
