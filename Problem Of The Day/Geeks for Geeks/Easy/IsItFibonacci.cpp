
// https://practice.geeksforgeeks.org/problems/202d95ecdeec659401edc63dd952b1d37b989ab8/1

class Solution {
  public:
    long long solve(int N, int K, vector<long long> GeekNum) {
        // code here
        if(N<=GeekNum.size()) return GeekNum[N-1];

        long long leftSum=0,rightSum=accumulate(GeekNum.begin(),GeekNum.end(),0);

        long long leftInd=0,rightInd;

        for(int rightInd=GeekNum.size();rightInd<=N;rightInd++)

        {

            //rightSum-leftSum=sum of the window

            GeekNum.push_back(rightSum-leftSum);

            //increment rightSum by adding newly created number

            rightSum+=GeekNum[rightInd];

            //increment left by 1 and also increment leftSum

            leftSum+=GeekNum[leftInd++];

        }

        return GeekNum[N-1];
    }
};