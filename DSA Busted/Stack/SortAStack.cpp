
// https://www.codingninjas.com/codestudio/problems/sort-a-stack_985275?topList=love-babbar-dsa-sheet-problems&leftPanelTab=0
// https://practice.geeksforgeeks.org/problems/sort-a-stack/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

#include <bits/stdc++.h> 
void subSort(stack<int> &stack, int &x){
    if(stack.empty()){
        stack.push(x);
        return;
    }
    if(x<stack.top()){
        int temp= stack.top();
        stack.pop();
        subSort(stack, x);
        stack.push(temp);
    }
    else{
        stack.push(x);
        x= NULL;
    }
}
void sortStack(stack<int> &stack)
{
	// Write your code here
    if(stack.empty())
        return;
    
    int temp= stack.top();
    stack.pop();
    sortStack(stack);
    subSort(stack, temp);
    
}