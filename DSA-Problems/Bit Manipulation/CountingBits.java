
// https://leetcode.com/problems/counting-bits/

class Solution {
    // O(nlog n)
    public int countBit(int n){
        int c = 0;
        while(n!=0){
            if(n%2==1){
                c++;
            }
            n=n/2;
        }
        return c;
    }
    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        ans[0] = 0;
        for(int i=0; i<=n; i++){
            ans[i] = ans[i/2] + i%2;
            // O(n)
            // ans[i] = countBit(i); 
            // O(nlog n)
        }
        return ans;
    }
}