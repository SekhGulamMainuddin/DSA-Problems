
// https://practice.geeksforgeeks.org/problems/dearrangement-of-balls0918/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

#define MOD 1000000007
class Solution{
public:
    
    // Simple Recursion
    // int solve(int n){
    //     if(n==1)
    //         return 0;
    //     if(n==2)
    //         return 1;
        
    //     int ans= ( ((n-1) % MOD) * (solve(n-1)%MOD + solve(n-2)%MOD)) % MOD;
        
    //     return ans;
    // }
    
    // Recursion + Memoization (Top-Down Approach)
    // long int solve(int n, vector<long int> &dp){
    //     if(n==1)
    //         return 0;
    //     if(n==2)
    //         return 1;
        
    //     if(dp[n]!=-1)
    //         return dp[n];
        
    //     dp[n]= ( ((n-1) % MOD) * (solve(n-1, dp)%MOD + solve(n-2, dp)%MOD)) % MOD;
        
    //     return dp[n];
    // }
    
    // Tabulation Method (Bottom-Up Approach)
    // long int solve(int n){
    //     vector<long int> dp(n+1);
    //     dp[1]= 0;
    //     dp[2]= 1;
        
    //     for(int i=3; i<=n; i++){
    //         dp[i]= (((i-1) % MOD) * (dp[i-1] % MOD + dp[i-2] % MOD)) % MOD;
    //     }
        
    //     return dp[n];
    // }
    
    long int solve(int n){
        long int prevTwo= 0;
        long int prevOne= 1;
        long int curr;
        
        for(int i=3; i<=n; i++){
            curr= (((i-1) % MOD) * (prevTwo % MOD + prevOne % MOD)) % MOD;
            prevTwo= prevOne;
            prevOne= curr;
        }
        
        return prevOne;
    }
    
    
    long int disarrange(int n){
        // Simple Recursion
        // return solve(n);
        
        // Recursion + Memoization (Top-Down Approach)
        // vector<long int> dp(n+1, -1);
        // return solve(n, dp);
        
        // Tabulation Method (Bottom-Up Approach)
        // return solve(n);
        
        return solve(n);
        
    }
};