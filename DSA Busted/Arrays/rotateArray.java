
//https://leetcode.com/problems/rotate-array/

class Solution {
    public void rotate(int[] nums, int k) {
//         int temp,end,n=nums.length;
//         for(int i=0;i<k;i++){
//             end=nums[n-1];
//             for(int j=n-1;j>0;j--){

//                 temp=nums[j];
//                 nums[j]=nums[j-1];
//                 nums[j-1]=temp;

//             }
//             nums[0]=end;
//         }

        int index_value,l=nums.length;
        int neW[]=new int[l];
        for(int i=0;i<l;i++){
            neW[i]=nums[i];
        }
        for(int i=0;i<l;i++){

            index_value=(i+k)%l;
            nums[index_value]=neW[i];

        }

    }
}