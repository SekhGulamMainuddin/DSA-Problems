
// https://practice.geeksforgeeks.org/problems/reverse-first-k-elements-of-queue/1

void reverse(queue<int> &que, int k){
    if(k==0)
        return;
    int temp= que.front();
    que.pop();
    k--;
    reverse(que, k);
    que.push(temp);
}
queue<int> modifyQueue(queue<int> q, int k) {
    // add code here.
    reverse(q, k);
    while(k<q.size()){
        int temp= q.front();
        q.pop();
        q.push(temp);
        k++;
    }
    return q;
}