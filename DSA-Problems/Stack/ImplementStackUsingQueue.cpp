
// https://leetcode.com/problems/implement-stack-using-queues/description/

class MyStack {
    queue<int> q;
public:
    MyStack() {
        
    }
    
    void push(int x) {
        int size= q.size();
        q.push(x);
        while(size!=0){
            int temp= q.front();
            q.pop();
            q.push(temp);
            size--;
        }
    }
    
    int pop() {
        int val= q.front();
        q.pop();
        return val;
    }
    
    int top() {
        return q.front();
    }
    
    bool empty() {
        return q.empty();
    }
};

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack* obj = new MyStack();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->top();
 * bool param_4 = obj->empty();
 */