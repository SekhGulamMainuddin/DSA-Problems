
// https://www.codingninjas.com/codestudio/problems/count-strongly-connected-components-kosaraju-s-algorithm_1171151?leftPanelTab=1
import java.util.*;

/*
 * Kosaraju’s Algorithm - Intuition and Steps
 * ------------------------------------------
 * Goal: Count number of Strongly Connected Components (SCCs) in a directed graph.
 * 
 * 🔁 Strongly Connected Component: A group of nodes where each node is reachable from every other node in the same group.
 *
 * ✅ 3 Step Kosaraju’s Algorithm:
 * -----------------------------
 * 1️⃣ Do a **DFS** on the original graph and **push nodes into a stack** in order of their **finish times**. (Find the Topological Sort)
 * 
 * 2️⃣ **Reverse** all the edges of the graph to form the **transpose** graph.
 * 
 * 3️⃣ While the stack is not empty:
 *     - Pop a node from the stack.
 *     - If it's not visited, do a **DFS on the transpose graph** starting from that node.
 *     - That DFS call gives you **one complete SCC** — increment the count.
 * 
 * 📦 Time Complexity:
 * - Build graph + transpose: O(E)
 * - 2 DFS traversals: O(V + E)
 * - Overall: O(V + E)
 */

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
