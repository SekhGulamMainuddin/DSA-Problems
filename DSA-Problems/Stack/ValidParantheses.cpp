
// https://leetcode.com/problems/valid-parentheses/description/

class Solution {
public:
    bool isValid(string s) {
        stack<char> st;
        for(int i=0;i<s.length();i++){
            if(st.empty()){
                st.push(s[i]);
                continue;
            }
            char t= st.top();
            if(t=='(' && s[i]==')')
                st.pop();
            else if(t=='[' && s[i]==']')
                st.pop();
            else if(t=='{' && s[i]=='}')
                st.pop();
            else
                st.push(s[i]);
        }
        return st.empty();
    }
};