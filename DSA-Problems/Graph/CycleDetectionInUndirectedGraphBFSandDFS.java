
// https://www.codingninjas.com/codestudio/problems/cycle-detection-in-undirected-graph_1062670?topList=love-babbar-dsa-sheet-problems&leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

import java.util.*;

public class CycleDetectionInUndirectedGraphBFSandDFS {

    private static boolean cycleBFS(List<Integer>[] adj, boolean[] visited, int start) {
        int[] parent = new int[visited.length];
        Arrays.fill(parent, -1);
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : adj[current]) {
                if (visited[neighbor] && parent[current] != neighbor) {
                    return true;
                } else if (!visited[neighbor]) {
                    queue.add(neighbor);
                    visited[neighbor] = true;
                    parent[neighbor] = current;
                }
            }
        }

        return false;
    }

    private static boolean cycleDFS(List<Integer>[] adj, boolean[] visited, int parent, int node) {
        visited[node] = true;

        for (int neighbor : adj[node]) {
            if (!visited[neighbor]) {
                if (cycleDFS(adj, visited, node, neighbor)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }

        return false;
    }

    public static String cycleDetection(int[][] edges, int n, int m) {
        List<Integer>[] adj = new ArrayList[n + 1]; // 1-based indexing
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj[u].add(v);
            adj[v].add(u);
        }

        boolean[] visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                // Uncomment whichever method you want to use:
                if (cycleBFS(adj, visited, i)) return "Yes";
                // if (cycleDFS(adj, visited, -1, i)) return "Yes";
            }
        }

        return "No";
    }
}
