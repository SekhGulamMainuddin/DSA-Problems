
// https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1

class Solution
{
    public:
    //Function to return max value that can be put in knapsack of capacity W.
    
    // Simple Recursive Solution
    // int solve(int wt[], int val[], int index, int capacity){
        
    //     if(index==0){
    //         if(wt[0]<=capacity)
    //             return val[0];
    //         else
    //             return 0;
    //     }
        
    //     int include= 0;
    //     if(wt[index]<=capacity)
    //         include= val[index] + solve(wt, val, index-1, capacity-wt[index]);
        
    //     int exclude= solve(wt, val, index-1, capacity);
        
    //     int ans= max(include, exclude);
        
    //     return ans;
        
    // }
    
    // Recursion + Memoization (Top-Down Approach)
    // int solve(int wt[], int val[], int index, int capacity, vector<vector<int>> &dp){
        
    //     if(index==0){
    //         if(wt[0]<=capacity)
    //             return val[0];
    //         else
    //             return 0;
    //     }
        
    //     if(dp[index][capacity]!=-1)
    //         return dp[index][capacity];
        
    //     int include= 0;
    //     if(wt[index]<=capacity)
    //         include= val[index] + solve(wt, val, index-1, capacity-wt[index], dp);
        
    //     int exclude= solve(wt, val, index-1, capacity, dp);
        
    //     dp[index][capacity]= max(include, exclude);
        
    //     return dp[index][capacity];
        
    // }
    
    // Tabulation Method (Bottom-Up Approach)
    // int solve(int wt[], int val[], int n, int capacity){
        
    //     vector<vector<int>> dp(n, vector<int>(capacity+1, 0));
        
    //     for(int w=wt[0]; w<=capacity; w++) {
    //         if(wt[0]<=capacity)
    //             dp[0][w]= val[0];
    //         else
    //             dp[0][w]= 0;
    //     }
        
    //     for(int index=1; index<n; index++){
    //         for(int w=0; w<=capacity; w++){
    //             int include= 0;
    //             if(wt[index]<=w)
    //                 include= val[index] + dp[index-1][w-wt[index]];
                
    //             int exclude= dp[index-1][w];
                
    //             dp[index][w]= max(include, exclude);
    //         }
    //     }
        
    //     return dp[n-1][capacity];
        
    // }
    
    // DP with Space Optimization
    // int solve(int wt[], int val[], int n, int capacity){
    //     vector<int> prev(capacity+1, 0);
    //     vector<int> curr(capacity+1, 0);
        
    //     for(int w=wt[0]; w<=capacity; w++) {
    //         if(wt[0]<=capacity)
    //             prev[w]= val[0];
    //         else
    //             prev[w]= 0;
    //     }
        
    //     for(int index=1; index<n; index++){
    //         for(int w=0; w<=capacity; w++){
    //             int include= 0;
    //             if(wt[index]<=w)
    //                 include= val[index] + prev[w-wt[index]];
                
    //             int exclude= prev[w];
                
    //             curr[w]= max(include, exclude);
    //         }
    //         prev= curr;
    //     }
        
    //     return prev[capacity];
        
    // }
    
    int solve(int wt[], int val[], int n, int capacity){
        vector<int> curr(capacity+1, 0);
        
        for(int w=wt[0]; w<=capacity; w++) {
            if(wt[0]<=capacity)
                curr[w]= val[0];
            else
                curr[w]= 0;
        }
        
        // Left to Right Traversal will give wrong answer because curr[index] depends on 
        // itself and a value present lower than its current index i.i. curr[w-wt[index]]
        // for(int index=1; index<n; index++){
        //     for(int w=0; w<=capacity; w++){
        //         int include= 0;
        //         if(wt[index]<=w)
        //             include= val[index] + curr[w-wt[index]];
                
        //         int exclude= curr[w];
                
        //         curr[w]= max(include, exclude);
        //     }
        // }
        
        for(int index=1; index<n; index++){
            for(int w=capacity; w>=0; w--){
                int include= 0;
                if(wt[index]<=w)
                    include= val[index] + curr[w-wt[index]];
                
                int exclude= curr[w];
                
                curr[w]= max(include, exclude);
            }
        }
        
        return curr[capacity];
        
    }
    
    int knapSack(int w, int wt[], int val[], int n) 
    { 
        // Simple Recursive Solution
        // return solve(wt, val, n-1, w);
        
        // Recursion + Memoization (Top-Down Approach)
        // vector<vector<int>> dp(n, vector<int>(w+1, -1));
        // return solve(wt, val, n-1, w, dp);
        
        return solve(wt, val, n, w);
        
    }
};