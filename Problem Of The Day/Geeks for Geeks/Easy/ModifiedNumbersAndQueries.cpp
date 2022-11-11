
//https://practice.geeksforgeeks.org/problems/modified-numbers-and-queries0904/1

#include <bits/stdc++.h>
using namespace std;
class Solution {
  private:
    int sumOfPrimeFactors(int n){
        
        if(n==1)
            return 1;
            
        int sum=0;
        for(int i=2; i<=n; i++){
            if(n%i==0 && isPrime(i))
                sum+=i;
        }

        return sum;
    }
    
    bool isPrime(int n){
        if(n==1)
            return false;
        if(n==2)
            return true;
        for(int i=2;i<n;i++){
            if(n%i==0)
                return false;
        }
        return true;
    }
    
  public:
    int sumOfAll(int l, int r){
        // code here
        
        int sum=0;
        for(int i=l;i<=r;i++){
            sum+=sumOfPrimeFactors(i);
        }
        
        return sum;
        
    }
};

//{ Driver Code Starts.
int main() {
    int t;
    cin >> t;
    while (t--) {
        int l, r;
        cin>>l>>r;
        Solution ob;
        cout<<ob.sumOfAll(l,r)<<endl;
    }
    return 0;
}

// } Driver Code Ends