
// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/

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
    TreeNode* buildTree(vector<int>& preorder, int min, int max, int &i) {
        if(i>=preorder.size())
            return NULL;
            
        if(preorder[i]<min || preorder[i]>max)
            return NULL;

        TreeNode* newNode= new TreeNode(preorder[i++]);
        newNode->left= buildTree(preorder, min, newNode->val, i);
        newNode->right= buildTree(preorder, newNode->val, max, i);

        return newNode;
    }
    TreeNode* bstFromPreorder(vector<int>& preorder) {
        int i= 0;
        return buildTree(preorder, INT_MIN, INT_MAX, i);
    }
};









