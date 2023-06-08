class Solution {
public:
    void rotate(vector<int>& nums, int k) {
        // Brute Force
        // k=k%nums.size();
        // int index_value,l=nums.size();
        // vector<int> newNums(nums.size());
        // for(int i=0;i<l;i++){
        //     newNums[i]=nums[i];
        // }
        // for(int i=0;i<l;i++){

        //     index_value=(i+k)%l;
        //     nums[index_value]=newNums[i];
            
        // }

        // Better Solution
        // int n= nums.size();
        // k=k%nums.size();
        // int temp[k];
        // for(int i=0; i<k; i++){
        //     temp[i]= nums[i];
        // }
        // for(int i=0;i<n;i++){
        //     nums[i]=nums[i+k];
        // }
        // for(int i=n-d; i<n; i++){
        //     nums[i]= temp[i-(n-d)];
        // }
        
        // Best Solution
        k=k%nums.size();
        reverse(nums.begin(), nums.end()-k);
        reverse(nums.begin()+nums.size()-k, nums.end());
        reverse(nums.begin(), nums.end());
        
    }
};