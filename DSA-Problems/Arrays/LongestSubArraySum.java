
// https://www.geeksforgeeks.org/problems/longest-sub-array-with-sum-k0809/1


class Solution {
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr(int A[], int N, int K) {
        // Brute force
        // int largestSubArraySum = 0;
        // for(int i=0; i<N; i++) {
        //     int sum = 0;
        //     for(int j=i; j<N; j++) {
        //         sum += A[j];
        //         if(sum == K) {
        //             largestSubArraySum = Math.max(largestSubArraySum, j-i+1);
        //         }
        //     }
        // }
        // return largestSubArraySum;
        
        // Prefix Sum using HashMap
        HashMap<Integer, Integer> prefixMap = new HashMap<>();
        int maxSubArrayLength = 0;
        int sum = 0;
        for(int i=0; i<N; i++) {
            sum += A[i];
            int prefix = sum - K;
            if(sum == K) {
                maxSubArrayLength = Math.max(maxSubArrayLength, i+1);
            }
            
            if(prefixMap.containsKey(prefix)) {
                maxSubArrayLength = Math.max(maxSubArrayLength, i-prefixMap.get(prefix));
            }
            
            if(!prefixMap.containsKey(sum)) {
                prefixMap.put(sum, i);
            }
        }
        return maxSubArrayLength;
    }
}