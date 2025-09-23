
//https://leetcode.com/problems/move-zeroes/

class Solution {
    public void moveZeroes(int[] nums) {
        // int i=0,j=nums.length-1,temp=0;
        // for(i=0;i<=j;i++){
        //     for(int k=i+1;k<=j;k++){
        //         if(nums[i]==0){
        //             temp=nums[i];
        //             nums[i]=nums[k];
        //             nums[k]=temp;
        //         }
        //     }
        // }

        int position=0;
        int temp;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                temp=nums[position];
                nums[position]=nums[i];
                nums[i]=temp;
                position++;
            }

        }

    }
}