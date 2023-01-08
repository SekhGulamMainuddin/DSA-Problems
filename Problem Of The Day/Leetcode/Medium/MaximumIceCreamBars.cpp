
// https://leetcode.com/problems/maximum-ice-cream-bars/description/

class Solution {
public:
    int maxIceCream(vector<int>& costs, int coins) {
        sort(begin(costs), end(costs));
        for (int i = 0; i < costs.size(); ++i)
            if (coins >= costs[i])
                coins -= costs[i];
            else
                return i;
        return costs.size();
    }
};