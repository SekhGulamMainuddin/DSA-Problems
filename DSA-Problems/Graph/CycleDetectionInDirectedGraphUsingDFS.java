
// https://www.codingninjas.com/codestudio/problems/detect-cycle-in-a-directed-graph_1062626?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
import java.util.*;

public class CycleDetectionInDirectedGraphUsingDFS {
    
    public static boolean detectCycleInDirectedGraph(int n, ArrayList<ArrayList<Integer>> edges) {
        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (ArrayList<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            adj.get(u).add(v);
        }

        boolean[] visited = new boolean[n + 1];
        boolean[] dfsVisited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                if (dfsCycleCheck(i, adj, visited, dfsVisited)) {
                    return true; // Cycle detected
                }
            }
        }

        return false; // No cycle
    }

    private static boolean dfsCycleCheck(int node, List<List<Integer>> adj, boolean[] visited, boolean[] dfsVisited) {
        visited[node] = true;
        dfsVisited[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (dfsCycleCheck(neighbor, adj, visited, dfsVisited)) {
                    return true;
                }
            } else if (dfsVisited[neighbor]) {
                // A back edge is found -> cycle detected
                return true;
            }
        }

        dfsVisited[node] = false; // backtrack
        return false;
    }
}
