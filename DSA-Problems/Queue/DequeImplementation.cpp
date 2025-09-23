
// https://leetcode.com/problems/design-circular-deque/description/

class MyCircularDeque {
    int *arr;
    int dFront= -1, dRear= -1;
    int size;
public:
    MyCircularDeque(int k) {
        size= k;
        arr= new int[size];
    }
    
    bool insertFront(int value) {
        if(isFull())
            return false;
        if(isEmpty()){
            dFront= dRear= 0;
        }
        else if(dFront>0){
            dFront--;
        }
        else{
            dFront= size-1;
        }
        arr[dFront]= value;
        return true;
    }
    
    bool insertLast(int value) {
        if(isFull())
            return false;
        if(isEmpty()){
            dFront= dRear= 0;
        }
        else if(dRear<size-1){
            dRear++;
        }
        else{
            dRear= 0;
        }
        arr[dRear]= value;
        return true;
    }
    
    bool deleteFront() {
        if(isEmpty())
            return false;

        arr[dFront]= -1;
        if(dFront==dRear){
            dFront= dRear= -1;
        }
        else if(dFront<size-1){
            dFront++;
        }
        else{
            dFront= 0;
        }

        return true;
    }
    
    bool deleteLast() {
        if(isEmpty())
            return false;
        
        arr[dRear]= -1;
        if(dFront==dRear){
            dFront= dRear= -1;
        }
        else if(dRear>0){
            dRear--;
        }
        else{
            dRear= size-1;
        }
        return true;
    }
    
    int getFront() {
        if(isEmpty())
            return -1;
        return arr[dFront];
    }
    
    int getRear() {
        if(isEmpty())
            return -1;
        return arr[dRear];
    }
    
    bool isEmpty() {
        return dFront==-1 && dRear==-1;
    }
    
    bool isFull() {
        return ((dFront==0 && dRear==size-1) || dRear==(dFront-1)%(size));
    }
};

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque* obj = new MyCircularDeque(k);
 * bool param_1 = obj->insertFront(value);
 * bool param_2 = obj->insertLast(value);
 * bool param_3 = obj->deleteFront();
 * bool param_4 = obj->deleteLast();
 * int param_5 = obj->getFront();
 * int param_6 = obj->getRear();
 * bool param_7 = obj->isEmpty();
 * bool param_8 = obj->isFull();
 */