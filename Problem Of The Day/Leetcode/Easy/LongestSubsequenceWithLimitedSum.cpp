
// https://leetcode.com/problems/longest-subsequence-with-limited-sum/description/

class Solution {
public:
    vector<int> answerQueries(vector<int> A, vector<int>& queries) {
        sort(A.begin(), A.end());
        vector<int> res;
        for (int i = 1; i < A.size(); ++i)
            A[i] += A[i - 1];
        for (int& q: queries)
            res.push_back(upper_bound(A.begin(), A.end(), q) - A.begin());
        return res;
    }
    // vector<int> answerQueries(vector<int>& nums, vector<int>& queries) 
    // {
    //     int n = nums.size();
    //     int m = queries.size();
        
    //     sort(nums.begin(),nums.end());
    //     int sum = 0;
    //     vector<int> pre_sum;
        
    //     for(int i=0;i<n;i++)
    //     {
    //         sum += nums[i];
    //         pre_sum.push_back(sum);           // storing prefix sum
    //     }
        
    //     vector<int> ans(m,0);
    //     for(int i=0;i<m;i++)
    //     {
    //         for(int j=0;j<n;j++)
    //         {
    //             if(pre_sum[j] <= queries[i]) ans[i] = j+1;          // wherever we got the max subsequence sum for i just update that
    //             else break;
    //         }
    //     }
    //     return ans;
    // }
};