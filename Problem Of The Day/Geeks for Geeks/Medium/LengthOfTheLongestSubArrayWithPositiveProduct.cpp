
// https://practice.geeksforgeeks.org/problems/4dfa8ba14d4c94f4d7637b6b5246782412f3aeb8/1

class Solution {
    public:
        // Function to return the length of the
        //longest subarray with ppositive product
        int maxLength(vector<int> &arr,int n){
           int i=0,j=0;
           int ans=0;
           int mx=n;
           int p=1;
           while(j<n)
           {
               p*=arr[j];
               if(p==0)
               {
                   mx=n;
                   i=j+1;
                   p=1;
               }
               else if(p<0)
               {
                   mx=min(mx,j);
                   ans=max(ans,j-mx);
                   p=-1;
               }
               else if(p>0)
               {
                  ans=max(ans,j-i+1);
                  p=1;
               }
               j++;
           }
           return ans;
        }
};