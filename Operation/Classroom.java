package Operation;

import java.util.ArrayList;

public class Classroom {

    public static class Edge {
        int src; // source of the graph
        int dest; // destination
        int wt; // weight of the edge

        public Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void main(String[] args) {
        int v = 5;
        @SuppressWarnings("unchecked")
        // int[] hell = new int[5]; just see 22 and 23 line maga
        ArrayList<Edge>[] graph = new ArrayList[v];

        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // 0 - vertex
        graph[0].add(new Edge(0, 1, 5));
        // 1- vertex
        graph[1].add(new Edge(1, 0, 5));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 3));
        // 2 vertex
        graph[2].add(new Edge(2, 1, 1));
        graph[2].add(new Edge(2, 3, 1));
        graph[2].add(new Edge(2, 4, 4));
        // 3 Vertex
        graph[3].add(new Edge(3, 1, 3));
        graph[3].add(new Edge(3, 2, 1));
        // 4 vertex
        graph[4].add(new Edge(4, 2, 2));
        // printing 2's neighbors
        for (int i = 0; i < graph[2].size(); i++) {
            Edge e = graph[2].get(i);
            System.out.print(e.dest);
        }
        System.out.println();
    }
}