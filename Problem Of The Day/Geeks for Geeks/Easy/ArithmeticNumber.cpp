
// https://practice.geeksforgeeks.org/problems/arithmetic-number2815/1

class Solution{
public:
    int inSequence(int A, int B, int C){
        // code here
        if(C==0)
            return A==B;
        int n= (B-A)/C + 1;
        if(n<=0)
            return 0;
        int check= A+(n-1)*C;
        return check==B;
    }
};