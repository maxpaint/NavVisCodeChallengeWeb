package com.maxpaint.tree;

public class TreeLeaf extends Tree {

    public final String value;

    public TreeLeaf(Integer freq, String val) {
        super(freq);
        this.value = val;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer(" ");
        sb.append(value).append(" -> ").append(frequency);
        return sb.toString();
    }
}
