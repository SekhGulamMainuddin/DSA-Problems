
//https://www.codingninjas.com/codestudio/problems/aggressive-cows_1082559

import java.util.*;

class AggressiveCows 
{
    public static int aggressiveCows(ArrayList<Integer> stalls, int k) 
    {
        //    Write your code here.

        Collections.sort(stalls);

        int min=0;
        int max=-1;
        for(int i=0;i<stalls.size();i++){
            if(stalls.get(i)>max){
                max=stalls.get(i);
            }
        }
        int s=min, e=max, mid= s+(e-s)/2;
        int ans=0;
        while(s<=e){

            if(isPossibleSolution(stalls, k, mid)){
                ans=mid;
                s=mid+1;
            }else{
                e=mid-1;
            }
            mid=s+(e-s)/2;
        }
        return ans;
    }

    public static boolean isPossibleSolution(ArrayList<Integer> stalls, int k, int mid){

        int cowCount=1;
        int lastPosition=stalls.get(0);

        for(int i=0;i<stalls.size();i++){
            if(stalls.get(i)-lastPosition>=mid){
                lastPosition=stalls.get(i);
                cowCount++;
                if(cowCount==k){
                    return true;
                }   
            }
        }
        return false;        
    }
}