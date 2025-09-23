
// 

class Solution {
public:
    // Simple Recursive Solution
    // int solve(vector<int>& nums, int curr, int prev){
    //     if(curr==nums.size())
    //         return 0;
        
    //     int include= 0;
    //     if(prev==-1 || nums[curr]>nums[prev])
    //         include= 1 + solve(nums, curr+1, curr);
        
    //     int exclude= 0 + solve(nums, curr+1, prev);

    //     return max(include, exclude);
    // }

    // Recursion + Memoization (Top-Down Approach)
    // int solve(vector<int>& nums, int curr, int prev, vector<vector<int>>& dp){
    //     if(curr==nums.size())
    //         return 0;
        
    //     if(dp[curr][prev+1]!=-1)
    //         return dp[curr][prev+1];

    //     int include= 0;
    //     if(prev==-1 || nums[curr]>nums[prev])
    //         include= 1 + solve(nums, curr+1, curr, dp);
        
    //     int exclude= 0 + solve(nums, curr+1, prev, dp);

    //     dp[curr][prev+1]= max(include, exclude);

    //     return dp[curr][prev+1];
    // }

    // Tabulation Method (Bottom-Up Approach)
    // int solve(vector<int>& nums){
    //     int n= nums.size();
    //     vector<vector<int>> dp(n+1, vector<int>(n+1, 0));

    //     for(int curr= n-1; curr>=0; curr--){
    //         for(int prev= curr-1; prev>=-1; prev--){
    //             int include= 0;
    //             if(prev==-1 || nums[curr]>nums[prev])
    //                 include= 1 + dp[curr+1][curr+1];
                
    //             int exclude= 0 + dp[curr+1][prev+1];

    //             dp[curr][prev+1]= max(include, exclude);
    //         }
    //     }

    //     return dp[0][0];
    // }
    
    // Tabulation Method with O(n) Space-Complexity
    // int solve(vector<int>& nums){
    //     int n= nums.size();
    //     vector<int> current(n+1, 0);
    //     vector<int> next(n+1, 0);

    //     for(int curr= n-1; curr>=0; curr--){
    //         for(int prev= curr-1; prev>=-1; prev--){
    //             int include= 0;
    //             if(prev==-1 || nums[curr]>nums[prev])
    //                 include= 1 + next[curr+1];
                
    //             int exclude= 0 + next[prev+1];

    //             current[prev+1]= max(include, exclude);
    //         }
    //         next= current;
    //     }

    //     return next[0];
    // }

    // DP with Binary Search
    int solve(vector<int>& nums){
        if(nums.size()==0)
            return 0;

        vector<int> ans;
        ans.push_back(nums[0]);

        for(int i=1; i<nums.size(); i++){
            if(nums[i]>ans.back())
                ans.push_back(nums[i]);
            else{
                // Find the index whose element is just bigger than nums[i]
                int index= lower_bound(ans.begin(), ans.end(), nums[i]) - ans.begin();
                ans[index]= nums[i];
            }
        }
        return ans.size();
    }

    int lengthOfLIS(vector<int>& nums) {
        // Simple Recursive Solution
        // return solve(nums, 0, -1);

        // Recursion + Memoization (Top-Down Approach)
        // int n= nums.size();
        // vector<vector<int>> dp(n+1, vector<int>(n+1, -1));
        // return solve(nums, 0, -1, dp);

        return solve(nums);

    }
};











