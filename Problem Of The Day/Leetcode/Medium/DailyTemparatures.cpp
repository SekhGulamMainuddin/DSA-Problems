
// https://leetcode.com/problems/daily-temperatures/description/

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& t) {
        // support variables
        int len = t.size();
        stack<int> s;
        s.push(len - 1);
        vector<int> res(len);
        // looping from right to left, starting from the penultimate element
        for (int i = len - 2, n; i >=0; --i) {
            n = t[i];
            // removing all the indexes stacked before if they are smaller
            while (s.size() && n >= t[s.top()]) s.pop();
            // if we still have something in the stack, we update res
            if (s.size()) res[i] = s.top() - i;
            // updating the stack
            s.push(i);
        }
        return res;
    }
};