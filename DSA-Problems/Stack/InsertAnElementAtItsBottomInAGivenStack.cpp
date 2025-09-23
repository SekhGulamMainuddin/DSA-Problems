
// https://www.codingninjas.com/codestudio/problems/insert-an-element-at-its-bottom-in-a-given-stack_1171166?topList=love-babbar-dsa-sheet-problems&leftPanelTab=1

#include <bits/stdc++.h> 
void addElement(stack<int> &myStack, int x){
    if(myStack.empty()){
        myStack.push(x);
        return;
    }
    
    int temp= myStack.top();
    myStack.pop();
    
    addElement(myStack, x);
    
    myStack.push(temp);
}
stack<int> pushAtBottom(stack<int>& myStack, int x) 
{
    // Write your code here.
    addElement(myStack, x);
    return myStack;
}
