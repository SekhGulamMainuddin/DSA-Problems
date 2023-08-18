
// https://practice.geeksforgeeks.org/problems/leaders-in-an-array-1587115620/1

class Solution{
    //Function to find the leaders in the array.
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> ans = new ArrayList<Integer>();
        ans.add(arr[n-1]);
        for(int i=n-2; i>=0; i--){
            if(arr[i]<arr[i+1]){
                arr[i] = arr[i+1];
            }else{
                ans.add(arr[i]);
            }
        }
        Collections.reverse(ans);
        return ans;
        
        // T.C. -> O(n^2) and S.C. -> O(n)
        // ArrayList<Integer> ans = new ArrayList<Integer>();
        // bool flag = true;
        // for(int i=0; i<n; i++){
        //     flag = true;
        //     for(int j=i+1; j<n; j++){
        //         if(arr[i]<arr[j]){
        //             flag= false;
        //             break;
        //         }
        //     }
        //     if(flag){
        //         ans.add(arr[i]);
        //     }
        // }
        // return ans;
    }
}
