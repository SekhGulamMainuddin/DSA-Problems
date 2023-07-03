
// https://leetcode.com/problems/merge-sorted-array/description/

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        int l = m+n-1;
        m--;
        n--;
        while(l>=0 && m>=0 && n>=0){
            if(nums1[m]>nums2[n]){
                nums1[l]= nums1[m];
                m--;
            }else{
                nums1[l]= nums2[n];
                n--;
            }
            l--;
        }
        while(m>=0){
            nums1[l]= nums1[m];
            m--;
            l--;
        }
        while(n>=0){
            nums1[l]= nums2[n];
            n--;
            l--;
        }
    }
};