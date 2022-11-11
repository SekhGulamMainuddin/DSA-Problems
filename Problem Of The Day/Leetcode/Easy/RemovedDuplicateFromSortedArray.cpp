
// https://leetcode.com/problems/remove-duplicates-from-sorted-array/

#include<iostream>
#include<vector>
using namespace std;
int removeDuplicates(vector<int>& nums) {
    // int count=0;
    // int temp=-101;
    // for(int i=0;i<nums.size();i++){
    //     if(nums[i]!=101){
    //         if(nums[i]!=temp){
    //             count++;
    //             temp=nums[i];
    //             cout<<count<<" is current count"<<endl;
    //         }
    //         else{
    //             nums[i]=101;
    //             for(int j=i;j<nums.size()-1;j++){
    //                 swap(nums[j],nums[j+1]);
    //             }
    //             --i;
    //         }
    //     }
    // }
    // return count;

    int i=1,j=1,temp=nums[0];
    while(j<=(nums.size()-1)){
        if(temp!=nums[j]){
            temp=nums[j];
            cout<<nums[i]<<endl;
            swap(nums[i],nums[j]);
            i++;
        }
        j++;
    }
    return i;
}
int main(){
    vector<int> nums;
    int arr[]={0,0,1,1,1,2,2,3,3,4};
    for (int i = 0; i < 10; i++)
    {
        nums.push_back(arr[i]);
    }
    removeDuplicates(nums);
    for (int i = 0; i < 10; i++)
    {
        cout<<nums[i]<<" ";
    }
    return 0;
}