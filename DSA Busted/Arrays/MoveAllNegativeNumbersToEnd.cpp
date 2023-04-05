
// https://practice.geeksforgeeks.org/problems/move-all-negative-elements-to-end1813/1

class Solution{
    public:
    void segregateElements(int arr[],int n)
    {
        // Your code goes here
        vector<int> newArr(n);
        int j=0;
        for(int i=0; i<n; i++){
            if(arr[i]>0){
                newArr[j]= arr[i];
                j++;
            }
        }
        for(int i=0; i<n; i++){
            if(arr[i]<0){
                newArr[j]= arr[i];
                j++;
            }
        }
        copy(newArr.begin(), newArr.end(), arr);
        arr= newArr.data();
    }
};
