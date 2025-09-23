
// https://leetcode.com/problems/split-linked-list-in-parts/description/

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
    vector<ListNode*> splitListToParts(ListNode* head, int k) {
        vector<ListNode*> result;
        int length=0;
        ListNode* temp= head;
        while(temp != NULL){
            length++;
            temp = temp->next;
        }

        temp = head;

        if(length<k){
            while(k>0){
                if(temp){
                    ListNode* addNode= temp;
                    temp= temp->next;
                    addNode->next= NULL;
                    result.push_back(addNode);
                }else{
                    result.push_back(NULL);
                }
                k--;
            }
        }
        else{
            int n= length;
            int r= length/k;
            while(true){
                if(n%k==0)
                    break;
                n--;
            }
            int diff= length-n;
            int count=0;
            ListNode* addNode= head;
            ListNode* endNode= NULL;
            while(temp!=NULL){
                count++;
                if(count==r){
                    if(diff!=0){
                        temp= temp->next;
                        endNode= temp;
                        temp= temp->next;
                        endNode->next= NULL;
                        result.push_back(addNode);
                        addNode= temp;
                        diff--;
                        count=0;
                        continue;
                    }
                    else{
                        endNode= temp;
                        temp= temp->next;
                        endNode->next= NULL;
                        result.push_back(addNode);
                        addNode= temp;
                        count=0;
                        continue;
                    }
                }
                temp=temp->next;
            }
        }


        return result;
    }
};
















