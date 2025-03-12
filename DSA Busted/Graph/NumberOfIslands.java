// https://leetcode.com/problems/number-of-islands/
/**
 * 🔹 Thought Process:
 * 1. **Understanding the Problem:**
 *    - The grid consists of **'1' (land)** and **'0' (water)**.
 *    - An **island** is a group of connected '1's (connected in 4 directions: up, down, left, right).
 *    - Our goal is to **count the number of islands** in the grid.
 *
 * 2. **Key Observations:**
 *    - If we find a '1' that is **not visited**, it must be part of a new island.
 *    - We should **traverse and mark all connected lands ('1's)** as visited.
 *    - We can use **DFS (Depth First Search)** to explore each island.
 *
 * 3. **Optimized Approach (DFS Traversal):**
 *    - **Iterate through the grid** to find **unvisited '1's**.
 *    - When a new '1' is found:
 *      - **Increase the island count**.
 *      - **Use DFS to mark all connected lands ('1's) as visited**.
 *    - Continue scanning the grid until all islands are counted.
 */

/**
 * 🔹 Intuition:
 * 1. If a cell contains '1' (land) and has not been visited, it is **part of a new island**.
 * 2. Once we identify an island, we **explore all connected lands** using DFS to mark them as visited.
 * 3. Every time we start a DFS from an unvisited land cell, we **increase the island count**.
 * 4. The result is the total number of DFS calls that were triggered for new islands.
 */

/**
 * 🔹 Approach:
 * 1. **Initialize a visited matrix** to track visited land cells.
 * 2. **Iterate through the entire grid**:
 *    - If a cell is **'1' and not visited**:
 *      - **Increase the island count**.
 *      - **Start DFS** from this cell to mark the entire island as visited.
 * 3. **DFS Traversal**:
 *    - Explore the **four possible directions** (up, down, left, right).
 *    - If the next cell is within bounds, unvisited, and contains '1', continue DFS.
 * 4. **Return the total number of islands** counted during traversal.
 */

/**
 * 🔹 Time Complexity: **O(m × n)**
 *    - We visit each cell **at most once**.
 *    - DFS explores all connected lands efficiently.
 *
 * 🔹 Space Complexity: **O(m × n)**
 *    - **Visited array** takes O(m × n) space.
 *    - **Recursion stack** can go up to O(m × n) in the worst case (entire grid is land).
 */

 class NumberOfIslands {
    // Direction arrays for moving in 4 possible directions (Right, Left, Down, Up)
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};

    /**
     * 🔹 Depth First Search (DFS) function to explore an island and mark all its connected land ('1') as visited.
     * @param grid    - The given 2D grid of '1's (land) and '0's (water).
     * @param visited - A 2D boolean array to keep track of visited land cells.
     * @param i       - Current row index.
     * @param j       - Current column index.
     */
    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        // Traverse all 4 possible directions (Right, Left, Down, Up)
        for (int d = 0; d < 4; d++) {
            int dxi = i + dx[d]; // New row index
            int dyj = j + dy[d]; // New column index

            // Check if the new position is within bounds and contains land ('1') that is not visited
            if (dxi >= 0 && dyj >= 0 && dxi < grid.length && dyj < grid[0].length 
                && grid[dxi][dyj] == '1' && !visited[dxi][dyj]) {
                
                // Mark this land cell as visited
                visited[dxi][dyj] = true;

                // Recursively explore the connected land cells
                dfs(grid, visited, dxi, dyj);
            }
        }
    }

    /**
     * 🔹 Main function to count the number of islands in the given grid.
     * @param grid - 2D grid containing '1's (land) and '0's (water).
     * @return The number of islands found.
     */
    public int numIslands(char[][] grid) {
        // Edge case: If grid is empty, return 0
        if (grid == null || grid.length == 0) {
            return 0;
        }

        // Create a 2D visited array to track visited land cells
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        int land = 0; // Counter for the number of islands

        // Traverse the entire grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                // If the current cell is land ('1') and not visited, it's a new island
                if (!visited[i][j] && grid[i][j] == '1') {
                    land++; // Increase the island count
                    visited[i][j] = true; // Mark this cell as visited
                    
                    // Start DFS to mark all connected land cells as visited
                    dfs(grid, visited, i, j);
                }
            }
        }

        return land; // Return the total number of islands
    }
}
