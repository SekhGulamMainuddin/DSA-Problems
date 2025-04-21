import java.util.LinkedList;
import java.util.Queue;

// Problem: https://leetcode.com/problems/is-graph-bipartite/

class IsGraphBipartite {

    /**
     * DFS function to try coloring the graph.
     * @param graph The adjacency list of the graph
     * @param color Array to keep track of node colors (0 or 1)
     * @param node Current node being visited
     * @return true if graph can be colored bipartitely, false otherwise
     */
    private boolean dfs(int[][] graph, int[] color, int node) {
        // Color for adjacent nodes
        int neighbourColor = color[node] == 0 ? 1 : 0;

        for (int neighbour : graph[node]) {
            if (color[neighbour] == -1) {
                // Color the neighbour and continue DFS
                color[neighbour] = neighbourColor;
                if (!dfs(graph, color, neighbour)) {
                    return false;
                }
            } else if (color[neighbour] == color[node]) {
                // Conflict found, not bipartite
                return false;
            }
        }

        return true;
    }

    /**
     * BFS function to try coloring the graph.
     * @param graph The adjacency list of the graph
     * @param color Array to keep track of node colors (0 or 1)
     * @param i Starting node for BFS
     * @return true if graph can be colored bipartitely, false otherwise
     */
    private boolean bfs(int[][] graph, int[] color, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while (!q.isEmpty()) {
            int node = q.poll();
            int neighbourColor = color[node] == 0 ? 1 : 0;

            for (int neighbour : graph[node]) {
                if (color[neighbour] == -1) {
                    // Assign opposite color and add to queue
                    q.add(neighbour);
                    color[neighbour] = neighbourColor;
                } else if (color[neighbour] == color[node]) {
                    // Conflict found, not bipartite
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Main function to check if the graph is bipartite.
     * @param graph The adjacency list of the graph
     * @return true if the graph is bipartite, false otherwise
     */
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];

        // Initially mark all nodes as uncolored
        for (int i = 0; i < graph.length; i++) {
            color[i] = -1;
        }

        // For disconnected graphs, check each component
        for (int i = 0; i < graph.length; i++) {
            if (color[i] == -1) {
                color[i] = 0;

                // You should use either DFS or BFS.
                // Using both is redundant unless for learning/comparison.
                if (!dfs(graph, color, i)) {
                    return false;
                }

                // If you're using DFS above, BFS below is unnecessary.
                // Keeping both may cause logical conflict as color is already partially filled.
                // if (!bfs(graph, color, i)) {
                //     return false;
                // }
            }
        }

        return true;
    }
}
