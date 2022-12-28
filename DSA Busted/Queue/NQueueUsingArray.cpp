
// https://www.codingninjas.com/codestudio/problems/n-queue-using-array_1170053?leftPanelTab=0

#include <bits/stdc++.h> 
class NQueue{
    int *arr;
    int *front;
    int *rear;
    int *next;
    int arrSize, nQueue;
    int freeSpace;
public:
    // Initialize your data structure.
    NQueue(int n, int s){
        // Write your code here.
        nQueue= n;
        arrSize= s;
        arr= new int[arrSize];
        front= new int[nQueue];
        rear= new int[nQueue];
        next= new int[arrSize];
        freeSpace= 0;
        
        for(int i=0; i<arrSize; i++)
            next[i]= i+1;
        next[arrSize-1]= -1;
        
        for(int i=0; i<nQueue; i++){
            front[i]= -1;
            rear[i]= -1;
        }
        
    }

    // Enqueues 'X' into the Mth queue. Returns true if it gets pushed into the queue, and false otherwise.
    bool enqueue(int x, int m){
        // Write your code here.
        if(freeSpace==-1)
            return false;
        
        //Get freespace
        int index= freeSpace;
        
        //update next free space
        freeSpace= next[index];
        
        //store the value
        arr[index]= x;
        
        //update front if 1st Element
        if(front[m-1]==-1){
            front[m-1]= index;
        }
        else{
            next[rear[m-1]]= index;
        }
        
        //update the rear
        rear[m-1]= index;
        next[index]= -1;
        
        return true;
    }

    // Dequeues top element from Mth queue. Returns -1 if the queue is empty, otherwise returns the popped element.
    int dequeue(int m){
        // Write your code here.
        if(front[m-1]==-1)
            return -1;
        
        //Extract the index
        int index= front[m-1];
        int val = arr[index];
        
        //Update the front
        front[m-1]= next[index];
        
        //Update the freespace
        next[index]= freeSpace;
        freeSpace= index;
        
        return val;
    }
};









