
// https://practice.geeksforgeeks.org/problems/e015cb4d3f354b035d9665e7c8a54a7aefb1901b/1

class Solution {
  public:
    int checkRedundancy(string s) {
        // code here
        stack<int> st;
        for(int i=0;i<s.length();i++){
            
            char top= s[i];
            if(top=='(' || top=='+' || top=='-' || top=='*' || top=='/')
                st.push(top);
            else{
                if(top==')'){
                    bool isRedundant= true;
                    while(st.top()!='('){
                        char ch= st.top();
                        if(ch=='+' || ch=='-' || ch=='*' || ch=='/')
                            isRedundant= false;
                        st.pop();
                    }
                    st.pop();
                    if(isRedundant==true)
                        return 1;
                }
            }
        }
        return 0;
    }
};