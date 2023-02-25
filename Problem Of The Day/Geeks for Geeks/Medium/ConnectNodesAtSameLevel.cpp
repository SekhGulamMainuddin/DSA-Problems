
// https://practice.geeksforgeeks.org/problems/95423710beef46bd66f8dbb48c510b2c320dab05/1

#include<queue>
class Solution{
    public:
    void connect(Node *root)
    {
       // Code Here
       queue<Node*>q;
          q.push(root);
          while(q.size())
          {
            int x = q.size();
            for(int i=0;i<x;i++)
            {
                Node*curr = q.front();q.pop();
                if(i==x-1)
                 {
                     curr->nextRight = NULL;
                 }
                 else curr->nextRight = q.front();
              if(curr->left) q.push(curr->left);
              if(curr->right) q.push(curr->right);
                 
            }
          }
       
    }    
};