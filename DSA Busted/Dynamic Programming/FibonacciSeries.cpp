
// https://practice.geeksforgeeks.org/problems/nth-fibonacci-number1335/1

class Solution {
  public:

    // /*Top Down Approach DP - Recursion + Memoization*/
    // long long int findFib(long long int n, vector<long long int> &dp){
    //     if(n<=1)
    //         return n;
        
    //     if(dp[n]!=-1)
    //         return dp[n];
    //     else{
    //         dp[n]= (findFib(n-1, dp) + findFib(n-2, dp))%1000000007;
    //         return dp[n];
    //     }
    // }
  
    // long long int nthFibonacci(long long int n){
    //     // code here
    //     vector<long long int> dp(n+1, -1);
    //     return findFib(n, dp);
        
    // }
    
    // /*Bottom Up Approach*/
    // long long int nthFibonacci(long long int n){
    //     vector<long long int> dp(n+1, -1);
        
    //     dp[0]= 0;
    //     dp[1]= 1;
        
    //     for(long long int i=2; i<=n; i++){
    //         dp[i]= (dp[i-1] + dp[i-2])%1000000007;
    //     }
        
    //     return dp[n];
    // }
    
    /*Space Optimization*/
    long long int nthFibonacci(long long int n){
        long long int a= 0;
        long long int b= 1;
        long long int c= 0;
        for(long long int i=2; i<=n; i++){
            c= (a + b)%1000000007;
            a= b;
            b= c;
        }
        
        return c;
    }
    
};