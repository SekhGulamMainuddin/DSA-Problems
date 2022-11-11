#include<iostream>
using namespace std;
void selectionSort(int *arr, int size){
    if(size<=1)
        return;

    int min = arr[0];
    int minIndex = 0;
    for (int j = 1; j <size; j++)
    {
        if (arr[j] < min)
        {
            min = arr[j];
            minIndex = j;
        }
    }
    swap(arr[0], arr[minIndex]);

    selectionSort(arr+1,size-1);

}
int main(){
    int arr[]={9,8,5,8,5,4,3,2,1};
    // int min,minIndex;
    // for(int i=0;i<9;i++){
    //     min=arr[i];
    //     minIndex=i;
    //     for(int j=i+1;j<9;j++){
    //         if(arr[j]<min){
    //             min=arr[j];
    //             minIndex=j;
    //         }
    //     }
    //     swap(arr[i],arr[minIndex]);
    // }
    selectionSort(arr,9);
    for(int i=0;i<9;i++)
        cout<<arr[i]<<" ";
    return 0;
}