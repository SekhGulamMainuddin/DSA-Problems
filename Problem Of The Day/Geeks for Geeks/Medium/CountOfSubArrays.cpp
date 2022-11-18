
// https://practice.geeksforgeeks.org/problems/count-of-subarrays5922/1

//{ Driver Code Starts
#include <bits/stdc++.h>

using namespace std;

#define ll long long


// } Driver Code Ends
//User function template for C++
class Solution{
public:
	// #define ll long long

	ll countSubarray(int a[], int n, int k) {

     // code here

   ll c=0;

   for(int i=0,mx=0,j=0;i<n;i++)

   {

       mx=max(mx,a[i]);

       if(mx>k)

       {

           c+=((i-j+1)*(n-i));

           j=i+1;

           mx=0;

       }

   }

   return c;

 }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, k, i;
        cin >> n >> k;
        int arr[n];
        for (i = 0; i < n; i++) {
            cin >> arr[i];
        }
        Solution ob;
        auto ans = ob.countSubarray(arr, n, k);
        cout << ans << "\n";
    }
    return 0;
}
// } Driver Code Ends