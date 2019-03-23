package ru.pavel.algorithms;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GraphTest {
    Graph graph;
    DepthFirstPaths depthFirstPaths;
    BreadthFirstPaths breadthFirstPaths;

    @Before
    public void GraphTest() {
        graph = new Graph(10);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 7);
        graph.addEdge(3, 7);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 8);
        graph.addEdge(6, 9);
        depthFirstPaths = new DepthFirstPaths(graph, 0);
        breadthFirstPaths = new BreadthFirstPaths(graph, 4);
    }

    @Test
    public void vertexCountTest() {
        Assert.assertEquals(10, graph.vertexCount());
    }

    @Test
    public void edgeCountTest() {
        Assert.assertEquals(9, graph.edgeCount());
    }

    @Test
    public void adjListTest() {
        Assert.assertEquals("[0, 2, 3, 7]", graph.adjList(1).toString());
    }

    @Test
    public void hasPathToDepthFirstPathsTest() {
        Assert.assertTrue(depthFirstPaths.hasPathTo(7));
        Assert.assertFalse(depthFirstPaths.hasPathTo(9));
    }

    @Test
    public void pathToDepthFirstPathsTest() {
        Assert.assertEquals("[1, 3]", depthFirstPaths.pathTo(3).toString());
    }

    @Test
    public void hasPathToBreadthFirstPathsTest() {
        Assert.assertTrue(breadthFirstPaths.hasPathTo(9));
        Assert.assertFalse(breadthFirstPaths.hasPathTo(7));
    }

    @Test
    public void pathToBreadthFirstPathsTest() {
        Assert.assertEquals("[5, 6, 8]", breadthFirstPaths.pathTo(8).toString());
    }

    @Test
    public void destToBreadthFirstPathsTest() {
        Assert.assertEquals("[5, 6]", breadthFirstPaths.pathTo(6).toString());
    }
}
