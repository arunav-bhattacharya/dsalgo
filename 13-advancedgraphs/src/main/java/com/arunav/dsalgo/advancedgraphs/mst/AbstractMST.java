package com.arunav.dsalgo.advancedgraphs.mst;

import com.arunav.dsalgo.advancedgraphs.representation.undirected.Edge;
import com.arunav.dsalgo.advancedgraphs.representation.undirected.EdgeWeightedGraph;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractMST {

    protected List<Edge> mst;
    protected double weight;
    protected EdgeWeightedGraph graph;

    protected AbstractMST(EdgeWeightedGraph graph) {
        mst = new ArrayList<>();
        weight = 0;
        this.graph = graph;
    }

    public abstract List<Edge> getMst();

    public abstract double getWeight();
}
