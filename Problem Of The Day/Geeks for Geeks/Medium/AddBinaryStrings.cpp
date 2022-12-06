
// https://practice.geeksforgeeks.org/problems/add-binary-strings3805/1

//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;


// } Driver Code Ends
//User function template for C++
class Solution{
public:	
	string addBinary(string A, string B)
	{
	    // your code here
	    string ans;
	    int l1 = A.length();
	    int l2 = B.length();
	    int p1 = l1, p2 = l2;
	    p1--;
	    p2--;
	    int c = 0;
	    for(int i = 0; i < max(l1, l2); i++)
	    {
	        int x = 0, y = 0, z = 0 ;
	        if(p1 >= 0)
	        x = A[p1] - '0';
	        if(p2 >= 0)
	        y = B[p2] - '0';
	       // cout << x << " " << y << endl;
    	        if((x + y) == 2)
	        {
	            if(c)
	            z = 1;
	            else
	            z = 0;
	            c = 1;
	        }
	        else if((x + y) == 1)
	                {
	                    if(c){
	                    z = 0;
	                    c = 1;
	                    }
	                    else{
	                    z = 1;
	                    c = 0;
	                    }

	                }
	       else
	           {
	                    if(c)
	                    z = 1;
	                    else
	                    z = 0;
	                    c = 0;
	                    

	                }
	        ans += to_string(z);
	        p1--;
	        p2--;
	    }
	    if(c)
	    ans += '1';
	    reverse(ans.begin(), ans.end());
	    int pos = 0;
	    for(auto it : ans)
	    {
	        if(it == '1')
	        break;
	        pos++;
	    }
	    return ans.substr(pos);
	}
};

//{ Driver Code Starts.

int main()
{
	int t; cin >> t;
	while (t--)
	{
		string A, B; cin >> A >> B;
		Solution ob;
		cout << ob.addBinary (A, B);
		cout << "\n";
	}
}

// Contributed By: Pranay Bansal

// } Driver Code Ends