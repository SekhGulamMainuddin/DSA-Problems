
// https://practice.geeksforgeeks.org/problems/single-valued-subtree/1

/* Tree Node
struct Node
{
	int data;
	Node* left;
	Node* right;
};*/

class Solution
{
    public:
    int singlevalued(Node *root)
    {
        //code here
        return f(root)[1];
    }
    
    vector<int> f(Node* root) {
        int status=0,value=0;
        if(root->left==NULL && root->right==NULL) {
            status=1;
            value=1;
        } else if(root->left==NULL) {
            vector<int> v1 = f(root->right);
            value=v1[1];
            if(v1[0]==1 && root->data==root->right->data) {
                status=1;
                value++;
            }
        } else if(root->right==NULL) {
            vector<int> v1 = f(root->left);
            value=v1[1];
            if(v1[0]==1 && root->data==root->left->data) {
                status=1;
                value++;
            }
        } else {
            vector<int> v1 = f(root->left);
            vector<int> v2 = f(root->right);
            value=v1[1]+v2[1];
            if(v1[0]==1 && v2[0]==1 && root->data==root->left->data && root->data==root->right->data) {
                status=1;
                value++;
            }
        }
        vector<int> ans{status,value};
        return ans;
    }
    
};
