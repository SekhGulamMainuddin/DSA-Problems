
// https://leetcode.com/problems/reverse-words-in-a-string/

#include<iostream>
#include<string>
using namespace std;
string reverseWords(string s) {
    s=s+" ";
    bool first=true;
    string result="",temp="";
    char sp=' ';
    for(int i=0;i<s.size();i++){
        if(sp!=s[i]){
            if(s[i]!=' '){
                temp=temp+s[i];
                sp='_';
            }else{
                if(first){
                    first=false;
                    result=temp;
                }else{
                    result=temp+" "+result;
                }
                temp="";
                sp=' ';
            }   
        }            
    }
    return result;
}
int main(){

    string s="a good   example";

    cout<<reverseWords(s)<<endl;

    return 0;
}