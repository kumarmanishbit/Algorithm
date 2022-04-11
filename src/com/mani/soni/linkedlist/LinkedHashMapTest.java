package com.mani.soni.linkedlist;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LinkedHashMapTest {
    public static void main(String[] args) {
//        LinkedHashMap<Character, Integer> linkedHashMap = new LinkedHashMap<>();
//
//        // {'a': 1}
//        linkedHashMap.put('a', 1);
//        // {'b': 2},,, // {'a': 1} --> {'b': 2}
//        linkedHashMap.put('b', 2);
//        // {'a': 2},,, // {'a': 2} --> {'b': 2}
//        linkedHashMap.put('a', 2);
//        // {'c': 2},,, // {'a': 2} --> {'b': 2} --> {'c' : 2}
//        linkedHashMap.put('c', 2);
//        System.out.println(linkedHashMap.get('a'));
//        System.out.println(linkedHashMap.entrySet().iterator().next());
//        System.out.println(linkedHashMap.size());

        LRUCache lruCache = new LRUCache(4);
        lruCache.put('a', 1);
        lruCache.put('b', 1);
        lruCache.put('c', 1);
        lruCache.put('a', 2);
        lruCache.put('d', 1);
        lruCache.put('e', 1);
        Map.Entry<Character, Integer> first = lruCache.entrySet().iterator().next();
        System.out.println("first one "+ first);
        lruCache.print();
    }
}

class LRUCache extends LinkedHashMap<Character, Integer> implements LRUCacheInterface {

    private int maxEntries;

    LRUCache(int size) {
        this.maxEntries = size;
    }

    public void print() {
        for(Map.Entry<Character, Integer> set: super.entrySet()) {
            System.out.println(set);
        }
    }

    @Override
    public Integer put(Character key, Integer value) {
        return super.put(key, value);
    }

    @Override
    public Integer get(Object key) {
        return super.get((Character) key);
    }

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > this.maxEntries;
    }
}


