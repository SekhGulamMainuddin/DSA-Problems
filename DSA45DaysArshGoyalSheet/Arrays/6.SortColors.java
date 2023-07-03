package DSA45DaysArshGoyalSheet.Arrays;

// https://leetcode.com/problems/sort-colors/

class Solution {
    public void sortColors(int[] nums) {
        int i=0, j=0, k=nums.length-1;

        while(i<=k){
            if(nums[i]==0){
                int temp= nums[j];
                nums[j]= nums[i];
                nums[i]= temp;
                i++;
                j++;
            }else if(nums[i]==1){
                i++;
            }else{
                int temp= nums[k];
                nums[k]= nums[i];
                nums[i]= temp;
                k--;
            }
        }

    }
}
