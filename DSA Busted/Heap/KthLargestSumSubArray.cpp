
// https://www.codingninjas.com/codestudio/problems/k-th-largest-sum-contiguous-subarray_920398?leftPanelTab=1&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbar

#include<algorithm>
#include<queue>
int getKthLargest(vector<int> &arr, int k)
{
//     vector<int> subArraySums;
    priority_queue<int, vector<int>, greater<int>> subArraySums;
    
    for(int i=0; i<arr.size(); i++){
        int sum= 0;
        for(int j=i; j<arr.size(); j++){
            sum+= arr[j];
//             subArraySums.push_back(sum);
            if(subArraySums.size()<k){
                subArraySums.push(sum);
            }else{
                if(sum>subArraySums.top()){
                    subArraySums.pop();
                    subArraySums.push(sum);
                }
            }
        }
    }
    
//     sort(subArraySums.begin(), subArraySums.end());
//     return subArraySums[subArraySums.size()-k];
    
    return subArraySums.top();
}