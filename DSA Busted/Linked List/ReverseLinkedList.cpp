
// https://leetcode.com/problems/reverse-linked-list/

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
    
    ListNode* reverseList(ListNode* head) {
        
        ListNode* temp= head;
        ListNode* prev= nullptr;
        ListNode* curr= temp;
        ListNode* next;
        
        while(curr!=nullptr){
            
            next= curr->next;
            curr->next= prev;
            prev = curr;
            curr= next;
            
        }
        
        return prev;
        
    }
};




// https://www.codingninjas.com/codestudio/problems/reverse-the-singly-linked-list_799897?source=youtube&campaign=Lovebabbarcodestudio_24thJan&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbarcodestudio_24thJan

#include <bits/stdc++.h> 
#include <bits/stdc++.h> 
/****************************************************************

    Following is the class structure of the LinkedListNode class:

    template <typename T>
    class LinkedListNode
    {
    public:
        T data;
        LinkedListNode<T> *next;
        LinkedListNode(T data)
        {
            this->data = data;
            this->next = NULL;
        }
    };

*****************************************************************/
LinkedListNode<int>* reverse(LinkedListNode<int> *forward,LinkedListNode<int> *prev, LinkedListNode<int> *curr) 
{
    if(curr==NULL){
        return prev;
    }
    
    forward= curr->next;
    curr->next= prev;
    prev= curr;
    curr= forward;
    
    reverse(forward, prev, curr);
    
}


LinkedListNode<int> *reverseLinkedList(LinkedListNode<int> *head) 
{
//     LinkedListNode<int>* prev= NULL;
//     LinkedListNode<int>* curr= head;
//     LinkedListNode<int>* forward;
    
//     while(curr!=NULL){
//         forward= curr->next;
//         curr->next= prev;
//         prev= curr;
//         curr= forward;       
//     }
//     return prev;
    
    return reverse(NULL, NULL, head);
    
}







