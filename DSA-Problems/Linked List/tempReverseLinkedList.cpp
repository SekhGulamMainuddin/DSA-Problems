#include<iostream>
using namespace std;
class Node{
    public :
        int val;
        Node* next;
        Node(){
            val= -1;
            next= NULL;
        }
        Node(int val){
            this->val= val;
            next= NULL;
        }
};
void reverseLinkedList(Node* &head){
    if(head==NULL)
        return;
    else{
        Node* prev=NULL;
        Node* curr=head;
        Node* next=head->next;
        while (curr!=NULL)
        {
            next= curr->next;
            curr->next= prev;
            prev= curr;
            curr= next;
        }
        head=prev;
        
    }
}

void reverseLinkedList(Node* &prev, Node* &head){
    if(head==NULL){
        head=prev;
        return;
    }
    else{
        Node* next= head->next;
        head->next= prev;
        prev= head;
        head= next;
        reverseLinkedList(prev, head);
    }
}

int main(){

    Node* head= new Node(1);
    Node* one=head;
    Node* two= new Node(2);
    Node* three= new Node(3);
    Node* four= new Node(4);
    Node* five= new Node(5);
    Node* six= new Node(6);
    Node* seven= new Node(7);
    Node* eight= new Node(8);

    one->next=two;
    two->next=three;
    three->next=four;
    four->next=five;
    five->next=six;
    six->next=seven;
    seven->next=eight;

    Node* prev= NULL;
    reverseLinkedList(prev,head);

    while(head!=NULL){
        cout<<head->val<<" ";
        head=head->next;
    }


    return 0;
}