
// https://practice.geeksforgeeks.org/problems/4b7ff87c26ed23b3f63c25c611690213d44fb6aa/1

/*
struct Node
 {
     int data;
     Node* left, *right;
}; */

class Solution{
  public:
    /*You are required to complete below method */
    int maxLevelSum(Node* root) {
        // Your code here
        int answer = INT_MIN;
        int count = 0;
        queue<Node*> store;
        store.push(root);
        store.push(NULL);
        while(!store.empty())
        {
            Node *front = store.front();
            store.pop();
            count += front->data;
            if(front->left != NULL)
            {
                store.push(front->left);
            }
            if(front->right != NULL)
            {
                store.push(front->right);
            }
            if(store.front() == NULL)
            {
                store.pop();
                answer = max(answer , count);
                count = 0;
                if(!store.empty())
                {
                    store.push(NULL);
                }
            }
        }
        return answer;
    }
};