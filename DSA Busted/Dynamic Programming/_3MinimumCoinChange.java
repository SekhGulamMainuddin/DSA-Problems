
// https://leetcode.com/problems/coin-change/

/*
Intuition:
- Given a set of coins and a target amount, we need to find the minimum number of coins to make up that amount.
- If it’s impossible to make the amount with the given coins, return -1.
- We can solve this using **Dynamic Programming**, by either:
  1. Recursively checking all possible ways with **memoization (Top-Down)**
  2. Using an **iterative DP (Bottom-Up) approach** to build the solution iteratively.

Approach:
1. **Recursive DP with Memoization (Top-Down)**
   - Try subtracting each coin from the amount and recursively find the minimum number of coins required.
   - Memoize results in a `dp` array to avoid redundant calculations.
   - Base cases:
     - If `amount < 0`, return `-1` (invalid case).
     - If `amount == 0`, return `0` (no coins needed).
   - **Time Complexity:** O(N * amount) (since each amount is computed once for all coins)
   - **Space Complexity:** O(amount) (for recursion stack and memoization array)

2. **Iterative DP with Tabulation (Bottom-Up)**
   - Create a `dp` array where `dp[i]` stores the minimum number of coins needed for amount `i`.
   - Initialize `dp[i] = Integer.MAX_VALUE` (since we aim to find the minimum).
   - Iterate over each coin and update `dp[i] = min(dp[i], 1 + dp[i - coin])`.
   - If `dp[amount]` remains `Integer.MAX_VALUE`, return `-1`.
   - **Time Complexity:** O(N * amount) (nested loop iterating over `amount` and `coins`)
   - **Space Complexity:** O(amount) (single DP array)
*/

import java.util.Arrays;

class _3MinimumCoinChange {
    // Recursive DP with Memoization
    private int coinChange(int[] coins, int amount, int[] dp) {
        if (amount < 0) return -1; // Invalid case
        if (amount == 0) return 0; // Base case: No coins needed

        if (dp[amount] != -2) return dp[amount]; // Return precomputed value

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int result = coinChange(coins, amount - coin, dp);

            if (result != -1) {
                minCoins = Math.min(result + 1, minCoins);
            }
        }

        dp[amount] = (minCoins == Integer.MAX_VALUE) ? -1 : minCoins; // Store result
        return dp[amount];
    }

    public int coinChange(int[] coins, int amount) {
        /*
        // Approach 1: Recursive DP with Memoization (Top-Down)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, -2); // Initialize with -2 (uncomputed state)
        return coinChange(coins, amount, dp);
        */

        // Approach 2: Iterative DP with Tabulation (Bottom-Up)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE); // Initialize with a large value

        dp[0] = 0; // Base case: 0 coins needed for amount 0

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0 && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(1 + dp[i - coin], dp[i]);
                }
            }
        }

        return (dp[amount] == Integer.MAX_VALUE) ? -1 : dp[amount]; // Return result
    }
}
