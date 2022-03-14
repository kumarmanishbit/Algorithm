package com.mani.soni.tree;

public class TreeNode<T> {
    TreeNode<T> left;
    TreeNode<T> right;
    T value;

    TreeNode(T value) {
       this.value = value;
    }
}
