
// https://practice.geeksforgeeks.org/problems/largest-square-formed-in-a-matrix0806/1

class Solution{
public:
    // Simple Recursive Solution
    // int solve(vector<vector<int>> &matrix, int i, int j, int &maxi){
    //     if(i>=matrix.size() || j>=matrix[0].size()){
    //         return 0;
    //     }

    //     int right= solve(matrix, i, j+1, maxi);
    //     int diagonal= solve(matrix, i+1, j+1, maxi);
    //     int down= solve(matrix, i+1, j, maxi);

    //     if(matrix[i][j]==1){
    //         int ans= 1 + min(right, min(diagonal, down));
    //         maxi= max(maxi, ans);
    //         return ans;
    //     }else{
    //         return 0;
    //     }
    // }
    
    // Recursion + Memoization (Top-Down Approach)
    // int solve(vector<vector<int>> &matrix, int i, int j, int &maxi, vector<vector<int>> &dp){
    //     if(i>=matrix.size() || j>=matrix[0].size()){
    //         return 0;
    //     }


    //     if(dp[i][j]!=-1)
    //         return dp[i][j];

    //     int right= solve(matrix, i, j+1, maxi, dp);
    //     int diagonal= solve(matrix, i+1, j+1, maxi, dp);
    //     int down= solve(matrix, i+1, j, maxi, dp);

    //     if(matrix[i][j]==1){
    //         int ans= 1 + min(right, min(diagonal, down));
    //         maxi= max(maxi, ans);
    //         dp[i][j]= ans;
    //         return dp[i][j];
    //     }else{
    //         dp[i][j]= 0;
    //         return 0;
    //     }
    // }
    
    // Tabulation Method (Bottom-Up Approach)
    // int solve(vector<vector<int>> &matrix, int &maxi){
    //     vector<vector<int>> dp(matrix.size()+1, vector<int> (matrix[0].size()+1, 0));

    //     for(int i= matrix.size()-1; i>=0; i--){
    //         for(int j= matrix[0].size()-1; j>=0; j--){
    //             int right= dp[i][j+1];
    //             int diagonal= dp[i+1][j+1];
    //             int down= dp[i+1][j];
        
    //             if(matrix[i][j]==1){
    //                 int ans= 1 + min(right, min(diagonal, down));
    //                 maxi= max(maxi, ans);
    //                 dp[i][j]= ans;
    //             }else{
    //                 dp[i][j]= 0;
    //             }
    //         }
    //     }
    //     return dp[0][0];
    // }    
    
    int solve(vector<vector<int>> &matrix, int &maxi){
        vector<int> curr(matrix[0].size()+1, 0);
        vector<int> next(matrix[0].size()+1, 0);

        for(int i= matrix.size()-1; i>=0; i--){
            for(int j= matrix[0].size()-1; j>=0; j--){
                int right= curr[j+1];
                int diagonal= next[j+1];
                int down= next[j];
        
                if(matrix[i][j]==1){
                    int ans= 1 + min(right, min(diagonal, down));
                    maxi= max(maxi, ans);
                    curr[j]= ans;
                }else{
                    curr[j]= 0;
                }
            }
            next= curr;
        }
        return next[0];
    }   

    int maxSquare(int n, int m, vector<vector<int>> mat){
        // Simple Recursive Solution
        // int maxi= 0;
        // solve(mat, 0, 0, maxi);
        // return maxi;
        
        // Recursion + Memoization (Top-Down Approach)
        // vector<vector<int>> dp(n, vector<int> (m, -1));
        // int maxi= 0;
        // solve(mat, 0, 0, maxi, dp);
        // return maxi;
        
        // Tabulation Method (Bottom-Up Approach)
        // int maxi= 0;
        // solve(mat, maxi);
        // return maxi;
        
        int maxi= 0;
        solve(mat, maxi);
        return maxi;
        
    }
};