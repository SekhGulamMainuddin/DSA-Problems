
// https://practice.geeksforgeeks.org/problems/queue-reversal/1

void reverse(queue<int> &que){
    if(que.empty())
        return;
    int temp= que.front();
    que.pop();
    reverse(que);
    que.push(temp);
}
queue<int> rev(queue<int> q)
{
    // add code here.
    reverse(q);
    return q;
}