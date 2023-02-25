
// https://practice.geeksforgeeks.org/problems/96161dfced02d544fc70c71d09b7a616fe726085/1

class Solution {
  public:
    int mod=1e9+7;

  int solve(vector<vector<int>>&v, int i, int j, vector<vector<int>>&dp){

        if(i >= 0 && j >= 0 && v[i][j]==0) return 0;

        if(i == 0 && j == 0 ) return 1;

        if(i < 0 || j < 0)  return 0;

        if(dp[i][j]!=-1) return dp[i][j];

        int left=solve(v,i,j-1,dp);

        int up=solve(v,i-1,j,dp);

        return dp[i][j]=(left+up)%mod;

  }

    int uniquePaths(int n, int m, vector<vector<int>> &grid) {

        // code here

        vector<vector<int>>dp(n+1,vector<int>(m+1,-1));

        return solve(grid,n-1,m-1,dp);

    }
};