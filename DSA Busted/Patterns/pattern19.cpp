/*
5
    1
   121
  12321
 1234321
123454321
*/

#include<iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int i=1,j;
    while (i<=n)
    {
        j=i;
        while(j<n){
            cout<<" ";
            j++;
        }
        j=1;
        while(j<=i){
            cout<<j;
            j++;
        }
        j=j-2;
        while (j>=1)
        {
            cout<<j;
            j--;
        }
        cout<<endl;
        i++;
    }
}