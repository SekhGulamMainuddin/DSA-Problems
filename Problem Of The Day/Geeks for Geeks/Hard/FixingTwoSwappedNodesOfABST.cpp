
// https://practice.geeksforgeeks.org/problems/6c4053871794c5e7a0817d7eaf88d71c4bb4c2bc/1

/*struct Node
{
    int data;
    struct Node *left, *right;
};*/

class Solution {
  public:
    void Inorder(Node* root,vector<Node*>& nodes)
      {
        if(root==NULL) return;
        Inorder(root->left,nodes);
        nodes.push_back(root);
        Inorder(root->right,nodes);
      }
    struct Node *correctBST(struct Node *root) {
        vector<Node*> nodes;
        Inorder(root,nodes);
        Node* first=NULL,*second=NULL;
        for(int i=1;i<nodes.size();i++)
        {
            if(nodes[i-1]->data>nodes[i]->data)
            {
                if(first==NULL)
                {
                   first=nodes[i-1];
                }
                second=nodes[i];
            }
        }
        int temp=first->data;
        first->data=second->data;
        second->data=temp;
        
        return root;
    }
};