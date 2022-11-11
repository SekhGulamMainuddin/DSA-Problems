
//https://leetcode.com/problems/add-one-row-to-tree/

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
    TreeNode* addOneRow(TreeNode* root, int v, int d) {
        
        if(1==d) 
        {
            TreeNode* newRoot = new TreeNode(v);
            newRoot->left = root;
            return newRoot;
        }
        queue<TreeNode*> Q;
        Q.push(root);
        int lvl = 0;//current level
        bool finish = false;
        while(!Q.empty())
        {
            int n = Q.size();
            ++lvl;
            for(int i=0;i<n;++i)
            {
                TreeNode* tp = Q.front();
                Q.pop();
                if(lvl == d-1)//processing level d-1's nodes one by one
                {
                    TreeNode* l = tp->left;
                    tp->left = new TreeNode(v);
                    tp->left->left = l;
                    
                    TreeNode* r = tp->right;
                    tp->right = new TreeNode(v);
                    tp->right->right = r;
                    finish = true;
                }
                else
                {
                    if(tp->left) Q.push(tp->left);
                    if(tp->right) Q.push(tp->right);
                }
            }
            if(finish) break;//when all done, end the loop
        }
        return root;
    }
};