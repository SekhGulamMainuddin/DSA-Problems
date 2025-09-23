
// https://leetcode.com/problems/balance-a-binary-search-tree/description/

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
    void getElements(TreeNode* root, vector<int> &elements) {
        if(root==NULL)
            return;

        getElements(root->left, elements);
        elements.push_back(root->val);
        getElements(root->right, elements);

    }
    TreeNode* buildBSTfromInorder(int start, int end, vector<int> &elements) {
        if(start>end)
            return NULL;

        int mid= (start+end)/2;
        TreeNode* newNode= new TreeNode(elements[mid]);

        newNode->left= buildBSTfromInorder(start, mid-1, elements);
        newNode->right= buildBSTfromInorder(mid+1, end, elements);

        return newNode;
    }

    TreeNode* balanceBST(TreeNode* root) {
        vector<int> elements;
        getElements(root, elements);

        return buildBSTfromInorder(0, elements.size()-1, elements);

    }
};






