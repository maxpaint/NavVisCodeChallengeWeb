package com.maxpaint.tree;

public abstract class Tree implements Comparable<Tree> {

    protected final Integer frequency; // the frequency of this tree

    public Tree(Integer freq) {
        this.frequency = freq;
    }

    public int compareTo(Tree tree) {
        return frequency - tree.frequency;
    }


}
