/*
6
1
22
333
4444
55555
666666
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
        while(j<=i){
            cout<<i;
            j++;
        }
        cout<<endl;
        i++;
    }

}