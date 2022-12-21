
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

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
        ListNode* temp=head->next;
        ListNode* notDuplicate=head;
        while(temp!=NULL){
            ListNode* delNode= NULL;
            if(temp->val!=notDuplicate->val){
                notDuplicate->next=temp;
                notDuplicate=temp;
            }else{
                delNode= temp;
            }
            temp=temp->next;
            if(delNode)
                delete delNode;
        }
        if(temp==NULL)
            notDuplicate->next=NULL;

        return head;
    }
};



