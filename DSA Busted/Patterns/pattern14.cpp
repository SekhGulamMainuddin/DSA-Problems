/*
5
A
BC
DEF
GHIJ
KLMNO
*/

#include<iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int i=1,j;char ch='A';
    while (i<=n)
    {
        j=1;
        while (j<=i)
        {
            cout<<ch;
            ch++;
            j++;
        }
        cout<<endl;
        i++;

    }

}