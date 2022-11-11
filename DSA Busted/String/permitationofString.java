
// https://leetcode.com/problems/permutation-in-string/submissions/

class Solution {
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()){
            return false;
        }

        int count1[]=new int[26];
        int index;
        for(int i=0;i<s1.length();i++){
            index=s1.charAt(i)-'a';
            count1[index]++;
        }

        int i=0,window=s1.length();
        int count2[]=new int[26];

        while(i<window){
            index=s2.charAt(i)-'a';
            count2[index]++;
            i++;
        }
        if(isSame(count1,count2)){
            return true;
        }

        while(i<s2.length()){
            index=s2.charAt(i-window) - 'a';
            count2[index]--;
            index=s2.charAt(i) - 'a';
            count2[index]++;
            if(isSame(count1,count2)){
                return true;
            }
            i++;

        }
        return false;

    }

    public static boolean isSame(int count1[], int count2[]){

        for(int i=0;i<26;i++){

            if(count1[i]!=count2[i])
                return false;
        }
        return true;
    }
}