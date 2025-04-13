
// https://www.codingninjas.com/codestudio/problems/count-strongly-connected-components-kosaraju-s-algorithm_1171151?leftPanelTab=1
import java.util.*;

public class KosarajusAlgorithm {
    private static void dfs(int node, Map<Integer, List<Integer>> adj, boolean[] visited, Stack<Integer> topo) {
        visited[node] = true;
        for (int neighbor : adj.getOrDefault(node, new ArrayList<>())) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, topo);
            }
        }
        topo.push(node);
    }

    private static void revDfs(int node, Map<Integer, List<Integer>> transpose, boolean[] visited) {
        visited[node] = true;
        for (int neighbor : transpose.getOrDefault(node, new ArrayList<>())) {
            if (!visited[neighbor]) {
                revDfs(neighbor, transpose, visited);
            }
        }
    }

    public static int stronglyConnectedComponents(int v, ArrayList<ArrayList<Integer>> edges) {
        Map<Integer, List<Integer>> adj = new HashMap<>();
        Map<Integer, List<Integer>> transpose = new HashMap<>();

        // Building the graph and its transpose
        for (ArrayList<Integer> edge : edges) {
            int from = edge.get(0), to = edge.get(1);
            adj.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
            transpose.computeIfAbsent(to, k -> new ArrayList<>()).add(from);
        }

        // Step 1: Topological sort using DFS
        boolean[] visited = new boolean[v];
        Stack<Integer> topo = new Stack<>();
        for (int i = 0; i < v; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, topo);
            }
        }

        // Step 2: Reverse DFS using transpose
        Arrays.fill(visited, false);
        int count = 0;
        while (!topo.isEmpty()) {
            int node = topo.pop();
            if (!visited[node]) {
                count++;
                revDfs(node, transpose, visited);
            }
        }

        return count;
    }
}
