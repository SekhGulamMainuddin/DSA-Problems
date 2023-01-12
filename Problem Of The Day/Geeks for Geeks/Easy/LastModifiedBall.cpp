
// https://practice.geeksforgeeks.org/problems/33af95e5935f1f2a0c3f5083c4b9d0db68e97bd4/1

class Solution {
  public:
    int solve(int N, vector<int> A) {
        // code here
        for(int i=N-1;i>=0;i--){
            if(A[i]<9)
               return i+1;
        }
        
        return 0;
    }
};