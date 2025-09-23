/*
5
ABCDE
ABCDE
ABCDE
ABCDE
ABCDE
*/

#include<iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int i=0,j;char ch='A';
    while (i<n)
    {
        j=1;
        ch='A';
        while(j<=n){
            cout<<ch;
            ch++;
            j++;
        }
        cout<<endl;
        i++;
    } 
}