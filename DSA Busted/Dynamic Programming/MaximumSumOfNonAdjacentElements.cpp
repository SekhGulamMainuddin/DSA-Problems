
// https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?leftPanelTab=1

#include <bits/stdc++.h> 
// Simple Recusive Solution
// int solve(vector<int> &nums, int n){
//     if(n==0)
//         return nums[0];
//     if(n<0)
//         return 0;
    
//     int include= solve(nums, n-2) + nums[n];
//     int exclude= solve(nums, n-1);

//     return max(include, exclude);

// }

// Recursion + Memoization (Top-Down Approach)
// int solve(vector<int> &nums, int n, vector<int> &dp){
    // if(n<0)
    //     return 0;
    // if(n==0)
    //     return nums[0];

    // if(dp[n]!=-1)
    //     return dp[n];

    // int include= solve(nums, n-2, dp) + nums[n];
    // int exclude= solve(nums, n-1, dp);

    // dp[n]= max(include, exclude);

    // return dp[n];

// }

// Tabulation Method - (Bottom-Up Approach)
// int solve(vector<int> &nums){
    
//     int n= nums.size();
//     vector<int> dp(n, 0);

//     dp[0]= nums[0];

//     for(int i=1; i<n; i++){
//         int include= dp[i-2] + nums[i];
//         int exclude= dp[i-1];
//         dp[i]= max(include, exclude);
//     }

//     return dp[n-1];

// }

// Dp with Space Optimization
int solve(vector<int> &nums){
    int n= nums.size();
    int prevOne= nums[0];
    int prevTwo= 0;

    for(int i=1; i<n; i++){
        int include= prevTwo + nums[i];
        int exclude= prevOne;
        int ans= max(include, exclude);
        prevTwo= prevOne;
        prevOne= ans;
    }

    return prevOne;
}

int maximumNonAdjacentSum(vector<int> &nums){
    // Write your code here.
    // Simple Recursive Solution
    // return solve(nums, 0);
  
    // Recursion + Memoization (Top-Down Approach)
    // int n= nums.size();
    // vector<int> dp(n, -1);
    // return solve(nums, 0, dp);

    return solve(nums);

}