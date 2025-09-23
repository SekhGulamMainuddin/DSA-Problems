/*
4
D
CD
BCD
ABCD
*/

#include<iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int i=1,j;char ch='D';
    while(i<=n){
        j=0;
        while (j<i)
        {
            cout<<char(ch+j);
            j++;
        }
        cout<<endl;
        ch--;
        i++;
    }
}