
// https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?leftPanelTab=1

/*
Intuition:
- Given an array, we need to find the maximum sum by selecting non-adjacent elements.
- At each index, we have two choices:
  1. Include the current element and move to `i+2`
  2. Exclude the current element and move to `i+1`
- We take the maximum of both choices to get the optimal solution.
- This problem is a variation of the **House Robber** problem.

Approach:
1. **Recursive DP with Memoization (Top-Down)**
   - Try including or excluding each element recursively.
   - Store results in a `dp` array to avoid redundant calculations.
   - Base case: If `i >= nums.size()`, return 0.
   - **Time Complexity:** O(N) (Each index is computed once)
   - **Space Complexity:** O(N) (For recursion stack and memoization array)

2. **Iterative DP with Tabulation (Bottom-Up)**
   - Create a `dp` array where `dp[i]` stores the max sum up to index `i`.
   - Start filling from the last index towards 0.
   - **Time Complexity:** O(N) (Iterates over all elements once)
   - **Space Complexity:** O(N) (Uses an array of size `N+1`)

3. **Space-Optimized DP**
   - Instead of using an array, maintain only two variables (`prev1` and `prev2`).
   - Update them iteratively while iterating from the last index.
   - **Time Complexity:** O(N) (Iterates over all elements once)
   - **Space Complexity:** O(1) (Uses only constant variables)
*/

import java.util.*; 

class _4MaximumSumOfNonAdjacentElements {
    // Recursive DP with Memoization
    private static int maxSum(ArrayList<Integer> nums, int i, int[] dp) {
        if (i >= nums.size()) return 0; // Base case

        if (dp[i] != -1) return dp[i]; // Return precomputed value

        // Include current element and move to i+2
        int include = nums.get(i) + maxSum(nums, i + 2, dp);
        // Exclude current element and move to i+1
        int exclude = maxSum(nums, i + 1, dp);

        // Store result in dp array
        return dp[i] = Math.max(include, exclude);
    }

    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        /*
        // Approach 1: Recursive DP with Memoization (Top-Down)
        int[] dp = new int[nums.size()];
        Arrays.fill(dp, -1); // Initialize dp array with -1
        return maxSum(nums, 0, dp);
        */

        /*
        // Approach 2: Iterative DP with Tabulation (Bottom-Up)
        int n = nums.size();
        int[] dp = new int[n + 2]; // Extra space for handling `i+2` case

        for (int i = n - 1; i >= 0; i--) {
            int include = nums.get(i) + dp[i + 2]; // Include current element
            int exclude = dp[i + 1]; // Exclude current element

            dp[i] = Math.max(include, exclude); // Store the best option
        }

        return dp[0]; // Maximum sum stored at index 0
        */

        // Approach 3: Space-Optimized DP
        int n = nums.size();
        int prev2 = 0; // Corresponds to dp[i+2]
        int prev1 = 0; // Corresponds to dp[i+1]
        int curr = 0;

        for (int i = n - 1; i >= 0; i--) {
            int include = nums.get(i) + prev2; // Include current element
            int exclude = prev1; // Exclude current element

            curr = Math.max(include, exclude); // Store the best option

            prev2 = prev1; // Shift prev1 to prev2
            prev1 = curr; // Update prev1 to current sum
        }

        return curr; // Maximum sum stored in `curr`
    }
}
