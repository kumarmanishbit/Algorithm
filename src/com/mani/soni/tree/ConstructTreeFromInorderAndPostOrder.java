package com.mani.soni.tree;

public class ConstructTreeFromInorderAndPostOrder {
    private static Integer index = 0;

    public static void main(String[] args) {

        /**
         *                 1
         *              /    \
         *    [4, 8, 2, 5]   [6, 3, 7]
         */
        // LNR
        Integer[] inOrder = {4, 8, 2, 5, 1, 6, 3, 7};
        // LRN
        // root always appears at the end of postorder traversal.
        Integer[] postOrder = {8, 4, 5, 2, 6, 7, 3, 1};
        index = postOrder.length - 1;
        TreeNode<Integer> root = constructTree(inOrder, postOrder, 0, inOrder.length - 1);
        System.out.println(root.value);
        System.out.println(root.left.value);
        System.out.println(root.left.left.value);
        System.out.println(root.left.right.value);
        System.out.println(root.right.value);
        System.out.println(root.right.left.value);
    }

    /**
     * TC: O(n)
     * SC: O(n) ---> Recursion stack
     * @param inOrder
     * @param postOrder
     * @param start
     * @param end
     * @return
     */
    private static TreeNode<Integer> constructTree(Integer[] inOrder, Integer[] postOrder, int start, int end) {
        if(start > end || index < 0) {
            return null;
        }

        Integer nodeValue = postOrder[index--];

        TreeNode<Integer> node = new TreeNode<>(nodeValue);

        // Return if there is no left or right child
        if(start == end) {
          return node;
        }

        // O(n) :- In worst case when tree is skewed.
        // This can be done in O(1) using hashmap.
        // We can store the inOrder element in hashmap and can quickly search for the element
        int i = start;
        for (; i <= end; i++) {
            if(nodeValue == inOrder[i]) {
                break;
            }
        }
        // recursively build left and right subtree
        // One important observation is, we recursively call for the right subtree before the left
        // subtree as we decrease the index of the postorder index whenever we create a new node.
        node.right = constructTree(inOrder, postOrder, i + 1, end);
        node.left = constructTree(inOrder, postOrder, start, i - 1);
        return node;
    }
}
