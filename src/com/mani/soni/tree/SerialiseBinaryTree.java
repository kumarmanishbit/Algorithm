package com.mani.soni.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.List;

public class SerialiseBinaryTree {

    private static int EMPTY = -1;
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        List<Integer> seraliseTree = new ArrayList<>();
        serialiseTree(root, seraliseTree);

//        for (Integer i: seraliseTree) {
//            System.out.println(i);
//        }
        TreeNode<Integer> node = deSerialiseTree(seraliseTree);
        System.out.println(node.value);
        System.out.println(node.left.value);
        System.out.println(node.right.value);

    }

    /**
     *         10
     *       /   \
     *      20    30
     * @param node
     * @return
     */
    private static void serialiseTree(TreeNode<Integer> node, List<Integer> seralisedTree) {
        if(node == null) {
            seralisedTree.add(-1);
            return;
        }
        seralisedTree.add(node.value);
        // NLR
        serialiseTree(node.left, seralisedTree);
        serialiseTree(node.right, seralisedTree);
    }

    private static int index = 0;

    /**
     * Pre order traversal is NLR
     *
     * @param seralisedTree
     * @return
     */
    private static TreeNode<Integer> deSerialiseTree(List<Integer> seralisedTree) {

        if(index > seralisedTree.size()) {
           return null;
        }
        int value = seralisedTree.get(index++);
        if(value == -1) {
           return null;
        }

        TreeNode<Integer> node = new TreeNode<>(value);

        node.left = deSerialiseTree(seralisedTree);
        node.right = deSerialiseTree(seralisedTree);
        return node;
    }
}
