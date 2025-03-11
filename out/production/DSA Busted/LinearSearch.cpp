#include<iostream>
using namespace std;

bool linearSearch(int arr[], int keyElemnent, int size){
    if(size==0)
        return false;
    if(arr[0]==keyElemnent)
        return true;

    return linearSearch(arr+1, keyElemnent, size-1);
}

int main(){
    int arr[]={2,4,5,7,8,9,444,555,2214,6641,82235,99998};
    if (linearSearch(arr,41,11))
        cout<<"Element Found";
    else 
        cout<<"Element Not Found";

    return 0;
}