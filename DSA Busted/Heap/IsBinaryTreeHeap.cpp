
// https://practice.geeksforgeeks.org/problems/is-binary-tree-heap/1

class Solution {
  public:
    void countNodes(struct Node* tree, int &count){
        if(tree==NULL)
            return;
        
        countNodes(tree->left, count);
        countNodes(tree->right, count);
        
        count++;
        
    }
    bool isCBT(struct Node* root, int index, int &count){
        if(root==NULL)
            return true;
        
        if(index>=count)
            return false;
            
        bool left = isCBT(root->left, 2*index+1, count);
        bool right= isCBT(root->right, 2*index+2, count);
        
        return left && right;
    }
    bool isMaxHeap(struct Node* root){
     
        if(root->left == NULL && root->right==NULL)
            return true;
        else if(root->left==NULL && root->right!=NULL)
            return false;
        else if(root->left!=NULL && root->right==NULL){
            if(root->data>root->left->data)
                return true;
            else
                return false;
        }
        else{
            if(root->data>root->left->data && root->data>root->right->data){
                bool left= isHeap(root->left);
                bool right= isHeap(root->right);
                return left&&right;
            }
            else{
                return false;
            }
        }
    }
    bool isHeap(struct Node* tree) {
        // code here
        int index= 0;
        int count= 0;
        countNodes(tree, count);
        
        if(isCBT(tree, index, count) && isMaxHeap(tree)){
            return true;
        }
        else{
            return false;
        }
    }
};


