
// https://www.geeksforgeeks.org/problems/implementing-floyd-warshall2042/1

/**
 * Floyd-Warshall Algorithm for finding shortest paths between all pairs of nodes.
 * 
 * 1. Initialize:
 *    - If there is no direct edge between two nodes, set distance as infinity (Integer.MAX_VALUE).
 *    - Distance from a node to itself is 0.
 * 
 * 2. Update shortest paths:
 *    - Consider each node as an intermediate node one by one.
 *    - If a shorter path exists through the intermediate node, update the distance.
 *    - Ensure no overflow occurs when adding distances.
 * 
 * 3. Convert unreachable paths:
 *    - Any distance still set as Integer.MAX_VALUE is converted back to -1 to indicate no path.
 */

class FloydWarshall {
    public void shortestDistance(int[][] mat) {
        int n = mat.length;

        // Step 1: Initialize the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {
                    mat[i][j] = Integer.MAX_VALUE; // Set unreachable paths as "infinity"
                }
                if (i == j) {
                    mat[i][j] = 0; // Distance from a node to itself is always 0
                }
            }
        }

        // Step 2: Apply Floyd-Warshall Algorithm
        for (int via = 0; via < n; via++) { // Consider each node as an intermediate node
            for (int i = 0; i < n; i++) {   // Iterate over all pairs (i, j)
                for (int j = 0; j < n; j++) {
                    // Prevent integer overflow by checking if both paths are valid
                    if (mat[i][via] == Integer.MAX_VALUE || mat[via][j] == Integer.MAX_VALUE) {
                        continue; // Skip if there's no valid path through "via"
                    }
                    // Update shortest distance if a shorter path is found via the "via" node
                    mat[i][j] = Math.min(mat[i][j], mat[i][via] + mat[via][j]);
                }
            }
        }

        // Step 3: Convert "infinity" values back to -1 (indicating no path)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == Integer.MAX_VALUE) {
                    mat[i][j] = -1;
                }
            }
        }
    }
}
