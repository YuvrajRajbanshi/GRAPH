package BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Bfs {

    public static class Edge {
        int src;
        int dest;
        int wt;

        Edge(int src, int dest, int wt) {
            this.src = src;
            this.dest = dest;
            this.wt = wt;
        }
    }

    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        // vertext 0
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        // vertext 1
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        // vertext 2
        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));
        // vertext 3
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        // vertext 4
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        // vertext 5
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        // vertext 6
        graph[6].add(new Edge(6, 5, 1));
    }

    // actual BFS funtion
    // public static void BFS(ArrayList<Edge>[] graph) {
    // Queue<Integer> q = new LinkedList<>();
    // boolean vis[] = new boolean[graph.length];
    // q.add(0); // source = 0
    // while (!q.isEmpty()) {
    // int curr = q.remove();
    // if (!vis[curr]) {
    // // visit curr
    // System.out.print(curr + " ");
    // vis[curr] = true;
    // for (int i = 0; i < graph[curr].size(); i++) {
    // Edge e = graph[curr].get(i);
    // q.add(e.dest);
    // }
    // }
    // }
    // }

    public static void BFS(ArrayList<Edge>[] graph) {
        boolean vis[] = new boolean[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (!vis[i]) {
                BFSUtil(graph, vis);
            }
        }

    }

    public static void BFSUtil(ArrayList<Edge>[] graph, boolean vis[]) {

        Queue<Integer> q = new LinkedList<>();
        // boolean vis[] = new boolean[graph.length];
        q.add(0); // source = 0
        while (!q.isEmpty()) {
            int curr = q.remove();
            if (!vis[curr]) {
                // visit curr
                System.out.print(curr + " ");
                vis[curr] = true;
                for (int i = 0; i < graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
    }

    public static void main(String[] args) {

        int v = 7;
        ArrayList<Edge>[] graph = new ArrayList[v];
        createGraph(graph);
        BFS(graph);

    }
}
