package com.mani.soni.design;

public interface AbstractDataStructure<K, V> {
    public void put(Integer k, Integer v);
    public Integer get(Integer k);
    void delete(Integer k);
    Integer last();
}
