#include<iostream>
#include<queue>
using namespace std;
class Heap{
    public:
        int arr[100];
        int size;
        Heap(){
            size= 0;
        }
        void insert(int val){
            size++;
            int index= size;
            arr[size]= val;
            while(index>1){
                if(arr[index]>arr[index/2]){
                    swap(arr[index], arr[index/2]);
                    index= index/2;
                }else{
                    return;
                }
            }
        }
        void deleteFromHeap(){
            if (size==0)
            {
                cout<<"Heap is empty"<<endl;
                return;
            }
            
            arr[1]= arr[size];
            size--;

            int i= 1;
            while(i<size){
                int left= 2*i;
                int right= 2*i+1;
                if(left<=size && arr[left]>arr[1]){
                    swap(arr[left], arr[1]);
                    i= left;
                }
                else if(right<=size && arr[right]>arr[1]){
                    swap(arr[right], arr[1]);
                    i= right;
                }
                else{
                    return;
                }
            }

        }
        void print(){
            cout<<endl;
            for (int i=1; i<=size; i++)
            {
                cout<<arr[i]<<" ";
            }
            cout<<endl;
        }
};
int main(){
    Heap heap;
    heap.insert(55);
    heap.insert(54);
    heap.insert(53);
    heap.insert(50);
    heap.insert(52);
    heap.print();
    heap.deleteFromHeap();
    heap.print();

    // Max Heap
    priority_queue<int> maxHeap;
    maxHeap.push(1);
    maxHeap.push(3);
    maxHeap.push(6);
    maxHeap.push(4);
    maxHeap.push(2);
    maxHeap.push(21);

    cout<<"Max Heap "<<endl;
    while (!maxHeap.empty())
    {
        cout<<maxHeap.top()<<" ";
        maxHeap.pop();
    }

    cout<<endl;

    priority_queue<int, vector<int>, greater<int>> minHeap;
    minHeap.push(1);
    minHeap.push(3);
    minHeap.push(6);
    minHeap.push(4);
    minHeap.push(2);
    minHeap.push(21);
    

    cout<<"Min Heap "<<endl;
    while (!minHeap.empty())
    {
        cout<<minHeap.top()<<" ";
        minHeap.pop();
    }

    cout<<endl;


    return 0;
}