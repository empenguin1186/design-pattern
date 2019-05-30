package jp.co.penguin.designpattern.singleton.practice;

import java.util.Arrays;
import java.util.List;

public class Triple {

    private static List<Triple> triples = Arrays.asList(new Triple(0), new Triple(1), new Triple(2));

    private int id;

    private Triple(int id) {
        this.id = id;
        System.out.println("Created Triple Instance.");
    }

    public static Triple getInstance(int id) {
        return triples.get(id);
    }

    @Override
    public String toString() {
        return "Triple id = " + id + ".";
    }
}
