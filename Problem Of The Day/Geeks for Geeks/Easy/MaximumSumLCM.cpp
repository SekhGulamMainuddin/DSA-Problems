
// https://practice.geeksforgeeks.org/problems/maximum-sum-lcm3025/1

//{ Driver Code Starts
//Initial Template for C++
#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
//User function Template for C++
class Solution {
  public:
    long long int maxSumLCM(int n) 

    {

        // code here

        long long sum=0;

        for(int i=1;i<=sqrt(n);i++){

            

            if(n%i==0){

                if(i==n/i){

                    sum=sum+i;

                }

                else{

                    sum=sum+i;

                    sum=sum+n/i;

                }

               

            }

        }

        return sum;

    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int  n;
        cin >> n ;
        Solution ob;
        cout<<ob.maxSumLCM(n)<<endl;
    }
    return 0;
}

// } Driver Code Ends