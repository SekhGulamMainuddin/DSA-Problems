package DSA45DaysArshGoyalSheet.Arrays;

// https://leetcode.com/problems/two-sum/

import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap();
        for(int i=0; i<nums.length; i++){
            int dif= target-nums[i];
            if(map.containsKey(dif)) {
                if(i!=map.get(dif)){
                    int[] ans= {i, map.get(dif)};
                    return ans;
                }
            }      
            map.put(nums[i], i);     
        }
        return new int[0];
    }
}