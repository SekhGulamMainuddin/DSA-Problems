
// https://practice.geeksforgeeks.org/problems/dearrangement-of-balls0918/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class _8DearrangementOfBalls {
    private static final int MOD = 1000000007;

    /*
     * 🔍 Problem Understanding:
     * - A **derangement** is a permutation where no element appears in its original position.
     * - Given `n` elements, find the **number of derangements** modulo `10^9 + 7`.
     */

    /*
     * 🧠 Intuition:
     * The idea is to use recursion as, there are n – 1 way for element 0 (this explains multiplication with n – 1). 
     * Let 0 be placed at index i. There are now two possibilities, depending on whether or not element i is placed at 0 in return. 
     * 
     * 
     * 1) i is placed at 0: This case is equivalent to solving the problem for n-2 elements as two elements have just swapped their positions.
     * 2) i is not placed at 0: This case is equivalent to solving the problem for n-1 elements as now there are n-1 elements, n-1 positions and every element has n-2 choices
     * The formula used in the solution is:
     * 
     * D(n) = (n – 1) * (D(n – 1) + D(n – 2)
     *
     */

    /*
     * 🚀 Approach 1: Simple Recursion (Brute Force)
     * - Directly use the recurrence relation.
     * - Inefficient due to **exponential time complexity**.
     *
     * ✅ Time Complexity: **O(2^N)** (Exponential)
     * ✅ Space Complexity: **O(N)** (Recursive stack)
     */
    private long solveRecursive(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;
        return ((n - 1) * (solveRecursive(n - 1) + solveRecursive(n - 2)) % MOD) % MOD;
    }

    /*
     * 🚀 Approach 2: Recursion + Memoization (Top-Down DP)
     * - Use an array (`dp[n]`) to **cache computed values** and avoid recomputation.
     *
     * ✅ Time Complexity: **O(N)** (Solving each subproblem once)
     * ✅ Space Complexity: **O(N)** (Memoization array + Recursive stack)
     */
    private long solveMemoization(int n, long[] dp) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        if (dp[n] != -1) return dp[n]; // Return precomputed result

        dp[n] = ((n - 1) * (solveMemoization(n - 1, dp) + solveMemoization(n - 2, dp)) % MOD) % MOD;
        return dp[n];
    }

    /*
     * 🚀 Approach 3: Tabulation (Bottom-Up DP)
     * - Use **iterative DP** to avoid recursion overhead.
     * - Start from **base cases (`D(1) = 0, D(2) = 1`)** and build up to `D(n)`.
     *
     * ✅ Time Complexity: **O(N)**
     * ✅ Space Complexity: **O(N)** (DP array)
     */
    private long solveTabulation(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        long[] dp = new long[n + 1];
        dp[1] = 0;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = ((i - 1) * (dp[i - 1] + dp[i - 2]) % MOD) % MOD;
        }

        return dp[n];
    }

    /*
     * 🚀 Approach 4: Space-Optimized DP
     * - Instead of storing an entire `dp[]` array, **only keep track of the last two values**.
     * - **Reduces space complexity to O(1).**
     *
     * ✅ Time Complexity: **O(N)**
     * ✅ Space Complexity: **O(1)** (Constant space)
     */
    private long solveOptimized(int n) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        long prevTwo = 0; // D(n-2)
        long prevOne = 1; // D(n-1)
        long curr = 0;

        for (int i = 3; i <= n; i++) {
            curr = ((i - 1) * (prevTwo + prevOne) % MOD) % MOD;
            prevTwo = prevOne;
            prevOne = curr;
        }

        return prevOne;
    }

    public long disarrange(int n) {
        // Simple Recursion (Exponential)
        // return solveRecursive(n);

        // Recursion + Memoization (Top-Down)
        // long[] dp = new long[n + 1];
        // Arrays.fill(dp, -1);
        // return solveMemoization(n, dp);

        // Tabulation (Bottom-Up)
        // return solveTabulation(n);

        // Space Optimized DP (Best Approach)
        return solveOptimized(n);
    }
}
