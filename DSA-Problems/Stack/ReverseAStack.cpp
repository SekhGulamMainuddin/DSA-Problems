
// https://practice.geeksforgeeks.org/problems/reverse-a-stack/1

class Solution{
public:
    void insertAtBottom(stack<int> &stack, int &x){
        if(stack.empty()){
            stack.push(x);
            return;
        }
        int temp= stack.top();
        stack.pop();
        insertAtBottom(stack, x);
        stack.push(temp);
    }
    
    void Reverse(stack<int> &St){
        // stack<int> newStack;
        // int temp=0;
        // while(!St.empty()){
        //     temp= St.top();
        //     newStack.push(temp);
        //     St.pop();
        // }
        // St= newStack;
        if(St.empty())
            return;
        
        int temp= St.top();
        St.pop();
        Reverse(St);
        insertAtBottom(St, temp);
        
    }
};