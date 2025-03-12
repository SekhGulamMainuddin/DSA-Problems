import java.util.*;

// https://www.geeksforgeeks.org/problems/depth-first-traversal-for-a-graph/1

class DFSTraversal {
    private void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] visited, ArrayList<Integer> ans, int v) {
        visited[v] = true;
        ans.add(v);
        
        for(int neighbour : adj.get(v)) {
            if(!visited[neighbour]) {
                dfs(adj, visited, ans, neighbour);
            }
        }
    }
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        
        dfs(adj, visited, ans, 0);
        
        return ans;
    }
}