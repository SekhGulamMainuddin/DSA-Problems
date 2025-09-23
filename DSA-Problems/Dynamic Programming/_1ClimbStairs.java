
// https://leetcode.com/problems/climbing-stairs

/*
Intuition:
The problem follows the Fibonacci pattern, where the number of ways to reach step 'n' is the sum of ways to reach 'n-1' and 'n-2' steps.
This is because, at any step, we can either take a 1-step jump or a 2-step jump.

Approach:
1. **Recursive DP (Top-Down Memoization)**
   - Use recursion with memoization to avoid redundant calculations.
   - Base case: If 'n' is 0, return 1 (1 way to stay on the ground); if 'n' is negative, return 0.
   - Store results in an array `dp` to avoid recomputation.
   - **Time Complexity:** O(N) (Each state is computed once)
   - **Space Complexity:** O(N) (For recursion stack and memoization array)
   
2. **Iterative DP (Bottom-Up Tabulation)**
   - Create a `dp` array where `dp[i]` stores the number of ways to reach step `i`.
   - Use the relation `dp[i] = dp[i-1] + dp[i-2]`.
   - This avoids recursion overhead.
   - **Time Complexity:** O(N) (Iterates over 'n' steps once)
   - **Space Complexity:** O(N) (Uses an array of size `n+1`)

3. **Space-Optimized DP**
   - Instead of using an array, maintain only two previous values (`prev1` and `prev2`).
   - Update them iteratively, reducing space complexity from O(N) to O(1).
   - **Time Complexity:** O(N) (Iterates over 'n' steps once)
   - **Space Complexity:** O(1) (Only constant variables are used)
*/

class _1ClimbStairs {
    // Recursive DP with Memoization
    private int climbStairs(int n, int[] dp) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        // If result already computed, return stored value
        if (dp[n] != -1) return dp[n];

        // Store the computed value in dp array
        return dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp);
    }

    public int climbStairs(int n) {
        /*
        // Recursive DP
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return climbStairs(n, dp);
        */

        /*
        // Iterative DP (Tabulation)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        
        return dp[n];
        */

        // Space Optimized DP
        if (n == 1) return 1; // Edge case
        
        int prev2 = 1; // Base case: 1 way to reach step 0
        int prev1 = 1; // Base case: 1 way to reach step 1
        int curr = 1; // To store current step's value

        for (int i = 2; i <= n; i++) {
            curr = prev2 + prev1; // Current step count is sum of last two steps
            prev2 = prev1; // Move prev2 to prev1
            prev1 = curr; // Move prev1 to current step
        }

        return curr;
    }
}