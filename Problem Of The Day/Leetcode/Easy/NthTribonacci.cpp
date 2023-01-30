
// https://leetcode.com/problems/n-th-tribonacci-number/description/

class Solution {
public:
    int tribonacci(int n) {
        if(n==0)
            return 0;
        else if(n==1 || n==2)
            return 1;
        int previousThree= 0;
        int previousTwo= 1;
        int previousOne= 1;
        int sum;

        for(int i=3; i<=n; i++){
            sum= previousThree + previousTwo + previousOne;
            previousThree= previousTwo;
            previousTwo= previousOne;
            previousOne= sum;
        }

        return previousOne;

    }
};