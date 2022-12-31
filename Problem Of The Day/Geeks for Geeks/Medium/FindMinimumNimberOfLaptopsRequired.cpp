
// https://practice.geeksforgeeks.org/problems/af49b143a4ead583e943ca6176fbd7ea55b121ae/1

class Solution {
  public:
    int minLaptops(int N, int start[], int end[]) {
        // Code here
        sort(start, start + N);

        sort(end, end + N);

        int ans = 0;

        int free = 0;

        int j = 0;

        for(int i = 0; i < N; i++){

            while(start[i] >= end[j]){

                free++;

                j++;

            }

            if(free == 0) {

                free++;

                ans++;

            }

            free--;

        }

        return ans;
    }
};