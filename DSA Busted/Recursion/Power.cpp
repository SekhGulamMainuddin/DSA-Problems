#include<iostream>
using namespace std;
long power(long n,long p){
    if(p==0)
        return 1;
    if (p==1)
        return n;

    long ans=power(n,p/2);
    if(p%2==0)
        return ans*ans;
    else
        return n*ans*ans;
}

int main(){

    cout<<power(2,32)<<endl;

    return 0;
}