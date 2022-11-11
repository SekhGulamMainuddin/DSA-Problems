
// https://leetcode.com/problems/time-based-key-value-store/

class TimeMap {
public:
    TimeMap() {}
    
    void set(string key, string value, int timestamp) {
        t[key].emplace_back(timestamp);
        v[timestamp] = value;
    }
    
    string get(string key, int timestamp) {
        if(t.find(key) == end(t)) return "";
        auto ub = upper_bound(begin(t[key]), end(t[key]), timestamp);
        if(ub != begin(t[key])) return v[*(--ub)];
        return "";
    }
private:
	unordered_map<string, vector<int>> t;
	unordered_map<int, string> v;
};

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap* obj = new TimeMap();
 * obj->set(key,value,timestamp);
 * string param_2 = obj->get(key,timestamp);
 */