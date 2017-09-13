package com.maxpaint;

import com.maxpaint.tree.Tree;
import com.maxpaint.tree.TreeLeaf;
import com.maxpaint.tree.TreeNode;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

import static java.nio.file.Files.readAllLines;
import static java.util.Arrays.stream;

public class StringTreeConverter {

    private Tree tree;
    private PriorityQueue<Tree> sortedTrees = new PriorityQueue<>();

    public StringTreeConverter(String filePath) throws IOException {
        this.tree = buildTree(getStringCounts(filePath));
    }

    private Map<String, Integer> getStringCounts(String filePath) throws IOException {
        List<String> lines = readAllLines(new File(filePath).toPath());
        Map<String, Integer> counts = new HashMap<>();
        lines.stream()
                .flatMap(line -> stream(line.split(" ")))
                .forEach(s -> counts.merge(s, 1, Integer::sum));

        return counts;
    }

    private Tree buildTree(Map<String, Integer> counts) {
        PriorityQueue<Tree> trees = new PriorityQueue<>();
        counts.forEach((s, integer) -> trees.offer(new TreeLeaf(integer, s)));

        assert trees.size() > 0;
        sortedTrees = new PriorityQueue<>(trees);

        while (trees.size() > 1) {
            Tree a = trees.poll();
            Tree b = trees.poll();
            trees.offer(new TreeNode(a, b));
        }
        return trees.poll();
    }

    public void print() {
        System.out.println(" value -> frequency");
        while (sortedTrees.size() > 1) {
            System.out.println(sortedTrees.poll());
        }
    }

    public Tree getTree() {
        return tree;
    }
}
