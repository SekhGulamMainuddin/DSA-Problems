
// https://www.codingninjas.com/codestudio/problems/interleave-the-first-half-of-the-queue-with-the-second-half_1169450?leftPanelTab=1

#include <bits/stdc++.h> 
void interLeaveQueue(queue < int > & q) {
    // Write your code here.
    //Using Stack
    int size= q.size()/2;
    stack<int> st;
    for(int i=0; i<size; i++){
        st.push(q.front());
        q.pop();
    }
    
    while(!st.empty()){
        int q2Fr= st.top();
        st.pop();
        q.push(q2Fr);
    }
    
    for(int i=0; i<size; i++){
        q.push(q.front());
        q.pop();
    }
    
    for(int i=0; i<size; i++){
        st.push(q.front());
        q.pop();
    }
    
    while(!st.empty()){
        int q2Fr= st.top();
        st.pop();
        q.push(q2Fr);
        int q1Fr= q.front();
        q.pop();
        q.push(q1Fr);
    }
    
    /* Using a new Queue
    int size= q.size()/2;
    queue<int> q2;
    
    for(int i=0; i<size; i++){
        q2.push(q.front());
        q.pop();
    }
    
    while(!q2.empty()){
        int q2Fr= q2.front();
        q2.pop();
        q.push(q2Fr);
        int q1Fr= q.front();
        q.pop();
        q.push(q1Fr);
    }
    */
    
    
    
    /* Using Two Arrays
    int size= q.size()/2;
    int *q1= new int[size];
    int *q2= new int[size];
    
    for(int i=0; i<size; i++){
        q1[i]= q.front();
        q.pop();
    }
    
    for(int i=0; i<size; i++){
        q2[i]= q.front();
        q.pop();
    }
    
    for(int i=0; i<size; i++){
        q.push(q1[i]);
        q.push(q2[i]);
    }
    */
    
}