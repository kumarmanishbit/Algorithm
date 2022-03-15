package com.mani.soni.tree;

import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        // TreeSet is implemented using Red-Black Tree in Java
        TreeSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(1);
        treeSet.add(20);
        treeSet.add(13);
        treeSet.add(19);
        treeSet.add(6);

        System.out.println(treeSet.ceiling(7));
        System.out.println(treeSet.floor(7));
        System.out.println(treeSet.higher(4));
        System.out.println(treeSet.lower(4));
        // first gives the lowest value.
        System.out.println(treeSet.first());
        // last gives the highest value.
        System.out.println(treeSet.last());
    }
}
