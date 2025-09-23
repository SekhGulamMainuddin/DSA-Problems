
// https://leetcode.com/problems/maximal-network-rank/

class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {

        // TC: O(n^2) and SC: O(n^2)
        int[] count = new int[n];
        int[][] directRoad = new int[n][n];

        for(int[] road : roads){
            count[road[0]]++;
            count[road[1]]++;
            directRoad[road[0]][road[1]] = 1;
            directRoad[road[1]][road[0]] = 1;
        }

        int rank = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                rank = Math.max(rank, count[i] + count[j] - directRoad[i][j]);
            }
        }
        return rank;

        // Brute Force Approach with TC: O(n^3) and SC: O(1)
        // int rank = 0;
        // for (int i = 0; i < n; i++) {
        //     for (int j = i + 1; j < n; j++) {
        //         int count = 0;
        //         for (int[] road : roads) {
        //             // this is where similar road is skipped
        //             if (road[0] == i || road[0] == j || road[1] == i || road[1] == j)
        //                 count++;
        //         }
        //         rank = Math.max(rank, count);
        //     }
        // }
        // return rank;
        
    }
}