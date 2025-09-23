
//https://leetcode.com/problems/rotate-array/

class Solution {
    public void rotate(int[] nums, int k) {
//         int temp,end,n=nums.length;
//         for(int i=0;i<k;i++){
//             end=nums[n-1];
//             for(int j=n-1;j>0;j--){

//                 temp=nums[j];
//                 nums[j]=nums[j-1];
//                 nums[j-1]=temp;

//             }
//             nums[0]=end;
//         }

        int index_value,l=nums.length;
        int neW[]=new int[l];
        for(int i=0;i<l;i++){
            neW[i]=nums[i];
        }
        for(int i=0;i<l;i++){

            index_value=(i+k)%l;
            nums[index_value]=neW[i];

        }

    }
}

// https://practice.geeksforgeeks.org/problems/rotate-array-by-n-elements-1587115621/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

// Using Reversal Algorithm TC - O(N) SC - O(1)
// class Solution{
//     public:
    
//     //Function to rotate an array by d elements in counter-clockwise direction. 
//     void rotateArr(int arr[], int d, int n){
//         // code here
//         // Incase rotation steps is more than length of array
//         d= d%n;
//         int i= 0, j=d-1;
//         while(i<j){
//             swap(arr[i], arr[j]);
//             i++;
//             j--;
//         }
//         i= d;
//         j= n-1;
//         while(i<j){
//             swap(arr[i], arr[j]);
//             i++;
//             j--;
//         }
//         i= 0;
//         j= n-1;
//         while(i<j){
//             swap(arr[i], arr[j]);
//             i++;
//             j--;
//         }
//     }
// };