
// https://practice.geeksforgeeks.org/problems/fda70097eb2895ecfff269849b6a8aace441947c/1

class Solution {
  public:
    int minRepeats(string A, string B) {
        // code here
        int c = 1;
        string s = A;
        while(A.length()<B.length()){
            A = A + s;
            c++;
        }
        if(A.find(B) != -1)
        {
            return c;
        }
         A = A +s;
         c++;
         if(A.find(B) != -1)
            return c;
        return -1;
    }
};