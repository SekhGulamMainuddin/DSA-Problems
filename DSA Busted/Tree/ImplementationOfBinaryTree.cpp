#include<iostream>
#include<queue>
using namespace std;
class Node
{
    public :
        int val;
        Node* right;
        Node* left;
        Node(int val){
            this->val = val;
            this->left= NULL;
            this->right= NULL;
        }
};
Node* buildTree(Node* root){
    cout<<"Enter the data : ";
    int val;
    cin>>val;
    root= new Node(val);

    if(val==-1){
        return NULL;
    }

    cout<<"Enter the value for left node of "<<val<<endl;
    root->left= buildTree(root->left);
    cout<<"Enter the value for right node of "<<val<<endl;
    root->right= buildTree(root->right);

    return root;
}
void levelOrderTraversal(Node* root){
    cout<<endl;
    queue<Node*> que;
    que.push(root);
    que.push(NULL);
    while (!que.empty())
    {
        Node* temp= que.front();
        que.pop();
        if (temp==NULL)
        {
            cout<<endl;
            if(!que.empty()){
                que.push(NULL);
            }
        }
        else{
            cout<<temp->val<<" ";
            if (temp->left)
            {
                que.push(temp->left);
            }
            if (temp->right)
            {
                que.push(temp->right);
            }
        }
    }
}

int main(){
    // 2 5 4 -1 -1 1 -1 -1 3 6 -1 -1 7 -1 8 -1 -1
    Node* root= NULL;
    root= buildTree(root);
    levelOrderTraversal(root);
    return 0;
}