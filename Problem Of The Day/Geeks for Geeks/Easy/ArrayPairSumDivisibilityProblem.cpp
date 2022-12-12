
// https://practice.geeksforgeeks.org/problems/array-pair-sum-divisibility-problem3257/1

//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution {
  public:
    bool canPair(vector<int> nums, int k) {
        // Code here.
        unordered_map<int,int> m;

        for(int i=0;i<nums.size();i++)

            m[nums[i]%k]++;

        if(m.find(0)!=m.end())

            if(m[0]%2!=0)   return false;

        for(auto i : m)

            if(i.first!=0 and m[i.first] != m[k-i.first])   return false;

        return true;
    }
};

//{ Driver Code Starts.
int main() {
    int tc;
    cin >> tc;
    while (tc--) {
        int n, k;
        cin >> n >> k;
        vector<int> nums(n);
        for (int i = 0; i < nums.size(); i++) cin >> nums[i];
        Solution ob;
        bool ans = ob.canPair(nums, k);
        if (ans)
            cout << "True\n";
        else
            cout << "False\n";
    }
    return 0;
}
// } Driver Code Ends