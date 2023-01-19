
// https://practice.geeksforgeeks.org/problems/230d87552a332a2970b2092451334a007f2b0eec/1

class Solution{
    public:
    int carpetBox(int A, int B, int C, int D){
        //code here
        int step=0;
        int l1=max(A,B),b1=min(A,B),l=max(C,D),b=min(C,D);
        while(l1>l || b1>b) {
            if(l1>l && b1>b) {
                l1/=2;
            } else if(l1>l) {
                l1/=2;
            } else {
                b1/=2;
            }
            
            A=l1;
            B=b1;
            l1 = max(A,B);
            b1 = min(A,B);
            
            step++;
        }
        
        return step;
    }
};
