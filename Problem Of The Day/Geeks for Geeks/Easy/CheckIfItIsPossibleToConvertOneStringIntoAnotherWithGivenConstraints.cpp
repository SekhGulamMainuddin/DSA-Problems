
// https://practice.geeksforgeeks.org/problems/check-if-it-is-possible-to-convert-one-string-into-another-with-given-constraints4116/1

/*
Game of Observation...
Explained with images and comments.

The Question is just the game of observation . If you not clicked the correct observation ,then the question could be worst for you . In the below image do you observed something similar in both the strings . If yes then just try to solve it by yourself . 
If not getting the clue/ edge case  refer below:-

We just want to verify the order of the characters {A and B } in both strings.
Along with that we have to keep the track of the index repective to a character , so that if the sequence is like :
S= ####B
T= B####
Order is same but the S string could not be obtained due to the constraints on B {as it can move only rightwards}.
Also attaching code with comment below
*/


//{ Driver Code Starts
// Initial Template for C++

#include <bits/stdc++.h>
using namespace std;

// } Driver Code Ends
// User function Template for C++

class Solution {
  public:
   int isItPossible(string s, string t, int M, int N) {
        // code here
        int i,j,k,n=s.size(),count_A;
        char ch;
        // to maintain the order as well as indices of the char.
       vector<pair<char,int>>v1,v2; 
        for(i=0;i<n;i++)
        { 
            if(s[i]!='#')
            v1.push_back({s[i],i});
            if(t[i]!='#')
            v2.push_back({t[i],i});
          
        }
        if(v1.size()!=v2.size())
        return 0;
        for(i=0;i<v1.size();i++)
        {
          // If the order don't match
            if(v1[i].first!=v2[i].first)
            return 0;
            
            else
            {
               if(v1[i].first=='A')            
               {
                   //ex : t=##A and s=A##
                   if(v1[i].second<v2[i].second)
                   return 0;
               }
               else
               {
                   //ex : s=##B and t=B##
                   if(v1[i].second>v2[i].second)
                   return 0;
               }
            }
        }
        return 1;
    
    }
};

//{ Driver Code Starts.

int main() {
    int t;
    cin >> t;
    while (t--) {
        string S, T;
        cin >> S >> T;
        int M = S.length(), N = T.length();
        Solution ob;
        cout << ob.isItPossible(S, T, M, N);
        cout << "\n";
    }
}
// } Driver Code Ends