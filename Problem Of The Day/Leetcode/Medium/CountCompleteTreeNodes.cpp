
// https://leetcode.com/problems/count-complete-tree-nodes/

/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    
    void calculate(TreeNode* root, int &i){
        if(root==nullptr)
            return;
        
        i++;
        
        calculate(root->left, i);
        
        calculate(root->right, i);
        
    }
    
    int countNodes(TreeNode* root) {
        
        int i=0;
        
        calculate(root, i);
        
        return i;
        
    }
};