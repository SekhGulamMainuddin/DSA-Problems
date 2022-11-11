/*
5
1 
2 3
3 4 5
4 5 6 7
5 6 7 8 9
*/

#include<iostream>
using namespace std;
int main(){
    int n;
    cin>>n;
    int i=1,j,c=1;
    while (i<=n)
    {
        j=0;
        //c=i;
        while(j<i){
            //cout<<c<<" ";
            cout<<i+j<<" ";
            //c++;
            j++;
        }
        cout<<endl;
        i++;
    }

}