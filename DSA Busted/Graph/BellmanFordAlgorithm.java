
// https://www.codingninjas.com/codestudio/problems/bellmon-ford_2041977?leftPanelTab=1
import java.util.*;

public class BellmanFordAlgorithm {
    public static int[] bellmonFord(int n, int m, int src, List<List<Integer>> edges) {
        int[] distance = new int[n + 1]; // 1-based indexing
        Arrays.fill(distance, (int) 1e8); // Use a large number to represent infinity
        distance[src] = 0;

        // Relax all edges n-1 times
        
        for (int i = 1; i < n; i++) {
            for (List<Integer> edge : edges) {
                int u = edge.get(0);
                int v = edge.get(1);
                int wt = edge.get(2);
                if ((distance[u] + wt) < distance[v]) {
                    distance[v] = distance[u] + wt;
                }
            }
        }

        // Optional: Check for negative weight cycles
        // for (List<Integer> edge : edges) {
        //     int u = edge.get(0), v = edge.get(1), wt = edge.get(2);
        //     if (distance[u] != (int) 1e8 && distance[u] + wt < distance[v]) {
        //         return new int[]{-1}; // or handle cycle detection separately
        //     }
        // }

        return distance;
    }
}
