
// https://practice.geeksforgeeks.org/problems/delete-middle-element-of-a-stack/1

class Solution
{
    public:
    //Function to delete middle element of a stack.
    void deleteMid(stack<int> &s, int mid, int size){
        size--;
        int temp= s.top();
        s.pop();
        if(size!=mid){
            deleteMid(s, mid, size);
            s.push(temp);
            size++;
            return;
        }
    }
    void deleteMid(stack<int>&s, int sizeOfStack)
    {
        // code here..
        if(sizeOfStack%2==0)
            deleteMid(s, (sizeOfStack/2)-1, sizeOfStack);
        else
            deleteMid(s, sizeOfStack/2, sizeOfStack);
        
    }
};