#include<iostream>
using namespace std;
int main(){
    cout<<"Enter the array size : ";
    int l=0;
    cin>>l;
    int arr[l];
    for(int i=0;i<l;i++){
        cout<<"Enter the element at position "<<(i+1)<<" : ";
        cin>>arr[i];
    }
    int temp;
    for(int i=0;i<l;i+=2){
        if((i+1)<l){
            temp=arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
    }
    cout<<endl<<endl;
    for (int i = 0; i < l; i++)
    {
        cout<<arr[i]<<" ";
    }

    return 0;
}