
// https://leetcode.com/problems/balanced-binary-tree/description/

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
    pair<bool, int> isBalancedFast(TreeNode* root){
        pair<bool, int> ans= make_pair(true, 0);
        if(root==NULL)
            return ans;

        pair<bool, int> left= isBalancedFast(root->left);
        pair<bool, int> right= isBalancedFast(root->right);

        bool leftAns= left.first;
        bool rightAns= right.first;
        bool heightDiff= abs(left.second - right.second) <= 1;

        ans.second= max(left.second, right.second) + 1;
        if(leftAns && rightAns && heightDiff){
            ans.first= true;
        }else{
            ans.first= false;
        }
        return ans;
    }
    bool isBalanced(TreeNode* root){
        return isBalancedFast(root).first;
    }
    
    /*
    int height(TreeNode* root) {
        if(root==NULL)
            return 0;
        int left= height(root->left);
        int right= height(root->right);

        return max(left, right)+1;
    }
    bool isBalanced(TreeNode* root) {
        if(root==NULL)
            return true;

        bool left= isBalanced(root->left);
        bool right= isBalanced(root->right);

        bool heightDiff= abs(height(root->left) - height(root->right)) <= 1;

        if(left && right && heightDiff)
            return true;
        else
            return false;
        
    }
    */
};








