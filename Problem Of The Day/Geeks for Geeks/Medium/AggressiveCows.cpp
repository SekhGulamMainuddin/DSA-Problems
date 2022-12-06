
// https://practice.geeksforgeeks.org/problems/aggressive-cows/1    

//{ Driver Code Starts
// Initial Template for C++
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
// User function Template for C++

class Solution {
public:

    int solve(int n, int k, vector<int> &stalls) {
    
        // Write your code here
        
        int low = 1;
        sort(stalls.begin(), stalls.end());
        int high = stalls.back() - stalls.front();
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low)/2;
            int cnt = 1;
            int curr = stalls[0];
            for(int i = 1; i < n && cnt < k; i++){
                if(stalls[i] >= curr + mid){
                    cnt++;
                    curr = stalls[i];
                }
            }
            if(cnt < k){
                high = mid - 1;
            }
            else{
                ans = max(mid, ans);
                low = mid + 1;
            }
        }
        return ans;
    }
};

//{ Driver Code Starts.

int main() {
    int t = 1;
    cin >> t;

    // freopen ("output_gfg.txt", "w", stdout);

    while (t--) {
        // Input

        int n, k;
        cin >> n >> k;

        vector<int> stalls(n);
        for (int i = 0; i < n; i++) {
            cin >> stalls[i];
        }
        // char ch;
        // cin >> ch;

        Solution obj;
        cout << obj.solve(n, k, stalls) << endl;

        // cout << "~\n";
    }
    // fclose(stdout);

    return 0;
}
// } Driver Code Ends