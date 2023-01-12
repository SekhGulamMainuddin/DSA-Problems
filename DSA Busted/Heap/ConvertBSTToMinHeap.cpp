
// https://www.codingninjas.com/codestudio/problems/convert-bst-to-min-heap_920498?leftPanelTab=1

#include <bits/stdc++.h> 
/*************************************************************
    
    Following is the Binary Tree node structure:

	class BinaryTreeNode {
		
	public :
		int data;
		BinaryTreeNode* left;
		BinaryTreeNode* right;

		BinaryTreeNode(int data) {
		this -> left = NULL;
		this -> right = NULL;
		this -> data = data;
		}
	};

*************************************************************/
void buildMinHeap(BinaryTreeNode* &root, vector<int> &elements, int &index){
    if(root==NULL)
        return;
    
    root->data= elements[index++];
    buildMinHeap(root->left, elements, index);
    buildMinHeap(root->right, elements, index);
    
}

BinaryTreeNode* convertBST(BinaryTreeNode* root)
{
    vector<int> elements;
    BinaryTreeNode* curr= root;
    BinaryTreeNode* pre;
    while(curr!=NULL){
        if(curr->left){
            pre= curr->left;
            while(pre->right!=NULL && pre->right!=curr)
                pre= pre->right;
           
            if(pre->right==NULL){
                pre->right= curr;
                curr= curr->left;
            }else{
                pre->right= NULL;
                elements.push_back(curr->data);
                curr= curr->right;
            }
        }else{
            elements.push_back(curr->data);
            curr= curr->right;
        }
    }
    
    int index= 0;
    buildMinHeap(root, elements, index);
    
    return root;
}













