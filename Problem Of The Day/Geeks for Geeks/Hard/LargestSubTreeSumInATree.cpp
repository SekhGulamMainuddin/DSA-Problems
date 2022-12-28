
// https://practice.geeksforgeeks.org/problems/largest-subtree-sum-in-a-tree/1

class Solution {
    private :
    int build(Node* curr) {
        if(!curr) {
            return 0;
        } else {
            curr->data += build(curr->left) + build(curr -> right);
            return curr->data;
        }
    }
    
    private : 
    int get_max(Node* curr) {
        if(!curr) {
            return INT_MIN;
        } else {
            return max(curr -> data, max(get_max(curr->left), get_max(curr -> right)));
        }
    }
    
    public:
    int findLargestSubtreeSum(Node* root)
    {
        build(root);
        return get_max(root);
    }
};