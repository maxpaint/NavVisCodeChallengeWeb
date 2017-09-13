package com.maxpaint.tree;

public class TreeNode extends Tree {

    public final Tree left, right; // subtrees

    public TreeNode(Tree l, Tree r) {
        super(l.frequency + r.frequency);
        left = l;
        right = r;
    }

    @Override
    public String getValue() {
        return null;
    }
}
