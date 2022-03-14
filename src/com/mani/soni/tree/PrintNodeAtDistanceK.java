package com.mani.soni.tree;

public class PrintNodeAtDistanceK {
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

        int k = 3;
        printAtK(root, 0, k);
    }

    /**
     * Method to print node at distance k from the root.
     * @param node
     * @param level
     * @param k
     */
    private static void printAtK(TreeNode<Integer> node, int level, int k) {
        if(node == null) {
            return;
        }
        if(level == k) {
            System.out.print(node.value +" ");
            return;
        }

        printAtK(node.left, level + 1, k);
        printAtK(node.right, level + 1, k);
    }
}
