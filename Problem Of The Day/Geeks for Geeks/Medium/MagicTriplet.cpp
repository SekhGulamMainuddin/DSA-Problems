
// https://practice.geeksforgeeks.org/problems/magic-triplets4003/1

//{ Driver Code Starts
#include<bits/stdc++.h>
using namespace std;

// } Driver Code Ends
class Solution{
	public:
	int countTriplets(vector<int>nums){
	    // Code here.
	    int right,left,L,R;

     int res=0;

     for(int i=0;i<nums.size()-1;i++){

         left=i-1;

         right=i+1;

         R=L=0;

         while(left>=0){

             if(nums[left]<nums[i]){

                 L++;

             }

             left--;

         }

         while(right<nums.size()){

             if(nums[right]>nums[i]){

                 R++;

             }

             right++;

         }

         res += (L * R);

     }

     return res;
	}
};

//{ Driver Code Starts.
int main(){
	int tc;
	cin >> tc;
	while(tc--){
		int n;
		cin >> n;
		vector<int>nums(n);
		for(int i = 0; i < n; i++)cin >> nums[i];
		Solution ob;
		int ans = ob.countTriplets(nums);
		cout << ans << "\n";
	}  
	return 0;
}
// } Driver Code Ends