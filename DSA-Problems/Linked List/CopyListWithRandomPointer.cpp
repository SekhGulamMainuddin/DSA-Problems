
// https://leetcode.com/problems/copy-list-with-random-pointer/description/



/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {

        if(head==NULL)
            return NULL;
        Node* newHead= NULL;
        Node* prev= NULL;
        Node* temp= head;
        while(temp!=NULL){
            Node* newNode= new Node(temp->val);
            prev= temp;
            temp= temp->next;
            prev->next= newNode;
            newNode->next= temp;
        }
        temp= head;
        while(temp!=NULL){
            if(temp->random==NULL)
                temp->next->random= NULL;
            else
                temp->next->random= temp->random->next;
            temp= temp->next->next;
        }
        temp= head->next;
        newHead= temp;
        prev= head;
        Node* lower= NULL;
        while(temp!=NULL && temp->next!=NULL){
            prev->next= temp->next;
            prev= prev->next;
            lower= temp->next->next;
            temp->next= lower;
            temp= lower;
        }
        prev->next=NULL;
        return newHead;

        // if(head==NULL)
        //     return head;
        // Node* newHead= NULL;
        // Node* curr= NULL;
        // Node* temp= head;
        // unordered_map<Node*, Node*> oldNew;
        // while(temp!=NULL){
        //     Node* newNode= new Node(temp->val);
        //     oldNew[temp]= newNode;
        //     if(newHead){
        //         curr->next= newNode;
        //         curr= curr->next;
        //     }
        //     else{
        //         newHead= newNode;
        //         curr= newNode;
        //     }
        //     temp= temp->next;
        // }
        // oldNew[NULL]= NULL;
        // curr->next= NULL;
        // curr= newHead;
        // temp= head;
        // while(temp!=NULL){
        //     if(temp->random!=NULL)
        //         curr->random= oldNew[temp->random];
        //     else
        //         curr->random= NULL;
        //     curr= curr->next;
        //     temp= temp->next;
        // }
        // return newHead;


        // Node* newHead= NULL;
        // Node* curr= NULL;
        // map<Node*,int> indexOri;
        // map<int, Node*> indexClo;
        // Node* tHead= head;
        // int index=0;
        // while(tHead!=NULL){
        //     indexOri[tHead]= index;
        //     index++;
        //     tHead= tHead->next;
        // }
        // tHead= head;
        // indexOri[NULL]= -1;
        // while(tHead!=NULL){
        //     Node* temp= new Node(tHead->val);
        //     if(curr){
        //         curr->next= temp;
        //         curr= temp;
        //     }else{
        //         newHead= temp;
        //         curr= temp;
        //     }
        //     tHead= tHead->next;
        // }
        // curr= newHead;
        // index=0;
        // while(curr!=NULL){
        //     indexClo[index]= curr;
        //     index++;
        //     curr= curr->next;
        // }
        // curr= newHead;
        // while(head!=NULL){
        //     curr->random= indexClo[indexOri[head->random]];
        //     head= head->next;
        //     curr= curr->next;
        // }
        // return newHead;

    }
};



