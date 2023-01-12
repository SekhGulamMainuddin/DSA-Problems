
// https://practice.geeksforgeeks.org/problems/6e63df6d2ebdf6408a9b364128bb1123b5b13450/1

class Solution {
  public:
    long long int minIncrements(vector<int> arr, int N) {
        // Code here
        long long int  i,j,count=0,max_val=0;
        map<int,long long >m1;
       // sort the array 
       sort(arr.begin(),arr.end());
       
       
        // to calculate the count of operation
       for(i=0;i<N;i++)
       {
           if(max_val<arr[i])
           {
               max_val=arr[i]; //update the max_val
           }
           else
           {
              max_val++;
               count+=max_val-arr[i]; // operations to increment the curr_element
               
           }
          
       }
        return count;
    }
};