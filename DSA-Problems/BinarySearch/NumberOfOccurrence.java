
// https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1

class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int i = -1;
        int j = 0;
        int lb = 0;
        int ub = n-1;
        int mid = 0;
        while(lb <= ub){
            mid = ub-(ub-lb)/2;
            if(x == arr[mid]){
                i = mid;
                break;
            }
            else if(x<arr[mid]){
                ub = mid-1;
            }else{
                lb = mid+1;
            }
        }
        if(i == -1){
            return 0;
        }else{
            j = i+1;
            int count = 0;
            while((i>=0 && arr[i]==x) || (j<n && arr[j]==x)){
                if(i>=0 && arr[i]==x){
                    count++;
                    i--;
                }
                if(j<n && arr[j]==x){
                    count++;
                    j++;
                }
            }
            return count;
        }
    }
}
