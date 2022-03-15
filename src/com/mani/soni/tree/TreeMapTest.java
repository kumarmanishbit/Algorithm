package com.mani.soni.tree;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        // Tree Map are implemented using Red-Black Tree in Java
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        treeMap.put(1, "A");
        treeMap.put(12, Character.toString('A' + 11));
        treeMap.put(13, Character.toString('A' + 12));
        treeMap.put(3, Character.toString('A' + 2));

        System.out.println(treeMap.get(3));
        for (Map.Entry<Integer, String> entry :  treeMap.entrySet()) {
            System.out.println(entry.getKey()+" = "+entry.getValue());
        }
    }
}
