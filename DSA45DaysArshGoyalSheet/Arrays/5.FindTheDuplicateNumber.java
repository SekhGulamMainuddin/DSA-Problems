package DSA45DaysArshGoyalSheet.Arrays;

// https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[nums[0]];
        while(fast!=slow){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        slow = 0;
        while(fast!=slow){
            slow= nums[slow];
            fast= nums[fast];
        }

        return fast;
    }
}