#include<iostream>
#include<stack>
using namespace std;
int main(){
    string s="Microsoft";
    stack<char> st;
    for (int i = 0; i < s.length(); i++)
    {
        st.push(s[i]);
    }
    
    s="";

    while (!st.empty())
    {
        char temp= st.top();
        s= s+temp;
        st.pop();
    }
    cout<<s<<endl;

    return 0;
}