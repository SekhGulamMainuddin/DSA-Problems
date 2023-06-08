
//https://www.codingninjas.com/codestudio/problems/reverse-the-array_1262298?utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_codestudio3

import java.util.ArrayList;

class Solution 
{
    public static void reverseArray(ArrayList<Integer> arr, int m)
    {
        // Write your code here.
//         int temp=0;
//         for(int i=m+1;i<arr.size();i++){
//             for(int k=i+1;k<arr.size();k++){
//                     temp=arr.get(i);
//                     arr.set(i,arr.get(k));
//                     arr.set(k,temp);
//             }
//         }
        int temp=0;
        int s=m+1,e=arr.size()-1;
        while(s<=e){
            temp=arr.get(s);
            arr.set(s,arr.get(e));
            arr.set(e,temp);
            s++;
            e--;
        }
    }
}