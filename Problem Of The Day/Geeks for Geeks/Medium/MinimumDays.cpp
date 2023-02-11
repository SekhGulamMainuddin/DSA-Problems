
// https://practice.geeksforgeeks.org/problems/f4d22b1f9d62e8bee0ff84e9fa51dc66eb5005ec/1

class Solution {
  public:
    int getMinimumDays(int N,string S, vector<int> &P) {
        // code here
        int ans=0;
        for(int i=0;i<N;i++) {
            int idx = P[i];
                 if((idx>0 and S[idx]==S[idx-1]) || (idx+1<N and S[idx]==S[idx+1])) {
                    S[idx]='?';
                    ans = i+1;
                }
        }
        return ans;
    }
};