package com.maxpaint;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        if (args.length != 1) {
            throw new RuntimeException("Could U insert path for txt file?");
        }

        String filePath = args[0];

        StringTreeConverter treeConverter = new StringTreeConverter(filePath);
        treeConverter.print();
    }


}
