package com.arunav.dsalgo.graphsv2.app;

import com.arunav.dsalgo.graphsv2.problems.AllBridges;

import java.util.ArrayList;
import java.util.List;

public class GraphProblemsApp {

    public static void main(String[] args) {
        testAllBridges();
    }

    private static void testAllBridges() {
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> edge;
        edge = new ArrayList<>();
        edge.add(0);
        edge.add(1);
        edges.add(edge);

        edge = new ArrayList<>();
        edge.add(1);
        edge.add(2);
        edges.add(edge);

        edge = new ArrayList<>();
        edge.add(2);
        edge.add(0);
        edges.add(edge);

        edge = new ArrayList<>();
        edge.add(1);
        edge.add(3);
        edges.add(edge);

        AllBridges allBridges = new AllBridges();
        List<List<Integer>> bridges = allBridges.findBridges(edges, 4);
        System.out.println(bridges.toString());
    }
}
