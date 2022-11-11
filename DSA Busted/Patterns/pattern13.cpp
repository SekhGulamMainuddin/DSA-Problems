/*
6
A
BB
CCC
DDDD
EEEEE
FFFFFF
*/

#include<iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int i=1,j;char ch='A';
    while(i<=n){
        j=1;
        while (j<=i)
        {
            cout<<ch;
            j++;
        }
        ch++;
        cout<<endl;
        i++;

    }
}