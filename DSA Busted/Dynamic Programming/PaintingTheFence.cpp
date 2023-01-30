
// https://practice.geeksforgeeks.org/problems/painting-the-fence3727/1

#define MOD 1000000007
class Solution{
    public:
    
    long long add(long long a, long long b){
        return (a%MOD + b%MOD)%MOD;
    }
    
    long long mul(long long a, long long b){
        return (a%MOD * b%MOD)%MOD;
    }
    
    // Simple Recursive Solution
    // int solve(int n, int k){
    //     if(n==1)
    //         return k;
    //     if(n==2)
    //         return add(k, mul(k, k-1));
            
    //     int ans= add(mul(solve(n-2, k), k-1), mul(solve(n-1, k), k-1));
        
    //     return ans;
        
    // }
    
    // Resursion + Memoization (Top-Down Approach)
    // long long solve(int n, int k, vector<long long> &dp){
    //     if(n==1)
    //         return k;
    //     if(n==2)
    //         return add(k, mul(k, k-1));
        
    //     if(dp[n]!=-1)
    //         return dp[n];
        
    //     dp[n]= add(mul(solve(n-2, k, dp), k-1), mul(solve(n-1, k, dp), k-1));
        
    //     return dp[n];
        
    // }
    
    // Tabulation Method (Bottom-Up Approach)
    // long long solve(int n, int k){
    //     vector<long long> dp(n+1, -1);
    //     dp[1]= k;
    //     dp[2]= add(k, mul(k, k-1));

    //     for(int i=3; i<=n; i++){
    //         dp[i]= add(mul(dp[i-2], k-1), mul(dp[i-1], k-1));
    //     }
        
    //     return dp[n];
        
    // }
    
    long long solve(int n, int k){
        
        if(n==1)
            return k;
        
        long long previousTwo= k;
        long long previousOne= add(k, mul(k, k-1));
        long long curr;
        
        for(int i=3; i<=n; i++){
            curr= add(mul(previousTwo, k-1), mul(previousOne, k-1));
            previousTwo= previousOne;
            previousOne= curr;
        }
        
        return previousOne;
        
    }
    
    long long countWays(int n, int k){
        // Simple Recursive Solution
        // return solve(n, k);
        
        // Resursion + Memoization (Top-Down Approach)
        // vector<long long> dp(n+1, -1);
        // return solve(n, k, dp);
        
        // Tabulation Method (Bottom-Up Approach)
        // return solve(n, k);
        
        return solve(n, k);
        
    }
};