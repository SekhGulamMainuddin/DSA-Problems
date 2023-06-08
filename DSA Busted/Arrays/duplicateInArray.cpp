
// https://leetcode.com/problems/find-the-duplicate-number/

class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        // int x= 0;
        // for(int i=0; i<nums.size(); i++){
        //     x^= nums[i];
        // }
        // for(int i=1; i<nums.size(); i++){
        //     x^= i;
        // }
        // return x;

        // int len = nums.size();
        // for (auto num : nums) {
        //     int idx = abs(num);
        //     cout<<idx<<" "<<num<<endl;
        //     if (nums[idx] < 0) {
        //         return idx;
        //     }
        //     nums[idx] = -nums[idx];
        // }

        // return len;

        // This can be solved using binary search but it will take )(nlogn) time complexity

        int slow= nums[0];
        int fast= nums[nums[0]];

        while(slow!=fast){
            slow= nums[slow];
            fast= nums[nums[fast]];
        }

        slow= 0;
        while(slow!=fast){
            slow= nums[slow];
            fast= nums[fast];
        }
        return fast;
    }
};












