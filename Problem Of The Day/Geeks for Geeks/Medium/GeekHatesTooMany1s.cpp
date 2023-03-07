
// https://practice.geeksforgeeks.org/problems/07e45fe40846bc670ad2507d2c649304699768b9/1

class Solution {

  public:
    int noConseBits(int n) {
        // code here
        int ans=0;
        int i=31;
        int count=0;
        while(i>=0)
        {
            if(count<=1 && (n&(1<<i)))
            {
                ans=(ans|(1<<i));
                count++;
            }
            else
            {
                count=0;
            }
            i--;
        }
        return ans;
    }
};