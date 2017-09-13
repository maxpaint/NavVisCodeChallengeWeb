package com.maxpaint.tree;

public abstract class Tree implements Comparable<Tree> {

    protected final int frequency; // the frequency of this tree

    public Tree(int freq) {
        this.frequency = freq;
    }

    public int compareTo(Tree tree) {
        return frequency - tree.frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public abstract String getValue();
}
