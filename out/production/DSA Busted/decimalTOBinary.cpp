#include<iostream>
#include<math.h>
using namespace std;
int main(){
    cout<<"Enter the decimal number : ";
    int n;
    cin>>n;
    int bit=0,i=0;
    //long long int ans=0;
    string ans="";
    while(n!=0){
        bit= n & 1;
      //  ans=bit*pow(10,i) + ans;
        ans= std::to_string(bit) + ans;
        n= n>>1;
        i++;
    }
    cout<<ans;
    return 0;
}