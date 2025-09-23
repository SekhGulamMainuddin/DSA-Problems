#include<iostream>
#include<math.h>
using namespace std;
int main(){
    cout<<"Enter a binary number : ";
    long long int n;
    cin>>n;
    int digit=0,i=0;
    long long int ans=0;
    while (n!=0)
    {
        digit= n%10;
        if(digit==1){
            ans= ans+pow(2,i);
        }
        n= n/10;
        i++;
    }
    cout<<ans;

    return 0;
}