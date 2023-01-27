
// https://www.codingninjas.com/codestudio/problems/count-ways-to-reach-nth-stairs_798650?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

#include <bits/stdc++.h> 
int countDistinctWays(int nStairs) {
    //  Write your code here.
    // if(nStairs<0)
    //     return 0;
    // if(nStairs==0)
    //     return 1;
    
    // return countDistinctWays(nStairs-1) + countDistinctWays(nStairs-2);

    vector<int> dp(nStairs+1, -1);
    dp[0]= 1;
    dp[1]= 1;
    for(int i=2; i<=nStairs; i++){
        dp[i]= (dp[i-1] + dp[i-2])%1000000007;
    }
    return dp[nStairs];

}