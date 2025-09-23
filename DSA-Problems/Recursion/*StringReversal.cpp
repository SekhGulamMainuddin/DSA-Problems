#include<iostream>
using namespace std;

void reversal(string &str,int i){
    if(i>(str.length()-1)/2)
        return;

    swap(str[i],str[str.length()-i-1]);
    i++;

    return reversal(str,i);
}

int main(){

    string s="abcd";
    reversal(s,0);
    cout<<s;

    return 0;
}