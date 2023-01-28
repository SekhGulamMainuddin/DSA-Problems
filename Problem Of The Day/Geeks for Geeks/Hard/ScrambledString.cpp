
// https://practice.geeksforgeeks.org/problems/scrambled-string/1

class Solution{
    public:
    bool isScramble(string S1, string S2){
        //code here
        if (S1.length() != S2.length()) return false;
        if (S1 == S2) return true;
        int n = S1.length();
        bool dp[n][n][n+1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (S1[i] == S2[j]) dp[i][j][1] = true;
                else dp[i][j][1] = false;
            }
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    dp[i][j][len] = false;
                    for (int k = 1; k < len; k++) {
                        if (dp[i][j][k] && dp[i+k][j+k][len-k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                        if (dp[i][j+len-k][k] && dp[i+k][j][len-k]) {
                            dp[i][j][len] = true;
                            break;
                        }
                    }
                }
            }
        }
        return dp[0][0][n];
    }    
};
