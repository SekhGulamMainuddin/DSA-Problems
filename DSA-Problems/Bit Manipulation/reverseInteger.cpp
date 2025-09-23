//https://leetcode.com/problems/reverse-integer/submissions/

class Solution {
public:
    int reverse(int x) {
        int rv=0;
        while(x!=0){
            if(rv>(INT_MAX/10) || rv<(INT_MIN/10)){
                return 0;
            }
            rv=rv*10+x%10;
            x=x/10;
        }
        return rv;
    }
};


/* Java Solution
class Solution {
    public int reverse(int x) {
        long r=0;
        while(x!=0){
            r=(r)*10+x%10;
            x=x/10;
        }
        if(r<(Math.pow(2,31)*-1) || r>(Math.pow(2,31)-1)){
            return 0;
        }
        int s=(int)r;
        return s;
    }
}
*/