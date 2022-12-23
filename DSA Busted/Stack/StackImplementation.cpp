#include<iostream>
using namespace std;
class Stack{
    int *s;
    int top= -1;
    int size= 0;
    public:
        Stack(int size){
            this->size= size;
            s= new int[size];
        }
        void push(int val){
            if (top<size-1){
                top++;
                s[top]= val;
            }
            else{
                cout<<"Stack overflow"<<endl;
            }
        }
        void pop(){
            if (top==-1)
            {
                cout<<"Stack is already Empty"<<endl;
                return;
            }
            s[top]= 0;
            top--;
        }
        int peek(){
            return s[top];
        }
        bool empty(){
            return top==-1;
        }
};

int main(){

    Stack *stack=new Stack(10);
    cout<<stack->empty()<<endl;
    stack->push(1);
    stack->push(2);
    stack->push(3);
    stack->push(4);
    cout<<stack->empty()<<endl;
    stack->push(5);
    stack->push(6);
    cout<<stack->peek()<<endl;
    stack->push(7);
    stack->push(8);
    stack->push(9);
    stack->push(10);
    stack->push(11);
    stack->push(13);
    while(!stack->empty()){
        cout<<stack->peek()<<" ";
        stack->pop();
    }
    cout<<endl;
    cout<<stack->empty()<<endl;


}