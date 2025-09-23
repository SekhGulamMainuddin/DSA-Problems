#include<iostream>
using namespace std;

class DNode{
    public :
        int data;
        DNode* prev;
        DNode* next;
        DNode(int data){
            this->data= data;
            prev= NULL;
            next= NULL;
        }
        ~DNode(){
            cout<<"The DNode with value "<< data<<" is deleted"<<endl;
            prev= NULL;
            next= NULL;
            data= 0;
        }
};

void insert(DNode* &head, int data){
    DNode* newNode=new DNode(data);
    head->next=newNode;
    newNode->prev=head;
    head= newNode;
}

void insertAtPosition(DNode* &head,int position, int data){
    DNode* newNode=new DNode(data);
    DNode* temp= head;

    if(position==1){
        newNode->next=head;
        head->prev=newNode;
        head=newNode;
        return;
    }

    int i=1;
    while (i<(position-1))
    {
        temp=temp->next;
        i++;
    }
    if(temp->next==NULL){
        temp->next= newNode;
        newNode->prev= temp;
        head= newNode;
    }
    else{
        newNode->next=temp->next;
        temp->next->prev= newNode;
        temp->next= newNode;
        newNode->prev= temp;
    }

}

void deleteDNode(DNode* &head, int position){
    DNode* temp=head;
    if (position==1)
    {
        head= head->next;
        head->prev = NULL;
        delete temp;
        return;
    }

    int i=1;
    while(i!=position){
        temp=temp->next;
        i++;
    }

    if(temp->next==NULL){
        temp->prev->next=NULL;
        delete temp;
    }
    else{
        temp->prev->next=temp->next;
        temp->next->prev=temp->prev;
        delete temp;
    }
    
}

void printList(DNode* &head){
    DNode* temp=head;
    while(temp!=NULL){
        cout<<temp->data<<" ";
        temp= temp->next;
    }
    cout<<endl;
}

int getLength(DNode* head){
    int count=0;
    while (head!=NULL)
    {
        count++;
        head=head->next;
    }
    return count;
}

int main(){
    DNode* dNode=new DNode(10);
    DNode* head= dNode;

    insert(head,20);
    insert(head,40);
    insert(head,50);
    insert(head,60);
    
    insertAtPosition(dNode,1,30);

    printList(dNode);
    
    // cout<<getLength(dNode)<<endl;

    // deleteDNode(dNode,5);

    // printList(dNode);

    // cout<<getLength(dNode)<<endl;

    return 0;
}