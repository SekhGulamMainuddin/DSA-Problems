
// https://www.codingninjas.com/codestudio/problems/reverse-list-in-k-groups_983644?leftPanelTab=1

#include <bits/stdc++.h> 
/****************************************************************
    Following is the Linked List node structure

    class Node
    {
    public:
        int data;
        Node *next;
        Node(int data)
        {
            this->data = data;
            this->next = NULL;
        }
    };

*****************************************************************/


Node* kReverse(Node* head, int k) {
    // Write your code here.
    
        if(head == NULL)
            return NULL;
        
        Node* next= NULL;
        Node* prev= NULL;
        Node* curr= head;
        int count=0;

        while(curr!=NULL && count<k){
            next=curr->next;
            curr->next= prev;
            prev= curr;
            curr= next;
            count++;
        }

        if(next!=NULL)
            head->next=kReverse(next,k);

        return prev;
    
}





// https://leetcode.com/problems/reverse-nodes-in-k-group/description/ 

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(head == NULL)
            return NULL;
        
        ListNode* next= NULL;
        ListNode* prev= NULL;
        ListNode* curr= head;
        int count=0;
        ListNode* temp=head;

        while(temp!=NULL && count<k){
            count++;
            temp= temp->next;

        }

        if(count!=k){
            return head;
        }

        count=0;
        while(curr!=NULL && count<k){
            next=curr->next;
            curr->next= prev;
            prev= curr;
            curr= next;
            count++;
        }

        if(next!=NULL)
            head->next=reverseKGroup(next,k);

        return prev;
    }
};



