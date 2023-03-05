
// https://practice.geeksforgeeks.org/problems/a7a4da81b20f4a05bbd93f5786fcf7478298f4f5/1

class Solution{
public:
    vector<long long int> minimumSquares(long long int L, long long int B)
    {
        long long S = __gcd(L, B); // inbuilt function in C++
        vector<long long> res = {(L*B)/(S*S), S};
        return res;
    }

};