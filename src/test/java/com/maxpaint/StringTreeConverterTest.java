package com.maxpaint;

import com.maxpaint.tree.Tree;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.File;
import java.io.IOException;
import java.util.PriorityQueue;

import static junit.framework.TestCase.assertEquals;

@RunWith(JUnit4.class)
public class StringTreeConverterTest {


    @Test
    public void testDisplayedTree() throws IOException {
        File file = new File(this.getClass().getResource("/test2.txt").getFile());
        StringTreeConverter treeConverter = new StringTreeConverter(file);
        PriorityQueue<Tree> sortedTrees = treeConverter.getSortedTrees();
        assertEquals(sortedTrees.size(), 5);
        Tree tree = sortedTrees.poll();
        assertEquals(tree.getFrequency(), 1);
        assertEquals(tree.getValue(), "She");
        tree = sortedTrees.poll();
        assertEquals(tree.getFrequency(), 1);
        assertEquals(tree.getValue(), "problems");
        tree = sortedTrees.poll();
        assertEquals(tree.getFrequency(), 1);
        assertEquals(tree.getValue(), "to");
        tree = sortedTrees.poll();
        assertEquals(tree.getFrequency(), 2);
        assertEquals(tree.getValue(), "had");
        tree = sortedTrees.poll();
        assertEquals(tree.getFrequency(), 2);
        assertEquals(tree.getValue(), "address");

    }
}
