
// https://practice.geeksforgeeks.org/problems/-rearrange-array-alternately-1587115620/1

//{ Driver Code Starts
// C++ program to rearrange an array in minimum 
// maximum form 
#include <bits/stdc++.h>
using namespace std;


// } Driver Code Ends
class Solution{
    public:
    // This function wants you to modify the given input
    // array and no need to return anything
    // arr: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    void rearrange(long long *arr, int n) 
    { 
    	
    	// Your code here
    	 int start = 0;
    	int end = n - 1;
    	vector<int>ans;
    	while(start < (n / 2) and end < n)
    	{
    	    ans.push_back(arr[end]);
    	    ans.push_back(arr[start]);
    	    start++;
    	    end--;
    	}
    	if(n % 2 == 1)
    	{
    	    int element = n / 2;
    	    ans.push_back(arr[element]);
    	}
        for(int i = 0; i < n; i++)
        {
            arr[i] = ans[i];
        }
    }
};

//{ Driver Code Starts.

// Driver program to test above function 
int main() 
{
    int t;
    
    //testcases
    cin >> t;
    
    while(t--){
        
        //size of array
        int n;
        cin >> n;
        
        long long arr[n];
        
        //adding elements to the array
        for(int i = 0;i<n;i++){
            cin >> arr[i];
        }
        
        Solution ob;
        
        //calling rearrange() function
        ob.rearrange(arr, n);
        
        //printing the elements
        for (int i = 0; i < n; i++) 
		    cout << arr[i] << " ";
		
		cout << endl;
    }
	return 0; 
} 

// } Driver Code Ends