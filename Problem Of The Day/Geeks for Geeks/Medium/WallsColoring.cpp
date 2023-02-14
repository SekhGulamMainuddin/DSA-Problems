
// https://practice.geeksforgeeks.org/problems/51b266505221b97522b1d2c86ddad1868a54831b/1

class Solution{   
public:
    int minCost(vector<vector<int>> &colors, int N) {
        // Write your code here.
        for(int i=1 ; i<N ; i++){
            colors[i][0] += min(colors[i-1][1],colors[i-1][2]);
            colors[i][1] += min(colors[i-1][0],colors[i-1][2]);
            colors[i][2] += min(colors[i-1][0],colors[i-1][1]);
        }
        return min(colors[N-1][0],min(colors[N-1][1],colors[N-1][2]));
    }
};