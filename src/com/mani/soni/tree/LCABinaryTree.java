package com.mani.soni.tree;

import java.util.ArrayList;
import java.util.List;

public class LCABinaryTree {

    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode<>(20);
        root.right = new TreeNode<>(30);
        root.right.left = new TreeNode<>(40);
        root.right.left.left = new TreeNode<>(60);
        root.right.right = new TreeNode<>(50);
        root.right.right.left = new TreeNode<>(50);
        root.right.right.right = new TreeNode<>(80);

        System.out.println(lca(root, 30, 80).value);
        System.out.println(lcaPath(root, 30, 80).value);
    }

    /**
     * lca using path arrays.
     * Time Complexity: Theta(n) + Theta(n) + O(n)
     *
     * @param root
     */
    private static TreeNode<Integer> lcaPath(TreeNode<Integer> root, int value1, int value2) {
        List<TreeNode<Integer>> pathArrayValue1 = new ArrayList<>();
        List<TreeNode<Integer>> pathArrayValue2 = new ArrayList<>();

        if(!findPathArray(root, value1, pathArrayValue1) || !findPathArray(root, value2, pathArrayValue2)){
            return null;
        }
        TreeNode<Integer> common = null;
        for (int i = 0; i < pathArrayValue1.size() && i < pathArrayValue2.size(); i++) {
            if(pathArrayValue1.get(i).value == pathArrayValue2.get(i).value) {
                common =  pathArrayValue1.get(i);
            }
        }

        return common;
    }

    /**
     * TC: Theta(n)
     * @param node
     * @param value
     * @param pathArray
     * @return
     */
    private static boolean findPathArray(TreeNode<Integer> node, int value, List<TreeNode<Integer>> pathArray) {

        if(node == null) {
            return false;
        }
        pathArray.add(node);

        if(node.value == value) {
            return true;
        }

        if(findPathArray(node.left, value, pathArray) || findPathArray(node.right, value, pathArray)) {
            return true;
        }

        pathArray.remove(pathArray.size() - 1);

        return false;
    }

    /**
     * Another implementation
     * TC: Theta(n)
     * SC: Theta(logn) :- height of the tree, in case of skewed its O(n)
     * @param root
     * @param value1
     * @param value2
     * @return
     */
    private static TreeNode<Integer> lca(TreeNode<Integer> root, int value1, int value2) {

        if(root == null) {
            return null;
        }

        // Return if any of the key found
        if(root.value == value1 || root.value == value2) {
             return root;
        }

        TreeNode<Integer> leftSide = lca(root.left, value1, value2);
        TreeNode<Integer> rightSide = lca(root.right, value1, value2);

        if(leftSide != null && rightSide != null) {
            System.out.println("LCA "+ root.value);
            return root;
        }

        if(leftSide != null) {
            return leftSide;
        } else {
            return rightSide;
        }
    }
}
