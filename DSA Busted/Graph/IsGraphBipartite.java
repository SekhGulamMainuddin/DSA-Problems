import java.util.LinkedList;
import java.util.Queue;

// https://leetcode.com/problems/is-graph-bipartite/description/

class IsGraphBipartite {
    private boolean dfs(int[][] graph, int[] color, int node) {
        int neighbourColor = color[node] == 0 ? 1 : 0;
        for(int neighbour : graph[node]) {
            if(color[neighbour]==-1) {
                color[neighbour] = neighbourColor;
                if(!dfs(graph, color, neighbour)) {
                    return false;
                }
            } else if (color[neighbour] == color[node]) {
                return false;
            }
        }

        return true;
    }

    private boolean bfs(int[][] graph, int[] color, int i) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);

        while(!q.isEmpty()) {
            int node = q.poll();
            int neighbourColor = color[node] == 0 ? 1 : 0;
            for(int neighbour : graph[node]) {
                if(color[neighbour]==-1) {
                    q.add(neighbour);
                    color[neighbour] = neighbourColor;
                } else if (color[neighbour]==color[node]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for(int i=0; i<graph.length; i++) {
            color[i] = -1;
        }

        for(int i=0; i<graph.length; i++) {
            if(color[i]==-1) {
                color[i] = 0;
                if(!dfs(graph, color, i)) {
                    return false;
                }
                if(!bfs(graph, color, i)) {
                    return false;
                }
            }
        }

        return true;
    }
}