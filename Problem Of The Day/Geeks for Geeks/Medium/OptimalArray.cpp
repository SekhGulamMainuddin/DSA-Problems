
// https://practice.geeksforgeeks.org/problems/d4aeef538e6dd3280dda5f8ed7964727fdc7075f/1

class Solution{
public:
    vector<int> optimalArray(int n,vector<int> &a){
        // Code here
        vector<int>p(n,0);
    
        p[0] = 0;
    
        for(int i=1;i<n;i++){
    
            int index = i/2;
    
            p[i] = p[i-1]+(a[i] - a[i/2]);
    
        }
    
        return p;
    }
};