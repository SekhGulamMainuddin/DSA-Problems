package DSA45DaysArshGoyalSheet.Arrays;

// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {
        int countIndex = 0;
        int similarEle = nums[0];
        countIndex++;
        for(int i=1; i<nums.length; i++){
            if(nums[i] != similarEle){
                nums[countIndex++] = nums[i];
                similarEle = nums[i]; 
            }
        }
        return countIndex;
    }
}