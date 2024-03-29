
// https://practice.geeksforgeeks.org/problems/union-of-two-arrays3538/1

class Solution{
    public:
    //Function to return the count of number of elements in union of two arrays.
    int doUnion(int a[], int n, int b[], int m)  {
        //code here
        set<int> ans;
        for(int i=0; i<n; i++){
            ans.insert(a[i]);
        }
        for(int i=0; i<m; i++){
            ans.insert(b[i]);
        }
        return ans.size();
    }
};