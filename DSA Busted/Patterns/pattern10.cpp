/*
5
1
21
321
4321
54321
*/

#include<iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int i=1,j;
    while(i<=n){
        j=0;
        while(j<i){
            cout<<i-j;
            j++;
        }
        cout<<endl;
        i++;
    }
}