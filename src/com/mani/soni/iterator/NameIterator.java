package com.mani.soni.iterator;

import java.util.Iterator;

public class NameIterator implements Iterator {

    private String[] names;
    private int index;

    public NameIterator(String[] names) {
        this.names = names;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index == names.length) {
            return false;
        }
        return true;
    }

    @Override
    public Object next() {
        return names[this.index++];
    }
}
