package TopoBFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeetCode {

    public static class Edge {
        int src;
        int dest;

        Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }
    }

    // numCourses = 2, prerequisites = [[1,0]]
    public static void createGraph(ArrayList<Edge>[] graph) {
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[1].add(new Edge(1, 0));

    }

    public static void calcIndeg(ArrayList<Edge>[] graph, int[] indegree) {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].size(); j++) {
                Edge e = graph[i].get(j);
                indegree[e.dest]++;
            }
        }
    }

    public static int[] findOrder(ArrayList<Edge> graph[]) {
        int indegre[] = new int[graph.length];
        calcIndeg(graph, indegre);
        ArrayList<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < graph.length; i++) {
            if (indegre[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int curr = q.remove();
            ans.add(curr);
            System.out.print(curr + " ");
            for (int i = 0; i < graph[curr].size(); i++) {
                Edge e = graph[curr].get(i);
                indegre[e.dest]--;
                if (indegre[i] == 0) {
                    q.add(i);
                }
            }
            // System.out.println();
        }
        int result[] = new int[ans.size()];
        for (int i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        int V = 2;
        ArrayList<Edge>[] graph = new ArrayList[V];

        createGraph(graph);
        // findOrder(graph);
        // System.out.println(findOrder(graph));
        int arr[] = findOrder(graph);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
