import java.util.*;

// https://www.geeksforgeeks.org/problems/is-it-a-tree/0

/*
 * Approach
 * Graph is Tree if it validates the below conditions
 * 1. It has exactly n-1 edges for n nodes
 * 2. It doesn't have any cycle
 * 3. All the nodes are reachable
 */

class GraphIsTree {
    public boolean isTree(int n, int m, ArrayList<ArrayList<Integer>> edges) 
    {
        if (m != n - 1) return false;
        
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        
        for(ArrayList<Integer> edge : edges) {
            adj.get(edge.get(0)).add(edge.get(1));
            adj.get(edge.get(1)).add(edge.get(0));
        }
    
        boolean[] visited = new boolean[n];
        int[] parent = new int[n];
        
        int visitedNode = 1;
        
        Arrays.fill(parent, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;
                
        while(!q.isEmpty()) {
            int node = q.poll();
                    
            for(int neighbour : adj.get(node)) {
                if(!visited[neighbour]) {
                    parent[neighbour] = node;
                    q.add(neighbour);
                    visited[neighbour] = true;
                    visitedNode++;
                } else if (visited[neighbour] && parent[node]!=neighbour) {
                    return false;
                }
            }
        }
        
        
        return visitedNode==n;
    }
}

