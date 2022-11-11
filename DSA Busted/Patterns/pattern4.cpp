/*
Enter the limit : 5
54321
54321
54321
54321
54321
*/


#include<iostream>
using namespace std;
int main(){
    int n;
    cout<<"Enter the limit : ";
    cin>>n;
    int i=1;int j;
    while(i<=n){
        j=1;
        while(j<=n){
            cout<<n-j+1;
            j++;
        }
        cout<<endl;
        i++;
    }
}
