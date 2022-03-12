package com.mani.soni.tree;

public class ConstructTreeFromInorderAndPreOrder {
    private static Integer index = 0;

    public static void main(String[] args) {

        String[] inOrder = {"D", "B", "E", "A", "F", "C"};
        String[] preOrder = {"A", "B", "D", "E", "C", "F"};


        TreeNode<String> root = constructTree(inOrder, preOrder, 0, inOrder.length - 1);
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
     * @param preOrder
     * @param start
     * @param end
     * @return
     */
    private static TreeNode<String> constructTree(String[] inOrder, String[] preOrder, int start, int end) {
        if(start > end) {
            return null;
        }

        String nodeValue = preOrder[index++];

        TreeNode<String> node = new TreeNode<>(nodeValue);

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
        node.left = constructTree(inOrder, preOrder, start, i - 1);
        node.right = constructTree(inOrder, preOrder, i + 1, end);
        return node;
    }
}
