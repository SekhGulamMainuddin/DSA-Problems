
// https://practice.geeksforgeeks.org/problems/214734e358208c1c6811d9b237b518f6b3c3c094/1

class Solution {
    vector<long long> v;
    stack<long long> s;
  public:
    // 108 /158
    vector<long long> nextLargerElement(vector<long long> &arr, int n){
        // Your code here
        v.resize(n);
        for(int i=n-1; i>=0; --i) {
            
            while(!s.empty() && s.top() < arr[i]) {
                s.pop();
            }
            if( s.empty() ) {
                v[i] = -1;
            }
            else {
                v[i] = s.top();
            }
            s.push(arr[i]);
        }

        // bool flag;
        // for(int i=0; i<n; ++i) {
        //     // O(N ^ 2)
        //     flag = true; 
        //     for(int j=i+1; j<n; ++j) {
        //         if(arr[i] < arr[j]) {
        //             flag = false;
        //             v.emplace_back(arr[j]);
        //             break;
        //         }
        //     }
        //     if(flag) {
        //         v.emplace_back(-1);
        //     }
        // }
        return v;
    }
};