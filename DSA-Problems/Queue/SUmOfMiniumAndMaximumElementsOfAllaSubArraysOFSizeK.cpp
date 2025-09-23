
// https://www.codingninjas.com/codestudio/problems/sum-of-minimum-and-maximum-elements-of-all-subarrays-of-size-k_1171047?leftPanelTab=1

#include <bits/stdc++.h> 
long long sumOfMaxAndMin(vector<int> &arr, int n, int k) {
	// Write your code here.
    deque<int> maxi(k);
    deque<int> mini(k);

    //Addition of first k size window

    for(int i=0; i<k; i++) {

        while(!maxi.empty() && arr[maxi.back()] <= arr[i])
            maxi.pop_back();

        while(!mini.empty() && arr[mini.back()] >= arr[i])
            mini.pop_back();

        maxi.push_back(i);
        mini.push_back(i);
    }
    long long ans = 0;

    ans += arr[maxi.front()] + arr[mini.front()];

    //remaining windows ko process karlo
    for(int i=k; i<n; i++) {
        //next window

        //removal
        while(!maxi.empty() && i - maxi.front() >=k) {
            maxi.pop_front();
        }

        while(!mini.empty() && i - mini.front() >=k) {
            mini.pop_front();
        }

        //addition

        while(!maxi.empty() && arr[maxi.back()] <= arr[i])
            maxi.pop_back();

        while(!mini.empty() && arr[mini.back()] >= arr[i])
            mini.pop_back();

        maxi.push_back(i);
        mini.push_back(i);    

        ans += arr[maxi.front()] + arr[mini.front()];
    }
    return ans;
}
