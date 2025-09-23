
// https://leetcode.com/problems/intersection-of-two-arrays/description/

class Solution {
public:
    vector<int> intersection(vector<int>& a, vector<int>& b) {
        int n= a.size();
        int m= b.size();
        vector<int> ans;
        unordered_map<int, bool> map;
        if(n<m){
            for(int i=0; i<n; i++){
                map[a[i]]= true;
            }
            for(int i=0; i<m; i++){
                if(map.find(b[i])!=map.end()){
                    if(map[b[i]]!=false){
                        ans.push_back(b[i]);
                    }
                    map[b[i]]= false;
                }
            }
        }else{
            for(int i=0; i<m; i++){
                map[b[i]]= true;
            }
            for(int i=0; i<n; i++){
                if(map.find(a[i])!=map.end()){
                    if(map[a[i]]!=false){
                        ans.push_back(a[i]);
                    }
                    map[a[i]]= false;
                }
            }
        }
        return ans;
    }
};