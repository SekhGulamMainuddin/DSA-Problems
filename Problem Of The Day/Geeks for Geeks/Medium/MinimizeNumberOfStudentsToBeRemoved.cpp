
// https://practice.geeksforgeeks.org/problems/7d0fa4007b8eabadc404fcc9fa917aa52982aa96/1

class Solution {
  public:
    int LIS(int H[],int n){
      vector<int>temp;
      temp.push_back(H[0]);
      for(int i=0;i<n;i++){
          if(H[i]>temp.back()){
              temp.push_back(H[i]);
          }
          else {
              int idx=lower_bound(temp.begin(),temp.end(),H[i])-temp.begin();
              temp[idx]=H[i];
          }
      }
      return temp.size();
  }
    int removeStudents(int H[], int N) {
        // code here
        int seqLen=LIS(H,N);
        return N-seqLen;
    }
};