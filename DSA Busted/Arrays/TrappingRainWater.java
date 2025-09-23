
// https://leetcode.com/problems/trapping-rain-water/

/**
 * Trapping Rain Water Problem
 *
 * Problem: Given an array `height` where each element represents the elevation map
 * (the height of bars), compute how much water can be trapped between the bars.
 *
 * Approach: Two-pointer technique
 *
 * Key Idea:
 * - Water trapped at a position depends on the *minimum* of the highest bars
 *   to its left and right, minus the height of the bar at that position.
 * - Instead of precomputing leftMax[] and rightMax[] arrays, we can use two pointers:
 *   - One pointer starting from the left (l)
 *   - One pointer starting from the right (r)
 * - Maintain two running values:
 *   - leftMax → maximum height encountered so far from the left side
 *   - rightMax → maximum height encountered so far from the right side
 *
 * Steps:
 * 1. Compare heights at both pointers (height[l] vs height[r]).
 * 2. If left bar is shorter (height[l] <= height[r]):
 *    - If height[l] is greater than leftMax → update leftMax
 *    - Else → water can be trapped = leftMax - height[l]
 *    - Move left pointer forward.
 * 3. Else (right bar is shorter):
 *    - If height[r] is greater than rightMax → update rightMax
 *    - Else → water can be trapped = rightMax - height[r]
 *    - Move right pointer backward.
 * 4. Repeat until l and r meet.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1) (no extra arrays used)
 */

class TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        
        // Edge case: if less than 3 bars, no water can be trapped
        if (n < 3) return 0;
        
        int l = 0, r = n - 1; // Two pointers
        int leftMax = 0, rightMax = 0; // Track maximum heights seen so far
        int totalWater = 0; // Final answer
        
        // Process until both pointers meet
        while (l < r) {
            int left = height[l];
            int right = height[r];
            
            // If left bar is smaller or equal
            if (left <= right) {
                if (left > leftMax) {
                    // Update left maximum
                    leftMax = left;
                } else {
                    // Water trapped at current left position
                    totalWater += leftMax - left;
                }
                l++; // Move left pointer
            } else {
                // If right bar is smaller
                if (right > rightMax) {
                    // Update right maximum
                    rightMax = right;
                } else {
                    // Water trapped at current right position
                    totalWater += rightMax - right;
                }
                r--; // Move right pointer
            }
        }
        
        return totalWater;
    }
}

// TC: O(n*n) and SC: O(n)
class _TrappingRainWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] trappedWater = new int[n];
        int[] prevHighest = new int[]{height[0], 0};

        for(int i=1; i<n; i++) {
            int currentMaxHeight = prevHighest[0];
            int index = prevHighest[1];
            if(height[i]>=currentMaxHeight) {
                for(int j=index+1; j<i; j++) {
                    trappedWater[j] = Math.max(trappedWater[j], Math.min(height[i], currentMaxHeight)-height[j]);
                }
                prevHighest[0] = height[i];
                prevHighest[1] = i;
            }
        }

        prevHighest[0] = height[n-1];
        prevHighest[1] = n-1;
        for(int i=n-2; i>=0; i--) {
            int currentMaxHeight = prevHighest[0];
            int index = prevHighest[1];
            if(height[i]>currentMaxHeight) {
                for(int j=i+1; j<index; j++) {
                    trappedWater[j] = Math.max(trappedWater[j], Math.min(height[i], currentMaxHeight)-height[j]);
                }
                prevHighest[0] = height[i];
                prevHighest[1] = i;
            }
        }

        int totalTrappedWater = 0;
        for(int t : trappedWater) {
            totalTrappedWater += t;
        }
        return totalTrappedWater;
    }
}
