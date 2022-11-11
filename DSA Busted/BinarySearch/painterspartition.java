
//https://www.codingninjas.com/codestudio/problems/painter-s-partition-problem_1089557

import java.util.ArrayList;

class Solution 
{
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        //    Write your code here.
        int sum= 0;
        for(int i=0; i<boards.size(); i++){
            sum+=boards.get(i);
        }

        int s=0,e=sum,mid=s+(e-s)/2;
        int ans=0;
        while(s<=e){

            if(isPossibleSolution(boards, k, mid)){
                ans=mid;
                e=mid-1;
            }else{
                s=mid+1;
            }
            mid=s+(e-s)/2;
        }
        return ans;
    }
    public static boolean isPossibleSolution(ArrayList<Integer> boards, int k, int mid){

        int painter=1;
        int boardSum=0;

        for(int i=0;i<boards.size();i++){

            if(boardSum+boards.get(i)<=mid){
                boardSum+=boards.get(i);
            }else{
                painter++;
                if(painter>k || boards.get(i)>mid){
                    return false;
                }
                boardSum=boards.get(i);
            }

        }
        return true;
    }
}
