#include<iostream>
using namespace std;
class CNode{
    public:
        int data;
        CNode* next;
        CNode(int data){
            this->data= data;
            next=NULL;
        }
        ~CNode(){
            cout<<"The CNode with value "<<data<<" is deleted"<<endl;
            next= NULL;
        }
};

void insert(CNode* &tail, int data){
    if(tail==NULL){
        CNode* newNode=new CNode(data);
        newNode->next=newNode;
        tail=newNode;
    }
    else{
        CNode* newNode=new CNode(data);
        newNode->next=tail->next;
        tail->next=newNode;
        tail=newNode;
    }
}

void printList(CNode* tail){
    CNode* temp= tail;

    do{
        cout<<temp->data<<" ";
        temp=temp->next;
    }while(temp!=tail);
}

void deleteNode(CNode* &tail, int data){
    CNode* temp= tail;
    bool isTailData=false;
    if(temp->next==temp){
        tail=NULL;
        delete temp;
        return;
    }
    if(tail->data==data)
        isTailData=true;

    do{
        temp=temp->next;
        if(data==temp->next->data){
            CNode* deleteTheNode= temp->next;
            temp->next=temp->next->next;
            delete deleteTheNode;  
            if (isTailData)
            {
                tail=temp;
            }        
            return;
        }
    }while(temp!=tail);

}

int main(){

    CNode* tail=NULL;
    insert(tail,1);
    insert(tail,2);
    insert(tail,3);
    insert(tail,4);
    deleteNode(tail,4);
    insert(tail,5);
    insert(tail,6);
    insert(tail,7);

    printList(tail->next);

    return 0;
}