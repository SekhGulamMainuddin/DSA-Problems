
// https://leetcode.com/problems/min-cost-climbing-stairs/description/

/*
Intuition:
- You can start from either step `0` or step `1` and climb to the top.
- At each step `i`, you can take either a 1-step or 2-step jump.
- The cost to reach step `i` is `cost[i] + min(cost from (i-1), cost from (i-2))`.
- Our goal is to minimize this cost and reach beyond the last step.

Approach:
1. **Recursive DP with Memoization (Top-Down)**
   - Use recursion to compute the minimum cost for each step.
   - Memoize results in a `dp` array to avoid recomputation.
   - Base case: If `i == 0` or `i == 1`, return `cost[i]`.
   - **Time Complexity:** O(N) (Each state is computed once)
   - **Space Complexity:** O(N) (For recursion stack and memoization array)

2. **Iterative DP with Tabulation (Bottom-Up)**
   - Create a `dp` array where `dp[i]` stores the minimum cost to reach step `i`.
   - Compute iteratively using `dp[i] = cost[i] + min(dp[i-1], dp[i-2])`.
   - **Time Complexity:** O(N) (Iterates over `n` steps once)
   - **Space Complexity:** O(N) (Uses an array of size `n`)

3. **Space-Optimized DP**
   - Instead of using an array, maintain only two previous values (`prev1` and `prev2`).
   - Update them iteratively, reducing space complexity from O(N) to O(1).
   - **Time Complexity:** O(N) (Iterates over `n` steps once)
   - **Space Complexity:** O(1) (Only constant variables are used)
*/

import java.util.Arrays;

class _2MinCostClimbingStairs {
    // Recursive DP with Memoization
    private int recMinCost(int[] cost, int i, int[] dp) {
        if (i == 0 || i == 1) {
            return cost[i]; // Base cases: cost to reach step 0 or step 1
        }

        if (dp[i] != -1) {
            return dp[i]; // Return precomputed result
        }

        // Compute the minimum cost to reach step `i`
        dp[i] = cost[i] + Math.min(recMinCost(cost, i - 1, dp), recMinCost(cost, i - 2, dp));
        return dp[i];
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;

        /*
        // Approach 1: Recursive DP with Memoization (Top-Down)
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(recMinCost(cost, n - 1, dp), recMinCost(cost, n - 2, dp));
        */

        /*
        // Approach 2: Iterative DP with Tabulation (Bottom-Up)
        int[] dp = new int[n];
        dp[0] = cost[0]; // Base case: Cost of step 0
        dp[1] = cost[1]; // Base case: Cost of step 1

        for (int i = 2; i < n; i++) {
            dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
        }

        return Math.min(dp[n - 1], dp[n - 2]); // Minimum cost to reach the top
        */

        // Approach 3: Space-Optimized DP
        int prev2 = cost[0]; // Cost to reach step 0
        int prev1 = cost[1]; // Cost to reach step 1
        int curr = 0; // To store current step's cost

        for (int i = 2; i < n; i++) {
            curr = cost[i] + Math.min(prev1, prev2); // Compute min cost for step i
            prev2 = prev1; // Move prev2 to prev1
            prev1 = curr; // Move prev1 to current step
        }

        return Math.min(prev1, prev2); // Minimum cost to reach the top
    }
}
