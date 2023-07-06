package DSA45DaysArshGoyalSheet.Arrays;

// https://leetcode.com/problems/find-all-duplicates-in-an-array/

import java.util.*;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<Integer>();
        for(int i : nums){
            if(nums[Math.abs(i)-1]<0){
                ans.add(Math.abs(i));
            }
            nums[Math.abs(i)-1]*=-1;
        }
        return ans;
    }
}
