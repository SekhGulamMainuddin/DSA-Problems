
// https://practice.geeksforgeeks.org/problems/palindrome-string0817/1

class Solution {
    int isPalindrome(String S) {
        // code here
        int l = S.length()-1;
        for(int i=0; i<l/2; i++){
            if(S.charAt(i)!=S.charAt(l-i)){
                return 0;
            }
        }
        return 1;
    }
};