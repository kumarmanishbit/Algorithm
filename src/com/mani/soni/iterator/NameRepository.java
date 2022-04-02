package com.mani.soni.iterator;

import java.util.Iterator;

public class NameRepository {

    public static void main(String[] args) {
        Iterator iterator = new NameIterator(new String[]{"Manish", "Ramesh", "Shiv", "Vinod", "Dave", "Eva"});

        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
