package com.mani.soni.disjoint;

public class UnionFind {

    Integer[] parent;
    Integer[] rank;

    public UnionFind(int size) {
        parent = new Integer[size];
        rank = new Integer[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    public void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if(xParent == yParent) {
            return;
        }

        if(rank[yParent] > rank[xParent]) {
            parent[xParent] = yParent;
        } else if(rank[yParent] < rank[xParent]){
            parent[yParent] = xParent;
        } else {
            parent[yParent] = xParent;
            rank[yParent]++;
        }
    }

    public int findWithPathCompression(int x) {
        // parent point to itself.
        if(x == parent[x]) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    // simple find
    public int find(int x) {
        // parent point to itself.
        if(x == parent[x]) {
            return x;
        }
        return find(parent[x]);
    }

    public void print() {
        for (int i = 0; i < parent.length; i++) {
            System.out.print(parent[i] +" ");
        }
    }

}
