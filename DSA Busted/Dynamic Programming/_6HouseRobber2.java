
import java.util.Arrays;

class _6HouseRobber2 {
    /*
     * 🔍 Problem Understanding:
     * - Given `n` houses arranged **in a circle** (first and last house are adjacent).
     * - A thief **cannot rob two consecutive houses**.
     * - Find the **maximum amount of money** that can be robbed **without triggering alarms**.
     */

    /*
     * 🧠 Intuition:
     * - Since the houses are **circular**, robbing the first house **prevents robbing the last house**.
     * - Thus, we break the problem into **two linear problems**:
     *   1️⃣ Rob houses from **index `[0, n-2]`** (excluding last house).
     *   2️⃣ Rob houses from **index `[1, n-1]`** (excluding first house).
     * - The answer is **max(result from both cases)**.
     */

    /*
     * 🚀 Approach 1: Recursive DP with Memoization (Top-Down)
     * - Use **recursion** with a **memoization array (`dp[i]`)** to store results.
     * - At every house, the thief has **two choices**:
     *   1️⃣ **Rob current house** → Move to `i+2`.
     *   2️⃣ **Skip current house** → Move to `i+1`.
     * - **Base case:** If `i > end`, return `0` (out of bounds).
     *
     * ✅ Time Complexity: **O(N)**
     * ✅ Space Complexity: **O(N)** (recursion stack + memoization array)
     */
    private int robMemo(int[] nums, int i, int end, int[] dp) {
        if (i > end) return 0; // Base case: No houses left

        if (dp[i] != -1) return dp[i]; // Return cached result

        int include = nums[i] + robMemo(nums, i + 2, end, dp); // Rob this house
        int exclude = robMemo(nums, i + 1, end, dp); // Skip this house

        return dp[i] = Math.max(include, exclude);
    }

    /*
     * 🚀 Approach 2: Iterative DP with Tabulation (Bottom-Up)
     * - Use a **DP array (`dp[i]`)** where:
     *   `dp[i] = max(dp[i-1], nums[i] + dp[i-2])`
     * - Compute results for **0 to n-2** and **1 to n-1**, and return the max.
     *
     * ✅ Time Complexity: **O(N)**
     * ✅ Space Complexity: **O(N)**
     */
    private int robTabulation(int[] nums, int start, int end) {
        int n = end - start + 1;
        if (n == 1) return nums[start]; // If only one house

        int[] dp = new int[n];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], nums[start + i] + dp[i - 2]);
        }

        return dp[n - 1]; // Max money possible
    }

    /*
     * 🚀 Approach 3: Space-Optimized DP (Best Approach)
     * - Instead of a full DP array, **only store the last two values** (`prev1` and `prev2`).
     * - Transition formula:
     *   `curr = max(nums[i] + prev2, prev1)`
     * - This reduces **space complexity to O(1)**.
     *
     * ✅ Time Complexity: **O(N)**
     * ✅ Space Complexity: **O(1)**
     */
    private int robSpaceOptimized(int[] nums, int start, int end) {
        int prev2 = 0, prev1 = 0, curr = 0;

        for (int i = start; i <= end; i++) {
            int include = nums[i] + prev2; // Rob this house
            int exclude = prev1; // Skip this house

            curr = Math.max(include, exclude); // Best choice

            prev2 = prev1;
            prev1 = curr;
        }

        return curr; // Maximum amount robbed
    }

    /*
     * 🎯 Main Function to Solve House Robber II
     * - Uses all three approaches:
     *   1️⃣ Recursive DP with Memoization
     *   2️⃣ Iterative DP with Tabulation
     *   3️⃣ Space Optimized DP (Best)
     */
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0]; // Edge case: Only one house

        // Using Recursive DP with Memoization
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);

        int memoResult = Math.max(robMemo(nums, 0, n - 2, dp1), robMemo(nums, 1, n - 1, dp2));

        // Using Iterative DP with Tabulation
        int tabResult = Math.max(robTabulation(nums, 0, n - 2), robTabulation(nums, 1, n - 1));

        // Using Space Optimized DP (Best)
        int spaceOptimizedResult = Math.max(robSpaceOptimized(nums, 0, n - 2), robSpaceOptimized(nums, 1, n - 1));

        // Returning the best result
        return spaceOptimizedResult; // Change to `memoResult` or `tabResult` if needed
    }
}