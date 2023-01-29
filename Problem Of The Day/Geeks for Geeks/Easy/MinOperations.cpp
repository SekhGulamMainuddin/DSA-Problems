
// https://practice.geeksforgeeks.org/problems/5a7e1a52f1b7796238f9efea4c6fda389f26c327/1

class Solution {
  public:
    int solve(int a, int b) 
    {
        // code here
        if(a==b)
        {
            return 0;
        }
        int x=a&b;
        if(a>x && b>x)
        {
            return 2;
        }
        return 1;
    }
};