
// https://leetcode.com/problems/rotting-oranges/description/

/*
Intuition:
-----------
- We have a grid where:
  0 -> Empty cell
  1 -> Fresh orange
  2 -> Rotten orange
- A rotten orange at (i, j) can rot adjacent fresh oranges (up, down, left, right) in 1 minute.
- We need to determine the minimum time required for all oranges to rot. If any fresh orange 
  remains unrotted, return -1.

Approach:
-----------
1. **Use BFS (Breadth-First Search):**
   - Add all initially rotten oranges into a queue along with time = 0.
   - Perform BFS level-wise, rotting adjacent fresh oranges.
   - Keep track of time taken using `currentTime` in the queue.
   - If we find a fresh orange that never rots, return -1.

2. **Steps:**
   - First, traverse the grid and enqueue all initially rotten oranges.
   - Use BFS to process rotten oranges and rot their adjacent fresh ones.
   - Track the maximum time required for the rotting process.
   - Finally, check if any fresh oranges remain; if so, return -1.

Time Complexity:
---------------
- **O(m × n)** : We traverse the grid **O(m × n)** times (initial traversal, BFS processing, final check).

Space Complexity:
----------------
- **O(m × n)** : Worst case, all oranges are rotten or fresh, requiring **O(m × n)** space for the queue.
*/

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    private static class RottenOrange {
        int i, j, currentTime;

        RottenOrange(int i, int j, int currentTime) {
            this.i = i;
            this.j = j;
            this.currentTime = currentTime;
        }
    }

    public int orangesRotting(int[][] grid) {
        int time = 0; // Track time taken for all oranges to rot
        int m = grid.length, n = grid[0].length;

        // Directions for moving up, down, left, and right
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        Queue<RottenOrange> q = new LinkedList<>();

        // Step 1: Add all initially rotten oranges to the queue
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.add(new RottenOrange(i, j, 0));
                }
            }
        }

        // Step 2: Process the queue using BFS
        while (!q.isEmpty()) {
            RottenOrange o = q.poll();
            time = Math.max(time, o.currentTime); // Track the max time

            // Try rotting adjacent fresh oranges
            for (int i = 0; i < 4; i++) {
                int dxi = o.i + dx[i];
                int dyj = o.j + dy[i];

                // Check boundaries and if it's a fresh orange
                if (dxi >= 0 && dyj >= 0 && dxi < m && dyj < n && grid[dxi][dyj] == 1) {
                    grid[dxi][dyj] = 2; // Mark orange as rotten
                    q.add(new RottenOrange(dxi, dyj, o.currentTime + 1)); // Add to queue with incremented time
                }
            }
        }

        // Step 3: Check if any fresh orange is left
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    return -1; // If fresh orange remains, return -1
                }
            }
        }

        return time; // Return the total time required for rotting all oranges
    }
}
