
//https://www.codingninjas.com/codestudio/problems/replace-spaces_1172172?utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_5

class Solution {
	public static StringBuilder replaceSpaces(StringBuilder str) {
		// Write your code here.

        StringBuilder s=new StringBuilder("");
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '){
                s.append("@40");
            }else{
                s.append(str.charAt(i));
            }
        }
        return s;


        // for(int i=0;i<str.length();i++){

        //     if(str.charAt(i)==' '){
        //        str.replace(i,i+1,"@40"); //str=str.subSequence(0,i)+"@40"+str.subSequence(i+1,str.length());
        //     }

        // }

        // return str;
	}
}