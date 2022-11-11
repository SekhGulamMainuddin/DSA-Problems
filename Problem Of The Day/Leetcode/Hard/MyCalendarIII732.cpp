
// https://leetcode.com/problems/my-calendar-iii/

class MyCalendarThree {
public:
    map<int,int>mp;
    MyCalendarThree() {   
    }
    int book(int start, int end) {
        mp[start]++;
        mp[end]--;
        int sum = 0;
        int ans = 0;
        for(auto it = mp.begin(); it != mp.end(); it++){
            sum += it->second;
            ans = max(ans,sum);
        }
        return ans;
    }
};

/**
 * Your MyCalendarThree object will be instantiated and called as such:
 * MyCalendarThree* obj = new MyCalendarThree();
 * int param_1 = obj->book(start,end);
 */