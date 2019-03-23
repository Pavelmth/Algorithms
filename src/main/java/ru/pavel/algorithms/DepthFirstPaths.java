package ru.pavel.algorithms;
import java.util.LinkedList;

public class DepthFirstPaths {
    private boolean[] marked;
    private int[] edgeTo;
    private int source;

    public DepthFirstPaths(Graph graph, int source) {
        if (source < 0) {
            throw new IllegalArgumentException();
        }
        if (source >= graph.vertexCount()) {
            throw new IndexOutOfBoundsException();
        }
        this.source = source;
        edgeTo = new int[graph.vertexCount()];
        marked = new boolean[graph.vertexCount()];
        dfs(graph, source);
    }

    private void dfs(Graph graph, int vertex) {
        marked[vertex] = true;
        for (int o:
            graph.adjList(vertex)) {
            if (!marked[o]) {
                edgeTo[o] = vertex;
                dfs(graph, o);
            }
        }
    }

    public boolean hasPathTo(int dest) {
        if (dest < 0) {
            throw new IllegalArgumentException();
        }
        if (dest >= marked.length) {
            throw new IndexOutOfBoundsException();
        }
        return marked[dest];
    }

    public LinkedList pathTo(int dest) {
        if (!hasPathTo(dest)) {
            return null;
        }
        LinkedList<Integer> stack = new LinkedList<>();

        int vertex = dest;
        while (vertex != source) {
            stack.push(vertex);
            vertex = edgeTo[vertex];
        }
        return stack;
    }
}
