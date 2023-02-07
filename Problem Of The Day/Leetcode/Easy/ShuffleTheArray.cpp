
// https://leetcode.com/problems/shuffle-the-array/description/
// https://leetcode.com/problems/shuffle-the-array/solutions/1314638/java-c-simple-o-1-space-in-place-100-faster-efficient-explained/

class Solution {
public:
    vector<int> shuffle(vector<int>& nums, int n) {
        
        int len = nums.size();
        
        for(int i = n; i < len; i++) {
            nums[i] = (nums[i] << 10) | nums[i - n];
        }
        
        int index = 0;
        for(int i = n; i < len; i++, index += 2) {
            nums[index] = nums[i] & 1023;
            nums[index + 1] = nums[i] >> 10;
        }
        
        return nums;
        
    }
};
