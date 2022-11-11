
//https://leetcode.com/problems/power-of-two/submissions/

class Solution {
public:
    bool isPowerOfTwo(int n) {
        int ans=1;
        for(int i=0;i<=30;i++){
            if(ans==n){
                return true;
            }
            if(ans<INT_MAX/2)
                ans=ans*2;
        }
        return false;

//         bool pow=false;
//         if(n==1)
//             return true;
//         while(n>1){
//             if(n%2==0){
//                 pow=true;
//             }
//             else{
//                 pow=false;
//                 break;
//             }
//             n=n/2;
//         }
//         return pow;
    }
};


/* //Java Solution
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1){
            return false;
        }
        for(int i=0;i<=31;i++){
            if(n==Math.pow(2,i)){
                return true;
            }
        }
        return false;
    }
}
*/