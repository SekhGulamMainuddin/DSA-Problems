
// https://practice.geeksforgeeks.org/problems/cutted-segments1642/1
import java.util.Arrays;

class _7MaximizeTheCutSegments {
    /*
     * 🔍 Problem Understanding:
     * - Given a rod of length `n`, we need to **cut it into segments** of length `x`, `y`, or `z`.
     * - The goal is to maximize the **number of segments** obtained.
     * - We can cut the rod **in any order**.
     */

    /*
     * 🧠 Intuition:
     * - We try **all possible cuts** (`x`, `y`, `z`) and take the **maximum valid option**.
     * - If no cut is possible, return `0` (no segments can be formed).
     * - This is a **variation of the unbounded knapsack problem**.
     */

    /*
     * 🚀 Approach 1: Recursive DP with Memoization (Top-Down)
     * - Try cutting `x`, `y`, or `z` and find the **maximum segments**.
     * - Use **memoization (`dp[i]`)** to avoid recalculating for the same `n`.
     *
     * ✅ Time Complexity: **O(N)**
     * ✅ Space Complexity: **O(N)** (recursion stack + memoization array)
     */
    private int maxCuts(int n, int x, int y, int z, int[] dp) {
        if (n == 0) return 0; // If rod length is 0, no more cuts possible
        if (n < 0) return Integer.MIN_VALUE; // Invalid case (negative length)

        if (dp[n] != -1) return dp[n]; // Return precomputed result

        // Try cutting with `x`, `y`, `z` and take the best option
        int cutX = 1 + maxCuts(n - x, x, y, z, dp);
        int cutY = 1 + maxCuts(n - y, x, y, z, dp);
        int cutZ = 1 + maxCuts(n - z, x, y, z, dp);

        int maxCuts = Math.max(cutX, Math.max(cutY, cutZ));

        return dp[n] = (maxCuts < 0) ? 0 : maxCuts; // Ensure non-negative result
    }

    public int maximizeCuts(int n, int x, int y, int z) {
        // DP with Recursion + Memoization
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return maxCuts(n, x, y, z, dp);
    }

    /*
     * 🚀 Approach 2: Iterative DP with Tabulation (Bottom-Up)
     * - Create a `dp` array where `dp[i]` represents **maximum segments for rod length `i`**.
     * - Start from `dp[0] = 0` (base case) and build up to `dp[n]`.
     * - Transition:
     *   `dp[i] = max(dp[i - x] + 1, dp[i - y] + 1, dp[i - z] + 1)`
     *
     * ✅ Time Complexity: **O(N)**
     * ✅ Space Complexity: **O(N)**
     */
    public int maximizeCutsTabulation(int n, int x, int y, int z) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MIN_VALUE); // Initialize with impossible value
        dp[0] = 0; // Base case: No rod → No cuts

        for (int i = 1; i <= n; i++) {
            if (i >= x && dp[i - x] != Integer.MIN_VALUE) dp[i] = Math.max(dp[i], dp[i - x] + 1);
            if (i >= y && dp[i - y] != Integer.MIN_VALUE) dp[i] = Math.max(dp[i], dp[i - y] + 1);
            if (i >= z && dp[i - z] != Integer.MIN_VALUE) dp[i] = Math.max(dp[i], dp[i - z] + 1);
        }

        return (dp[n] < 0) ? 0 : dp[n]; // Ensure a non-negative result
    }

    /*
     * 🚀 Approach 3: Space-Optimized DP
     * - Since we only need `dp[i-x]`, `dp[i-y]`, and `dp[i-z]`, we use **1D DP array**.
     * - This reduces space complexity to **O(N)** (same as Tabulation).
     * 
     * (No further space optimization possible since we need full dp array)
     */
}
