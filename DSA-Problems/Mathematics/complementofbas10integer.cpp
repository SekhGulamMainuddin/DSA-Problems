
//https://leetcode.com/problems/complement-of-base-10-integer/

class Solution {
public:
    int bitwiseComplement(int n) {
        int mask=0,num=n;

        if(n==0)
            return 1;

        while(n!=0){
            n=n>>1;
            mask=(mask<<1)|1;
        }
        return (~num)&mask;
    }
};