
https://practice.geeksforgeeks.org/problems/6eb51dc638ee1b936f38d1ab4b2f7062d4425463/1

class Solution
{
public:
    int maxGCD( Node* root)
    {
        //code here
        return f(root)[1];
    }
    // 0th index --> Maximum GCD Value
    // 1st index --> Node data according to this max. GCD
    vector<int> f(Node* root) {
        if(root==NULL) {
            vector<int> a1{0,0};
            return a1;
        }
        vector<int> a1 = f(root->left);
        vector<int> a2 = f(root->right);
        vector<int> ans = compare(a1,a2);
        if(root->left!=NULL && root->right!=NULL) {
            int g = gcd(root->left->data,root->right->data);
            vector<int> a3{g,root->data};
            ans = compare(ans,a3);
        }
        return ans;
    }
    
    vector<int> compare(vector<int> a1,vector<int> a2) {
        if(a1[0]<a2[0]) {
            return a2;
        } else if(a1[0]==a2[0]) {
            if(a1[1]<a2[1]) {
                return a2;
            } else {
                return a1;
            }
        } else {
            return a1;
        }
    }
    
    int gcd(int a,int b) {
        if(a==0) return b;
        return gcd(b%a,a);
    }
};


