
// https://practice.geeksforgeeks.org/problems/maximum-sub-array5443/1

//User function template for C++
class Solution{
public:
vector<int> findSubarray(int arr[], int n) {

     // code here

     pair<int,int> ans{-1,-2};

     int i=0,j=0,curr=0,res=0;

     while(i<n && j<n){

         if(arr[j]>=0){

             curr+=arr[j];

             if(curr>res || (curr==res && j-i+1>ans.second-ans.first+1)){

                 res=curr;

                 ans.first=i;

                 ans.second=j;

             }

             j++;

         }

         else{

             i=++j;

             curr=0;

         }

     }

     if(ans.first<0)

         return {-1};

     vector<int> req(arr+ans.first,arr+ans.second+1);

     return req;

 }
};