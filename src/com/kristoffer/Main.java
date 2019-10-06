package com.kristoffer;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        String filename = args[0];
        String start = args[1];
        String stop = args[2];
        ArrayList<Field> fields = readFile(filename);

        Graph g = new Graph(fields, start);
        System.out.println(g.shortestPathToString(start, stop));
    }

    public static ArrayList<Field> readFile(String filename) {
        int maxLines = Graph.MAX_VERTICES-1;
        ArrayList<Field> fields = new ArrayList<>(maxLines);
        File file = new File(filename);
        try (Scanner scanner = new Scanner(file)) {
            String[] line = new String[maxLines];
            while (scanner.hasNext()) {
                line = scanner.nextLine().split(",");
                String from = line[0];
                String to = line[1];
                int time = Integer.parseInt(line[2]);
                fields.add(new Field(from, to, time));
            }
        } catch (FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        }
        return fields;
    }
}
