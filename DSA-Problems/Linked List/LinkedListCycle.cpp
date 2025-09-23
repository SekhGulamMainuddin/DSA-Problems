
// https://leetcode.com/problems/linked-list-cycle/description/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    bool hasCycle(ListNode *head) {
    if(head==NULL || head->next==NULL)
        return false;
    if(head->next==head)
        return true;
    
    ListNode* fastPointer=head;
    ListNode* slowPointer=head;
    while(slowPointer!=NULL && fastPointer!=NULL && fastPointer->next!=NULL){
        fastPointer=fastPointer->next->next;
        slowPointer=slowPointer->next;
        if(fastPointer==slowPointer)
            return true;
    }
    return false;
    }
};