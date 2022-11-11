//https://leetcode.com/problems/find-pivot-index/submissions/

class Solution {
    public int pivotIndex(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
        }
        int rsum=sum,lsum=0;
        for(int i=0;i<nums.length;i++){
            rsum=rsum-nums[i];
            if(lsum==rsum){
                return i;
            }
            lsum=lsum+nums[i];
        }
        return -1;
    }
}