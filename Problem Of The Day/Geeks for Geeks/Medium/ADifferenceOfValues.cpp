
// https://practice.geeksforgeeks.org/problems/a-difference-of-values-and-indexes0302/1

//{ Driver Code Starts
#include <bits/stdc++.h> 
using namespace std; 



// } Driver Code Ends
class Solution{
  public:
    int maxDistance(int arr[], int n) 
    { 
        // Complete the function
        int maxi=arr[0],mini=arr[0],res=0;

        for(int i=0;i<n;i++){

           res=max(res,max(maxi-arr[i],arr[i]-mini)+i);//0 3 5

            mini=min(mini,arr[i]+i);///1 1

            maxi=max(maxi,arr[i]-i);//1 2 

        }

       return res;
    } 
};

//{ Driver Code Starts.
int main() 
{ 
	int T;
	cin>>T;
	while(T--){
	    int n;
	    cin>>n;
	    int arr[n];
	    for(int i = 0; i<n; i++)
	        cin>>arr[i];
	    Solution obj;
	    cout<<obj.maxDistance(arr, n)<<endl;
	}
} 

// } Driver Code Ends