
// https://practice.geeksforgeeks.org/problems/wine-buying-and-selling/1

class Solution{
  public:
  long long int wineSelling(vector<int>& Arr, int N){
      //Code here.
      long long int ans = 0;

      long long int curr=0;  

      for(int i=0;i<N;i++){

          ans += abs(curr);

          curr += Arr[i];

      }

      return ans;
  }
};
