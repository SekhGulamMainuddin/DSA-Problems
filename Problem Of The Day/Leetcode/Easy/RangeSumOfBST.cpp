
// https://leetcode.com/problems/range-sum-of-bst/description/

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
    void calculateSum(TreeNode* root, int &low, int &high, int &sum){
        if(root==nullptr)
            return;

        if(root->val<=high && root->val>=low){
            sum+=root->val;
        }

        // Left
        calculateSum(root->left, low, high, sum);

        // right
        calculateSum(root->right, low, high, sum);
    }
    int rangeSumBST(TreeNode* root, int low, int high) {
        
        int sum=0;
        calculateSum(root, low, high, sum);

        return sum;
    }
};


