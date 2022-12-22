
// https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

class Solution
{
    public:
    //Function to sort a linked list of 0s, 1s and 2s.
    void insertNode(Node* &eleHead, Node* &curr){
        if(!eleHead){
            eleHead= curr;
            curr= curr->next;
        }else{
            eleHead->next= curr;
            eleHead= curr;
            curr= curr->next;
        }
        eleHead->next= NULL;
    }
    Node* segregate(Node *head) {
        // Add code here
        Node* zero= NULL;
        Node* one= NULL;
        Node* two= NULL;
        Node* newZeroHead= NULL;
        Node* newOneHead= NULL;
        Node* newTwoHead= NULL;
        while(head!=NULL){
            if(head->data==0){
                if(!zero)
                    newZeroHead= head;
                insertNode(zero, head);
            }
            else if(head->data==1){
                if(!one)
                    newOneHead= head;
                insertNode(one, head);
            }
            else{
                if(!two)
                    newTwoHead= head;
                insertNode(two, head);
            }
        }
        if(newZeroHead && newOneHead && newTwoHead){
            zero->next= newOneHead;
            one->next= newTwoHead;
            return newZeroHead;
        }
        else if(!newZeroHead && newOneHead && newTwoHead){
            one->next= newTwoHead;
            return newOneHead;
        }
        else if(newZeroHead && !newOneHead && newTwoHead){
            zero->next=newTwoHead;
            return newZeroHead;
        }
        else if(newZeroHead && newOneHead && !newTwoHead){
            zero->next=newOneHead;
            return newZeroHead;
        }
        else if(!newZeroHead && !newOneHead && newTwoHead){
            return newTwoHead;
        }
        else if(!newZeroHead && newOneHead && !newTwoHead){
            return newOneHead;
        }
        else if(newZeroHead && !newOneHead && !newTwoHead){
            return newZeroHead;
        }
    }
};