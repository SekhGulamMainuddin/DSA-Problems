
// https://leetcode.com/problems/merge-k-sorted-lists/description/

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
    class compare{
        public:
            bool operator()(ListNode* node1, ListNode* node2){
                return node1->val>node2->val;
            }
    };
    ListNode* mergeKLists(vector<ListNode*>& lists) {
        if(lists.size()==0)
            return NULL;
        priority_queue<ListNode*, vector<ListNode*>, compare> minHeap;
        for(auto i : lists)
            if(i!=NULL)
                minHeap.push(i);
        
        ListNode* head= NULL;
        ListNode* tail= NULL;

        while(!minHeap.empty()){
            ListNode* top= minHeap.top();
            minHeap.pop();

            if(top->next){
                minHeap.push(top->next);
            }

            if(head==NULL){
                head= top;
                tail= top;
            }else{
                tail->next= top;
                tail= top;
            }
        }
        return head;
    }
};













