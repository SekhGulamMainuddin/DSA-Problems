/*
6
123456654321
12345**54321
1234****4321
123******321
12********21
1**********1
*/

#include<iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int i=1,j;
    while (i<=n)
    {
        j=1;
        while(j<=(n-i+1)){
            cout<<j;
            j++;
        }
        j=1;
        while(j<=(i-1)*2){
            cout<<"*";
            j++;
        }
        j=n-i+1;
        while(j>=1){
            cout<<j;
            j--;
        }
        cout<<endl;
        i++;
    }

}