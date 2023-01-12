
// https://practice.geeksforgeeks.org/problems/e0059183c88ab680b2f73f7d809fb8056fe9dc43/1

/*
Simple C++ Solution.......

Step 1 - Find the remainder for all the elements, when divide by K.

Suppose (a-b) is divisible by K, that means a%k = b%k. Because (a-b) is divisible by K,

So, (a-b)%k = 0.

a%k - b%k = 0.

a%k = b%k. (Proved).

Step 2 - Store the frequency of remainders in the map.

Step 3 - Now, select any two elements from the same frequency. (i.e if frequency of any remainder is P, then total pair will be (P*(P-1))/2.

Step 4 - Finally Return ans.

 
*/

class Solution {

  public:

    long long countPairs(int n, int arr[], int k) {

        map<int, int>mp;

        for(int i=0; i<n; i++){

            arr[i]=arr[i]%k;

            mp[arr[i]]++;

        }

        long long ans=0;

        for(auto it:mp)

        ans+=(it.second*(it.second-1))/2;

        return ans;

    }

};