
// https://www.codingninjas.com/codestudio/problems/minimum-spanning-tree_631769?topList=love-babbar-dsa-sheet-problems&leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar
import java.util.*;

public class KrushkalsMST {

    // Function to initialize the Disjoint Set (Union-Find) structure
    private static void makeSet(int[] parent, int[] rank, int n) {
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each node is its own parent initially
            rank[i] = 0;    // Rank is initially set to 0
        }
    }

    // Function to find the representative (root) of a set using path compression
    private static int findParent(int node, int[] parent) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = findParent(parent[node], parent); // Path compression
    }

    // Function to perform union of two sets by rank
    private static void unionSet(int u, int v, int[] parent, int[] rank) {
        u = findParent(u, parent);
        v = findParent(v, parent);

        if (rank[u] < rank[v]) {
            parent[u] = v; // Attach the smaller rank tree under the larger rank tree
        } else if (rank[u] > rank[v]) {
            parent[v] = u;
        } else {
            parent[v] = u; // If ranks are the same, make one root and increase its rank
            rank[u]++;
        }
    }

    // Function to find the Minimum Spanning Tree (MST) using Kruskal's Algorithm
    public static int minimumSpanningTree(ArrayList<ArrayList<Integer>> edges, int n) {
        // Step 1: Sort edges based on their weights
        edges.sort(Comparator.comparingInt(a -> a.get(2)));
        
        // Step 2: Initialize Disjoint Set
        int[] parent = new int[n];
        int[] rank = new int[n];
        makeSet(parent, rank, n);

        int minWeight = 0; // Variable to store total weight of the MST
        
        // Step 3: Iterate through sorted edges
        for (ArrayList<Integer> edge : edges) {
            int u = findParent(edge.get(0), parent); // Find parent of node u
            int v = findParent(edge.get(1), parent); // Find parent of node v
            
            // If u and v belong to different sets, include this edge in MST
            if (u != v) {
                minWeight += edge.get(2); // Add edge weight to MST
                unionSet(u, v, parent, rank); // Merge sets
            }
        }
        
        return minWeight; // Return total weight of MST
    }
}
