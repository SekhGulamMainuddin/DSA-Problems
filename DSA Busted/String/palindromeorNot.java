
//https://www.codingninjas.com/codestudio/problems/check-if-the-string-is-a-palindrome_1062633?utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_5

class Solution {

	public static boolean checkPalindrome(String str) {

	    // WRITE YOUR CODE HERE	
        str=str.toLowerCase();
        int i=0,j=str.length()-1;
        while(i<str.length() && j>=0 && i<j){

            while(!Character.isLetterOrDigit(str.charAt(i))){
                i++;
                if(i>=str.length()){
                    return false;
                }
            }
            while(!Character.isLetterOrDigit(str.charAt(j))){
                j--;
                if(j<0){
                    return false;
                }
            }
            if(str.charAt(i)!=str.charAt(j)){
                return false;
            }else{
                i++;
                j--;
            }

        }
        return true;
	}
}