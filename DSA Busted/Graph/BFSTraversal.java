import java.util.*;

// https://www.geeksforgeeks.org/problems/bfs-traversal-of-graph/1

class BFSTraversal {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        visited[0] = true;
        
        while(!q.isEmpty()) {
            int i = q.poll();
            
            ans.add(i);
            
            for(int neighbour : adj.get(i)) {
                if(!visited[neighbour]) {
                    visited[neighbour] = true;
                    q.add(neighbour);
                }
            }
        }
        
        return ans;
    }
}