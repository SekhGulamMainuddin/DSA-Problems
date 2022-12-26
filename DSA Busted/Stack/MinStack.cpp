
// https://leetcode.com/problems/min-stack/description/

class MinStack {
    stack<long> st;
    int minElement= INT_MAX;
public:
    MinStack() {}
    
    void push(int val) {
        if(val< minElement){
            st.push(2ll*val - minElement);
            minElement= val;
        }else{
            st.push(val);
        }
    }
    
    void pop() {

        if(st.empty())
            return;

        if(st.top()<minElement){
            minElement= 2ll*minElement - st.top();
        }            
        st.pop();

    }
    
    int top() {
        if(st.top()<minElement){
            return minElement;
        }
        return st.top();
    }
    
    int getMin() {
        return minElement;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */