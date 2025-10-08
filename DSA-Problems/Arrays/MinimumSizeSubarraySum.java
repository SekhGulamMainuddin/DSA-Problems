// https://leetcode.com/problems/minimum-size-subarray-sum

class MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int total = 0;
        for(int i : nums) total+=i;
        
        if(target>total) {
            return 0;
        }

        int minLength = nums.length;
        int s = 0, e = 0;
        int sum = nums[e];

        while(true) {
            if(sum>=target) {
                minLength = Math.min(minLength, e-s+1);
                sum-=nums[s];
                s++;
            } else {
                e++;
                if(e<nums.length) {
                    sum+=nums[e];
                } else {
                    break;
                }
            }
        }

        return minLength;
    }
}