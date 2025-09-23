
// https://leetcode.com/problems/palindrome-linked-list/description/

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
    ListNode* reverseList(ListNode* head){
        ListNode* nextNode= head;
        ListNode* prev= NULL;
        ListNode* curr= head;
        while(nextNode!=NULL){
            curr= nextNode;
            nextNode= nextNode->next;
            curr->next= prev;
            prev= curr;
        }
        return prev;
    }
    bool isPalindrome(ListNode* head) {
        if(head->next==NULL)
            return true;
        else if(head->next->next==NULL){
            if(head->val == head->next->val)
                return true;
            else
                return false;
        }
        ListNode* fast= head;
        ListNode* slow= head;
        ListNode* prev= NULL;
        while(fast!=NULL && fast->next!=NULL){
            prev= slow;
            slow= slow->next;
            fast= fast->next->next;
        }
        if(fast==NULL){
            prev->next= reverseList(slow);
            prev= prev->next;
        }
        else{
            prev= prev->next;
            prev->next= reverseList(slow->next);
            prev= prev->next;
        }
        while(head!=slow && prev!=NULL){
            if(head->val != prev->val)
                return false;
            head= head->next;
            prev= prev->next;
        }
        return true;
    }
};





