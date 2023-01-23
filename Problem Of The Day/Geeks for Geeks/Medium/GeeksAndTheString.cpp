
// https://practice.geeksforgeeks.org/problems/466faca80c3e86f13880710491c634d26abd44a7/1

#include<stack>
class Solution {
  public:
    string removePair(string s) {
        stack<char> st;
        st.push(s[0]);
        for(int i=1; i<s.length(); i++){
            if(!st.empty()){
                if(st.top()!=s[i]){
                    st.push(s[i]);
                }else{
                    st.pop();
                }
            }else{
                st.push(s[i]);
            }
        }
        
        string ans= "";
        while(!st.empty()){
            ans= st.top()+ans;
            st.pop();
        }
        if(ans.length()==0)
            return "-1";
        return ans;
    }
};
