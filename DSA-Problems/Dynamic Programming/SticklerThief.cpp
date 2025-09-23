
// https://practice.geeksforgeeks.org/problems/stickler-theif-1587115621/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

class Solution
{
    public:
    //Function to find the maximum money the thief can get.
    int FindMaxSum(int arr[], int n)
    {
        // Your code here
        int prevOne= arr[0];
        int prevTwo= 0;
        
        for(int i=1; i<n; i++){
            int include= prevTwo + arr[i];
            int exclude= prevOne;
            int ans= max(include, exclude);
            prevTwo= prevOne;
            prevOne= ans;
        }
        return prevOne;
    }
};