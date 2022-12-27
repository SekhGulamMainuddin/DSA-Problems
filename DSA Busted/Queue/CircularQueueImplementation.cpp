
// https://leetcode.com/problems/design-circular-queue/description/

class MyCircularQueue {
    int *arr;
    int cFront=-1, cRear= -1;
    int size;
public:
    MyCircularQueue(int k) {
        size= k;
        arr= new int[size];
    }
    
    bool enQueue(int value) {
        if(isFull())
            return false;
        if(isEmpty()){
            cFront= cRear= 0;
        }
        else if(cRear<size-1){
            cRear++;
        }
        else{
            cRear= 0;
        }
        arr[cRear]= value;
        return true;
    }
    
    bool deQueue() {
        if(isEmpty())
            return false;

        arr[cFront]=-1;
        if(cFront==cRear){
            cFront= cRear= -1;
        }
        else if(cFront<size-1){
            cFront++;
        }
        else{
            cFront= 0;
        }

        return true;
    }
    
    int Front() {
        if(isEmpty())
            return -1;
        return arr[cFront];
    }
    
    int Rear() {
        if(isEmpty())
            return -1;
        return arr[cRear];
    }
    
    bool isEmpty() {
        return cFront==-1 && cRear==-1;
    }
    
    bool isFull() {
        return (cFront==0 && cRear==size-1) || (cRear==(cFront-1)%(size));
    }
};

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue* obj = new MyCircularQueue(k);
 * bool param_1 = obj->enQueue(value);
 * bool param_2 = obj->deQueue();
 * int param_3 = obj->Front();
 * int param_4 = obj->Rear();
 * bool param_5 = obj->isEmpty();
 * bool param_6 = obj->isFull();
 */