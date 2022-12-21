
// https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/description/

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
    ListNode* deleteDuplicates(ListNode* head) {
        if(head==NULL)
            return head;
        if(head->next==NULL)
            return head;
        ListNode* newHead= NULL;
        ListNode* prev= NULL;
        ListNode* notDup= head;
        ListNode* temp= head->next;
        int count=0;
        while(temp!=NULL){
            if(notDup->val==temp->val)
                count++;
            else{
                if(count==0){
                    if(prev==NULL){
                        prev= notDup;
                        newHead= prev;
                    }
                    else{
                        prev->next= notDup;
                        prev= notDup;
                    }                   
                }
                count= 0; 
                notDup= temp;
            }
            temp= temp->next;
        }
        if(prev==NULL && count==0 && notDup){
                prev= notDup;
                newHead= prev;
        }
        if(prev && notDup){
            if(count==0){
                prev->next= notDup;
                prev= notDup;
            }
            prev->next= NULL;
        }
        return newHead;
    }
};


