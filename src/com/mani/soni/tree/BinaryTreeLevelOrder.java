package com.mani.soni.tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeLevelOrder {
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

        printLevelOrder(root);
    }

    /**
     * Improved version of level order traversal which does not require marker.
     * @param node
     */
    private static void printLevelOrder(TreeNode<Integer> node) {
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                TreeNode<Integer> element = queue.poll();
                System.out.print(element.value+" ");
                if(element.left != null) {
                    queue.add(element.left);
                }
                if(element.right != null) {
                    queue.add(element.right);
                }
            }
            System.out.println();
        }
    }

    /**
     * print level order traversal using marker.
     * @param root
     */
    public static void printLevelUsingMarker(TreeNode<Integer> root){
        if(root==null)return;
        Queue<TreeNode<Integer>> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while(q.size() > 1){
            TreeNode<Integer> curr=q.poll();
            if(curr==null){
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(curr.value+" ");
            if(curr.left!=null)
                q.add(curr.left);
            if(curr.right!=null)
                q.add(curr.right);
        }
    }
}
