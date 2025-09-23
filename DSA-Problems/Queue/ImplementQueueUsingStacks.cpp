
// https://leetcode.com/problems/implement-queue-using-stacks/description/

class MyQueue {
    stack<int> st;
public:
    MyQueue() {
        
    }
    
    void push(int x) {
        insertAtBottom(st, x);
    }

    void insertAtBottom(stack<int> &st, int &val){
        if(st.empty()){
            st.push(val);
            return;
        }

        int temp= st.top();
        st.pop();
        insertAtBottom(st, val);
        st.push(temp);
    }
    
    int pop() {
        int val= st.top();
        st.pop();
        return val;
    }
    
    int peek() {
        return st.top();
    }
    
    bool empty() {
        return st.empty();
    }
};

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue* obj = new MyQueue();
 * obj->push(x);
 * int param_2 = obj->pop();
 * int param_3 = obj->peek();
 * bool param_4 = obj->empty();
 */