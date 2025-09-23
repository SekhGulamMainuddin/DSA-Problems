
// https://www.codingninjas.com/codestudio/problems/prim-s-mst_1095633?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

import java.util.*; 

/*
 * Prim’s Algorithm – Intuition and Explanation
 * ---------------------------------------------
 * Prim’s Algorithm is a greedy algorithm used to find the Minimum Spanning Tree (MST) 
 * of a connected, undirected, weighted graph.
 *
 * A Minimum Spanning Tree (MST) is:
 * - A subset of the edges that connects all vertices,
 * - Without forming any cycles,
 * - With the minimum total edge weight.
 *
 * 🧠 Intuition:
 * Start from any node (e.g., node 1). At every step:
 * 1. Pick the edge with the smallest weight that connects a node inside the MST to a node outside.
 * 2. Add that edge and the new node to the MST.
 * 3. Repeat until all nodes are included.
 *
 * ✅ Why it works:
 * - Always expands the MST using the minimum weight edge.
 * - Ensures no cycles and minimum total cost.
 *
 * 🆚 Kruskal’s vs Prim’s:
 * - Kruskal’s: Edge-based, uses sorting and Union-Find (good for sparse graphs).
 * - Prim’s: Node-based, grows MST from a node using a min-heap (better for dense graphs).
 *
 * ⏱️ Time Complexity:
 * - Naive implementation (without PriorityQueue): O(n^2)
 * - Efficient implementation (with PriorityQueue): O((n + m) * log n)
 *   where n = number of nodes, m = number of edges.
 *
 * 💡 Data Structures Used:
 * - Adjacency List: To store the graph.
 * - keys[]: Minimum weight edge needed to include a node in MST.
 * - parent[]: Stores the parent node to reconstruct the MST.
 * - mst[]: Boolean array to track which nodes are already in the MST.
 * - PriorityQueue (Min-Heap): To always fetch the next node with the smallest connecting edge.
 *
 * 📌 Result:
 * The final MST is represented as a list of edges: [parent, child, weight]
 */

public class PrimsMST 
{
    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        // Adjacency List representation of the graph
        HashMap<Integer, List<int[]>> adj = new HashMap<>();
        
        // Building the adjacency list
        for (ArrayList<Integer> edge : g) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);
            
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            
            adj.get(u).add(new int[]{v, weight});
            adj.get(v).add(new int[]{u, weight});
        }

        // Initializing the required data structures
        int[] keys = new int[n + 1]; // Minimum edge weight to a node
        boolean[] mst = new boolean[n + 1]; // If node is part of MST
        int[] parent = new int[n + 1]; // Stores parent of each node in MST

        Arrays.fill(keys, Integer.MAX_VALUE);
        Arrays.fill(mst, false);
        Arrays.fill(parent, -1);

        keys[1] = 0; // Start from node 1
        
        // Constructing MST
        for (int i = 1; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int u = -1;

            // Finding the minimum key value node that is not in MST
            for (int v = 1; v <= n; v++) {
                if (!mst[v] && keys[v] < min) {
                    min = keys[v];
                    u = v;
                }
            }

            // Mark node as included in MST
            mst[u] = true;

            // Update adjacent nodes
            if (adj.containsKey(u)) {
                for (int[] neighbor : adj.get(u)) {
                    int v = neighbor[0];
                    int w = neighbor[1];

                    if (!mst[v] && w < keys[v]) {
                        keys[v] = w;
                        parent[v] = u;
                    }
                }
            }
        }

        // Constructing the MST result
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(parent[i]);
            edge.add(i);
            edge.add(keys[i]);
            ans.add(edge);
        }

        return ans;
    }
}

class PrimsMSTWithPriorityQueue
{
    static class Pair {
        int node, weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    static class CustomComparator implements Comparator<Pair> {
        public int compare(Pair a, Pair b) {
            return Integer.compare(a.weight, b.weight);
        }
    }

    public static ArrayList<ArrayList<Integer>> calculatePrimsMST(int n, int m, ArrayList<ArrayList<Integer>> g)
    {
        // Adjacency List representation of the graph
        HashMap<Integer, List<Pair>> adj = new HashMap<>();

        // Build adjacency list
        for (ArrayList<Integer> edge : g) {
            int u = edge.get(0);
            int v = edge.get(1);
            int weight = edge.get(2);
            
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            
            adj.get(u).add(new Pair(v, weight));
            adj.get(v).add(new Pair(u, weight));
        }

        // Min-Heap (Priority Queue) to get the minimum weight edge efficiently
        PriorityQueue<Pair> pq = new PriorityQueue<>(new CustomComparator());

        int[] keys = new int[n + 1]; // Stores min weight to connect node
        int[] parent = new int[n + 1]; // Stores parent node of each node
        boolean[] mst = new boolean[n + 1]; // Keeps track of nodes in MST

        Arrays.fill(keys, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);
        Arrays.fill(mst, false);

        // Start from node 1
        keys[1] = 0;
        pq.offer(new Pair(1, 0)); // {node, weight}

        while (!pq.isEmpty()) {
            Pair curr = pq.poll();
            int u = curr.node;

            // Skip if already part of MST
            if (mst[u]) continue;

            // Mark node as included in MST
            mst[u] = true;

            // Process adjacent nodes
            if (adj.containsKey(u)) {
                for (Pair neighbor : adj.get(u)) {
                    int v = neighbor.node;
                    int weight = neighbor.weight;

                    // If the new edge gives a lower weight, update it
                    if (!mst[v] && weight < keys[v]) {
                        keys[v] = weight;
                        parent[v] = u;
                        pq.offer(new Pair(v, keys[v]));
                    }
                }
            }
        }

        // Construct the MST result
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 2; i <= n; i++) {
            ArrayList<Integer> edge = new ArrayList<>();
            edge.add(parent[i]);
            edge.add(i);
            edge.add(keys[i]);
            ans.add(edge);
        }

        return ans;
    }
}
