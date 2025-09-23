#include<iostream>
using namespace std;
bool PalindromeString(string &str,int i){
    if(i>(str.length()-1)/2)
        return true;
    if(str[i]!=str[str.length()-i-1])
        return false;
    else
        return PalindromeString(str,i+1);
}
int main(){

    string s="aabaa";
    if(PalindromeString(s,0))
        cout<<"Palindrome String"<<endl;
    else
        cout<<"Not a Palindrome String"<<endl;

    return 0;
}