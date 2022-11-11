
// https://practice.geeksforgeeks.org/problems/mila-and-strings0435/1

//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++
class Solution {
  public:
   string lexicographicallySmallest(string S, int k) {

        int n = S.size();

        if(ceil(log2(n)) == floor(log2(n))) k = k/2;

        else k = k*2;

        if(k>=n) return "-1";

        stack<char> st;

        for(int i=0;i<n;i++){

            while(k>0 && !st.empty() && st.top()>S[i]){

                st.pop();k--;

            }

            st.push(S[i]);

        }

        while(k>0 && !st.empty()){

            st.pop();k--;

        }

        string ans = "";

        while(!st.empty()){

            ans += st.top();st.pop();

        }

        reverse(ans.begin(),ans.end());

        return ans;

    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        string S;
        int k;
        cin >> S >> k;
        Solution ob;
        cout << ob.lexicographicallySmallest(S, k) << endl;
    }
    return 0;
}

// } Driver Code Ends