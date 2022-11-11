
//https://leetcode.com/problems/path-sum/

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

//
class Solution {
    void inorder(TreeNode *root,int sum, int &add,bool &there){
        if(!root || there){
            return;
        }
        add +=root->val;
        inorder(root->left,sum,add,there);
        inorder(root->right,sum,add,there);
        if(!root->left && !root->right && add == sum){
            there = true;
        }
        add -=root->val;
    }
public:
    bool hasPathSum(TreeNode* root, int sum) {
     bool there  =false;
     int add = 0;
     inorder(root,sum,add,there);
        return there;
    }
};




class Solution {
public:
    bool hasPathSum(TreeNode* root, int targetSum) {
        if(root==NULL)
            return false;
        if(root->left==NULL && root->right==NULL)
            return targetSum-root->val ==0;
        
        return hasPathSum(root->left, targetSum-root->val) || hasPathSum(root->right, targetSum-root->val);
    }
};