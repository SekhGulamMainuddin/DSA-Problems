
// https://leetcode.com/problems/house-robber/description/

/*
Intuition:
- The problem follows the **Maximum Non-Adjacent Sum** pattern.
- A robber cannot rob two adjacent houses, so at each house `h`, we have two choices:
  1. Rob the current house and move to `h+2`
  2. Skip the current house and move to `h+1`
- We take the maximum of both choices to get the optimal solution.

Approach:
1. **Recursive DP with Memoization (Top-Down)**
   - Try robbing or skipping each house recursively.
   - Store results in a `dp` array to avoid redundant calculations.
   - Base case: If `h >= nums.length`, return 0.
   - **Time Complexity:** O(N) (Each index is computed once)
   - **Space Complexity:** O(N) (For recursion stack and memoization array)

2. **Iterative DP with Tabulation (Bottom-Up)**
   - Create a `dp` array where `dp[h]` stores the max money robbed up to house `h`.
   - Start filling from the last house towards 0.
   - **Time Complexity:** O(N) (Iterates over all houses once)
   - **Space Complexity:** O(N) (Uses an array of size `N+1`)

3. **Space-Optimized DP**
   - Instead of using an array, maintain only two variables (`prev1` and `prev2`).
   - Update them iteratively while iterating from the last house.
   - **Time Complexity:** O(N) (Iterates over all houses once)
   - **Space Complexity:** O(1) (Uses only constant variables)
*/

import java.util.*; 

class _5HouseRobber {
    // Recursive DP with Memoization
    private int rob(int[] nums, int h, int[] dp) {
        if (h >= nums.length) return 0; // Base case

        if (dp[h] != -1) return dp[h]; // Return precomputed value

        // Include current house and move to h+2
        int include = nums[h] + rob(nums, h + 2, dp);
        // Exclude current house and move to h+1
        int exclude = rob(nums, h + 1, dp);

        // Store result in dp array
        return dp[h] = Math.max(include, exclude);
    }

    public int rob(int[] nums) {
        /*
        // Approach 1: Recursive DP with Memoization (Top-Down)
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1); // Initialize dp array with -1
        return rob(nums, 0, dp);
        */

        /*
        // Approach 2: Iterative DP with Tabulation (Bottom-Up)
        int n = nums.length;
        int[] dp = new int[n + 2]; // Extra space for handling `h+2` case

        for (int h = n - 1; h >= 0; h--) {
            int include = nums[h] + dp[h + 2]; // Include current house
            int exclude = dp[h + 1]; // Exclude current house

            dp[h] = Math.max(include, exclude); // Store the best option
        }

        return dp[0]; // Maximum amount stored at index 0
        */

        // Approach 3: Space-Optimized DP
        int n = nums.length;
        int prev2 = 0; // Corresponds to dp[h+2]
        int prev1 = 0; // Corresponds to dp[h+1]
        int curr = 0;

        for (int h = n - 1; h >= 0; h--) {
            int include = nums[h] + prev2; // Include current house
            int exclude = prev1; // Exclude current house

            curr = Math.max(include, exclude); // Store the best option

            prev2 = prev1; // Shift prev1 to prev2
            prev1 = curr; // Update prev1 to current sum
        }

        return curr; // Maximum amount stored in `curr`
    }
}
