
// https://www.codingninjas.com/codestudio/problems/queue-using-array-or-singly-linked-list_2099908?leftPanelTab=1

#include <bits/stdc++.h> 
class Queue {
    int *arr;
    int qfront=0, qrear=0;
    int size;
public:
    Queue() {
        // Implement the Constructor
        size= 1000101;
        arr= new int[size];
    }

    /*----------------- Public Functions of Queue -----------------*/

    bool isEmpty() {
        // Implement the isEmpty() function
        if(qfront == qrear)
            return true;
        return false;
    }

    void enqueue(int data) {
        // Implement the enqueue() function
        if(qrear!=size){
            arr[qrear]= data;
            qrear++;
        }
    }

    int dequeue() {
        // Implement the dequeue() function
        int curr= -1;
        if(!isEmpty()){
            curr= arr[qfront];
            arr[qfront]= -1;
            if(qfront==qrear-1){
                qfront=0; qrear= 0;
            }else{
                qfront++;
            }
        }
        return curr;
    }

    int front() {
        // Implement the front() function
        if(!isEmpty())
            return arr[qfront];
        
        return -1;
    }
};