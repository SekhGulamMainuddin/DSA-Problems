// https://leetcode.com/problems/pacific-atlantic-water-flow/description/

/**
 * 🔹 Thought Process:
 * 1. **Understanding the Problem Statement:**
 *    - Each cell represents an elevation.
 *    - Water can only flow **downhill or at the same level**.
 *    - A cell is valid if it can reach both **Pacific** (left/top) and **Atlantic** (right/bottom) oceans.
 *
 * 2. **Key Observations:**
 *    - **Brute Force (Not Feasible)**: 
 *      - Start from every cell and check if water can reach both oceans.
 *      - Would require **O(m × n)** DFS runs → Too slow!
 *    - **Reverse the Thinking:**
 *      - Instead of checking "Can water flow from (i, j) to both oceans?", ask:
 *      - "Which cells can flow to each ocean?" (Start from the oceans!)
 *
 * 3. **Optimized Approach (DFS from Ocean Borders):**
 *    - **Start from the Pacific Ocean:** 
 *      - Water can always flow from the **top row** and **left column**.
 *      - Mark all reachable cells.
 *    - **Start from the Atlantic Ocean:**
 *      - Water can always flow from the **bottom row** and **right column**.
 *      - Mark all reachable cells.
 *    - **Find the Intersection** → Cells marked **reachable in both** oceans are part of the answer.
 */

/**
 * 🔹 Intuition:
 * 1. Water can only flow **downhill** or at the **same level**.
 * 2. If a cell can reach both the **Pacific** (left/top) and **Atlantic** (right/bottom) oceans, it is part of the result.
 * 3. Instead of starting from every cell, we reverse the thinking:
 *    - Start from the ocean borders and find **all cells that can reach** them.
 *    - Use two boolean matrices (`pacific[][]` and `atlantic[][]`) to track cells that can reach each ocean.
 * 4. Finally, collect cells that are **true** in both matrices.
 */

/**
 * 🔹 Approach:
 * 1. **Use Two DFS Traversals**
 *    - One for the **Pacific Ocean** (starting from top row & left column).
 *    - One for the **Atlantic Ocean** (starting from bottom row & right column).
 * 2. **DFS Traversal Rules:**
 *    - Water can only flow **to equal or lower height cells**.
 *    - If a cell is already marked as reachable, **skip it**.
 * 3. **Find Common Cells**
 *    - A cell is a valid result if it is **reachable from both oceans**.
 * 4. **Result Construction**
 *    - Collect all such cells and return as the answer.
 */

/**
 * 🔹 Time Complexity: **O(m × n)**
 *    - We run DFS from **each border cell** at most once.
 *    - Each DFS traversal marks cells as visited and avoids revisits.
 *    - In the worst case, we visit each cell **twice** (once for each ocean).
 *
 * 🔹 Space Complexity: **O(m × n)**
 *    - We use two boolean matrices (`pacific[][]` and `atlantic[][]`) of size **O(m × n)**.
 *    - In the worst case, the recursion stack may reach **O(m × n)** depth.
 */


import java.util.*;

class PacificAtlanticWaterFlow {
    // Direction vectors for moving up, down, left, and right
    private final int[] dx = {0, 0, 1, -1};
    private final int[] dy = {1, -1, 0, 0};

    /**
     * Given an m x n matrix of heights, returns a list of coordinates (row, col)
     * where water can flow to both the Pacific and Atlantic oceans.
     */
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();

        int r = heights.length, c = heights[0].length;
        
        // Two boolean matrices to track cells that can reach Pacific and Atlantic oceans
        boolean[][] pacific = new boolean[r][c];
        boolean[][] atlantic = new boolean[r][c];

        /**
         * Step 1: Perform DFS from all Pacific border cells (left & top edges)
         * Pacific ocean touches:
         *   - Leftmost column (j = 0)
         *   - Topmost row (i = 0)
         */
        for(int i = 0; i < r; i++) {
            dfs(heights, i, 0, Integer.MIN_VALUE, pacific);   // Left column (Pacific)
            dfs(heights, i, c - 1, Integer.MIN_VALUE, atlantic); // Right column (Atlantic)
        }

        /**
         * Step 2: Perform DFS from all Atlantic border cells (bottom & right edges)
         * Atlantic ocean touches:
         *   - Rightmost column (j = c-1)
         *   - Bottommost row (i = r-1)
         */
        for(int i = 0; i < c; i++) {
            dfs(heights, 0, i, Integer.MIN_VALUE, pacific);   // Top row (Pacific)
            dfs(heights, r - 1, i, Integer.MIN_VALUE, atlantic); // Bottom row (Atlantic)
        }

        /**
         * Step 3: Collect the cells that can reach both oceans
         * If a cell is marked as true in both the Pacific and Atlantic matrices,
         * it means water can flow to both oceans from that cell.
         */
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ArrayList<Integer> point = new ArrayList<>();
                    point.add(i);
                    point.add(j);
                    ans.add(point); // Add cell that can reach both oceans
                }
            }
        }

        return ans;
    }

    /**
     * DFS function to mark reachable cells for the given ocean.
     * It explores neighbors and marks cells that satisfy the water flow condition.
     *
     * @param heights - Matrix representing height values
     * @param i - Current row index
     * @param j - Current column index
     * @param prev - Height of the previous cell in DFS path (ensures valid flow)
     * @param ocean - Boolean matrix tracking reachable cells for an ocean
     */
    private void dfs(int[][] heights, int i, int j, int prev, boolean[][] ocean) {
        // **Base Cases: Stop DFS if any of these conditions are met**
        if (i < 0 || j < 0 || i >= ocean.length || j >= ocean[0].length) {
            return; // Out of bounds
        } 
        if (heights[i][j] < prev || ocean[i][j]) {
            return; // Can't flow uphill or already visited
        }

        // **Mark the cell as reachable for the current ocean**
        ocean[i][j] = true;

        // **Explore all 4 possible directions (DFS)**
        for (int d = 0; d < 4; d++) {
            int idx = i + dx[d];
            int jdy = j + dy[d];
            dfs(heights, idx, jdy, heights[i][j], ocean);
        }
    }
}


/// My Own Solution
class Solution {
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        int nr = heights.length;
        int nc = heights[0].length;
        int[][] pFlow = new int[nr][nc];
        int[][] aFlow = new int[nr][nc];

        for(int r=0; r<heights.length; r++) {
            markWaterFlow(heights, pFlow, r, 0);
            markWaterFlow(heights, aFlow, r, heights[0].length-1);
        }

        for(int c=0; c<heights[0].length; c++) {
            markWaterFlow(heights, pFlow, 0, c);
            markWaterFlow(heights, aFlow, heights.length-1, c);
        }

        for(int r=0; r<heights.length; r++) {
            for(int c=0; c<heights[0].length; c++) {
                if(pFlow[r][c]==1 && aFlow[r][c]==1) {
                    List<Integer> list = new ArrayList<>();
                    list.add(r);
                    list.add(c);
                    ans.add(list);
                }
            }
        }

        return ans;
    }

    private void markWaterFlow(int[][] heights, int[][] flow, int r, int c) {
        if(flow[r][c]==1) {
            return;
        }
        flow[r][c] = 1;

        for(int i=0; i<4; i++) {
            int newR = r+dx[i];
            int newC = c+dy[i];
            if(newR<heights.length && newR>=0 && newC<heights[0].length && newC>=0) {
                int sideHeight = heights[r+dx[i]][c+dy[i]];
                if(sideHeight>=heights[r][c]) {
                    markWaterFlow(heights, flow, r+dx[i], c+dy[i]);
                }
            }
        }
    }
}