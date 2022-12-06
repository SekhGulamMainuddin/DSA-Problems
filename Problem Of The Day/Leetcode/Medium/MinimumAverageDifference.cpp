
// https://leetcode.com/problems/minimum-average-difference/

#define ll long long
class Solution {
public:
    int minimumAverageDifference(vector<int>& nums) {
        ll n = nums.size();
        vector<ll> presum;
        vector<ll> postsum;

        ll curr_sum = 0;
        for(ll i=0;i<nums.size();i++){
            curr_sum += nums[i];
            presum.push_back(curr_sum);
        }

        curr_sum = presum[n-1];
        postsum.push_back(curr_sum);
        for(ll i=1;i<n;i++){
            curr_sum -= nums[i-1];
            postsum.push_back(curr_sum);
        }

        ll idx = 0;
        ll min_val = INT_MAX;

        for(ll i=0;i<n-1;i++){
            ll val = abs(presum[i]/(i+1) - postsum[i+1]/(n-i-1));
            if(min_val > val){
                min_val = val;
                idx = i;
            }
        }

        if(min_val > presum[n-1]/n){
            idx = n-1;
        }

        return idx;
    }
};