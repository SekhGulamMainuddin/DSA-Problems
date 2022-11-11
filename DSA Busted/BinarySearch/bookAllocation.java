
//https://www.codingninjas.com/codestudio/problems/allocate-books_1090540

import java.util.*;

class Solution {
    public static int allocateBooks(ArrayList<Integer> arr, int n, int m) {
        // Write your code here.

        int sum = 0;
        for (int i=0;i<n;i++){
            sum+=arr.get(i);
        }

        int s=0, e=sum, mid=s+(e-s)/2;
        int ans=0;
        while(s<=e){
            if(isPossibleSolution(arr, n, m, mid)){
                ans=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
            mid=s+(e-s)/2;
        }
        return ans;
    }

    public static boolean isPossibleSolution(ArrayList<Integer> arr, int n, int m, int mid){

        int student=1;
        int pageSum=0;

        for(int i=0; i<n; i++){

            if((pageSum+arr.get(i))<=mid){
                pageSum+= arr.get(i);
            }else{
                student++;
                if(student>m || arr.get(i)>mid){
                    return false;
                }
                pageSum= arr.get(i);
            }

        }
        return true;        
    }  

}