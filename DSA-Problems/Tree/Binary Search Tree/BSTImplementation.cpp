#include<iostream>
#include<queue>
using namespace std;
class Node{
    public:
        int data;
        Node* left;
        Node* right;

        Node(int data) {
            this->data= data;
            left= NULL;
            right= NULL;
        }
};
void buildBST(Node* root, int inputData) {
    if(inputData<root->data){
        if(root->left)
            buildBST(root->left, inputData);
        else{
            Node* newNode= new Node(inputData);
            root->left= newNode;
        }
    }
    else{
        if(root->right)
            buildBST(root->right, inputData);
        else{
            Node* newNode= new Node(inputData);
            root->right= newNode;
        }
    }
}
Node* takeInput() {

    Node* root= NULL;
    int inputData= 0;
    cout<<"Enter the data : ";
    cin>>inputData;
    root= new Node(inputData);
    while(inputData!=-1){
        cout<<"Enter the data : ";
        cin>>inputData;
        if(inputData!=-1)
            buildBST(root, inputData);
    }

    return root;
}
void printLevelOrder(Node* root) {
    cout<<"Inorder Traversal"<<endl;
    queue<Node*> q;
    q.push(root);
    while(!q.empty()){
        cout<<endl;
        int size= q.size();
        for(int i=0; i<size; i++){
            Node* tempNode= q.front();
            q.pop();
            cout<<tempNode->data<<" ";
            if(tempNode->left)
                q.push(tempNode->left);
            if(tempNode->right)
                q.push(tempNode->right);
        }
    }
    cout<<endl;
}

void printInorder(Node* root) {

    if(root==NULL)
        return;

    printInorder(root->left);
    cout<<root->data<<" ";
    printInorder(root->right);

}

void printPostOrder(Node* root) {

    if(root==NULL)
        return;

    printPostOrder(root->left);
    printPostOrder(root->right);
    cout<<root->data<<" ";

}


void printPreOrder(Node* root) {

    if(root==NULL)
        return;

    cout<<root->data<<" ";
    printPreOrder(root->left);
    printPreOrder(root->right);

}

void deleteValueFromBST(Node* &root, int val){

    Node* temp= root;
    Node* preTemp= root;

    if(root->data==val){
        if(root->right){
            temp=root->right;
            while(temp->left!=NULL)
                temp= temp->left;
            temp->left= root->left;
            root= temp;
        }
        else{
            root= root->left;
        }
        
        delete preTemp;
        return;
    }

    while(temp!=NULL){
        if(temp->data==val)
            break;
        else if(temp->data>val){
            preTemp= temp;
            temp=temp->left;
        }
        else{
            preTemp= temp;
            temp=temp->right;
        }
    }
    if(temp!=NULL && temp->data==val){
        if(temp->right!=NULL && temp->left!=NULL) {
            cout<<"Entry "<<endl;
            Node* minLeft= temp->right;
            Node* preLeft= minLeft;
            if (minLeft->left==NULL)
            {
                temp->right->left= preTemp->left->left;
                preTemp->left=temp->right;
            }else{
                while(minLeft->left!=NULL){
                    preLeft= minLeft;
                    minLeft= minLeft->left;
                }
                preLeft->left=NULL;
                temp->data= minLeft->data;
                delete minLeft;
            }
            
            return;
        }
        else if(preTemp->right==temp) {
            if(temp->right==NULL)
                preTemp->right= temp->left;
            if(temp->left==NULL)
                preTemp->right= temp->right;
        }
        else if(preTemp->left==temp) {
            if(temp->right==NULL)
                preTemp->left= temp->left;
            if(temp->left==NULL)
                preTemp->left= temp->right;
        }

        delete temp;

    }

}

int main(){
    Node* root= takeInput();
    printLevelOrder(root);
    // cout<<"Inorder Traversal "<<endl;
    // printInorder(root);
    // cout<<endl;
    // cout<<"Preorder Traversal "<<endl;
    // printPreOrder(root);
    // cout<<endl;
    // cout<<"Postorder Traversal "<<endl;
    // printPostOrder(root);
    // cout<<endl;

    deleteValueFromBST(root, 80);

    printLevelOrder(root);
    cout<<"Inorder Traversal "<<endl;
    // printInorder(root);
    // cout<<endl;
    // cout<<"Preorder Traversal "<<endl;
    // printPreOrder(root);
    // cout<<endl;
    // cout<<"Postorder Traversal "<<endl;
    // printPostOrder(root);
    // cout<<endl;

    return 0;
}