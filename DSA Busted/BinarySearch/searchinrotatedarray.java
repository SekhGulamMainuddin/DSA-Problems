
//https://www.codingninjas.com/codestudio/problems/search-in-rotated-sorted-array_1082554?source=youtube&campaign=love_babbar_codestudio2&utm_source=youtube&utm_medium=affiliate&utm_campaign=love_babbar_codestudio2

import java.util.*;
class Solution {
    public static int findPosition(ArrayList<Integer> arr, int n, int k) {
        // Write your code here.
        int pivot= findPivot(arr,n);
        if(k>=arr.get(pivot)&& k<=arr.get(n-1)){
            return BinarySearch(arr,pivot,n-1,k);
        }else{
            return BinarySearch(arr,0,pivot-1,k);
        }
    }

    public static int findPivot(ArrayList<Integer> arr, int n){
        int lb=0,ub=n-1,mid=lb+(ub-lb)/2;
        while(lb<ub){
            if(arr.get(mid)>=arr.get(0)){
                lb=mid+1;
            }else{
                ub=mid;
            }
            mid=lb+(ub-lb)/2;
        }
        return lb;
    }

    public static int BinarySearch(ArrayList<Integer> arr, int lb, int ub,int k){
        int mid=lb+(ub-lb)/2;
        while(lb<=ub){
            if(arr.get(mid)==k){
                return mid;
            }else if(arr.get(mid)>k){
                ub=mid-1;
            }else{
                lb=mid+1;
            }
            mid=lb+(ub-lb)/2;
        }
        return -1;
    } 
}