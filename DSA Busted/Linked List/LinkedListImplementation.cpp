#include<iostream>
using namespace std;
class LinkedList{
    public:
        int value;
        LinkedList* next;
        LinkedList(int value){
            this -> value = value;
            this -> next = NULL;
        }
        ~LinkedList(){
            if (this->next!=NULL)
            {
                delete next;
                this->next=NULL;
            }
            cout<<"called";
        }
};

void insertNodeAtHead(LinkedList* &head, int value){
    LinkedList* temp=new LinkedList(value);
    temp->next = head;
    head=temp;
    cout<<head->value<<endl;
}

void insertNodeAtTail(LinkedList* &tail, int value){
    LinkedList* temp=new LinkedList(value);
    tail->next=temp;
    tail=temp;
}

void insertNodeAtPosition(LinkedList* &head,LinkedList* &tail, int position, int value){
    LinkedList* newNode=new LinkedList(value);
    LinkedList* temp=head;
    int i=1;
    if (position==1)
    {
        newNode->next=head;
        head=newNode;
    }
    else{
        while(i<(position-1)){
            temp=temp->next;
            i++;
        }
        if(temp->next==NULL){
            insertNodeAtTail(tail,value);
        }
        else{
            newNode->next=temp->next;
            temp->next=newNode; 
        }
    }
    
}

void deleteFromAnyPosition(LinkedList* &head, int position){
    LinkedList* temp=head;
    LinkedList* deleteNode;
    int i=0;
    if(position==1){
        head=head->next;
        return;
    }
    while(i<(position-2)){
        temp=temp->next;
        i++;
    }
    if(temp->next->next==NULL){
        deleteNode= temp->next->next;
        temp->next=NULL;
        delete deleteNode;
    }
    else{
        deleteNode=temp->next->next;
        temp->next=temp->next->next;
        delete deleteNode;
    }
}

void printList(LinkedList* &head){
    LinkedList* temp=head;
    while(temp!=NULL){
        cout<<temp->value<<" ";
        temp=temp->next;
    }
}

int main(){

    LinkedList* value1=new LinkedList(20);
    LinkedList* tail=value1;

    insertNodeAtTail(tail,30);
    insertNodeAtTail(tail,40);
    insertNodeAtTail(tail,50);

    insertNodeAtPosition(value1,tail,5,25);

    // insertNodeAtTail(tail,23);
    // insertNodeAtTail(tail,57);

    printList(value1);
    cout<<endl;

    deleteFromAnyPosition(value1,1);

    printList(value1);

}