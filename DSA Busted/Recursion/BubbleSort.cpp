#include<iostream>
using namespace std;
void bubbleSort(int *arr,int size){
    if(size<=1)
        return;
    for(int j=0;j<size-1;j++){
            if(arr[j]>arr[j+1])
                swap(arr[j],arr[j+1]);
    }

    return bubbleSort(arr,size-1);
}
int main(){
    int arr[]={9,8,7,6,5,4,3,2,1};
    // for(int i=0;i<7;i++){
    //     for(int j=0;j<7-i;j++){
    //         if(arr[j]>arr[j+1])
    //             swap(arr[j],arr[j+1]);
    //     }
    // }
    bubbleSort(arr,9);
    for(int i=0;i<9;i++)
        cout<<arr[i]<<" ";

    return 0;
}