package ru.pavel.algorithms;
import java.util.LinkedList;

public class BreadthFirstPaths {
    private int[] edgeTo;
    private boolean[] marked;
    private int[] dirTo;
    private int source;
    private static final int INF = Integer.MAX_VALUE;

    public BreadthFirstPaths(Graph graph, int source) {
        if (source < 0) {
            throw new IllegalArgumentException();
        }
        if (source >= graph.vertexCount()) {
            throw new IndexOutOfBoundsException();
        }
        marked = new boolean[graph.vertexCount()];
        edgeTo = new int[graph.vertexCount()];
        dirTo = new int[graph.vertexCount()];
        this.source = source;
        for (int i = 0; i < dirTo.length; i++) {
            dirTo[i] = INF;
        }
        bfs(graph, source);
    }

    private void bfs(Graph graph, int source) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(source);
        marked[source] = true;
        dirTo[source] = 0;

        while (!queue.isEmpty()) {
            int vertex = queue.removeFirst();
            for (int o:
                 graph.adjList(vertex)) {
                if (!marked[o]) {
                    marked[o] = true;
                    edgeTo[o] = vertex;
                    dirTo[o] = dirTo[vertex] + 1;
                    queue.addLast(o);
                }
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

    public int destTo(int dest) {
        if (dest < 0) {
            throw new IllegalArgumentException();
        }
        if (dest >= marked.length) {
            throw new IndexOutOfBoundsException();
        }
        return dirTo[dest];
    }
}
