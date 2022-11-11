#include<iostream>
using namespace std;

bool binarySearch(int arr[],int lb,int ub, int key){

    if (ub<lb)
        return false;

    int mid=lb+(ub-lb)/2;
    if(arr[mid]==key)
        return true;
    else if(arr[mid]>key)
        binarySearch(arr,lb,mid-1,key);
    else
        binarySearch(arr,mid+1,ub,key);

}

int main(){
    int arr[]={2,4,5,7,8,9,444,555,2214,6641,82235,99998};
    if (binarySearch(arr,0,sizeof(arr)/sizeof(arr[0]),6641))
        cout<<"Element Found";
    else 
        cout<<"Element Not Found";

    return 0;
}