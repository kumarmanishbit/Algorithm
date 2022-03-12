package com.mani.soni.tree;

public class TreeNode<T> {
    TreeNode left;
    TreeNode right;
    T value;

    TreeNode(T value) {
       this.value = value;
    }
}
