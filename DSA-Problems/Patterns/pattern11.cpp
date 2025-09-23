/*
5
AAAAA
BBBBB
CCCCC
DDDDD
EEEEE
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
        while (j<=n)
        {
            cout<<ch;
            j++;
        }
        ch++;
        cout<<endl;
        i++;
    }

}