#include<iostream>
using namespace std;
struct ListNode {
    int val;
    ListNode *next;
    ListNode() : val(0), next(nullptr) {}
    ListNode(int x) : val(x), next(nullptr) {}
    ListNode(int x, ListNode *next) : val(x), next(next) {}
};
ListNode* reverseBetween(ListNode* head, int left, int right) {
        
        ListNode* temp= head;
        ListNode* prev= nullptr;
        ListNode* curr= temp;
        ListNode* next;
        
        int i=0;
        
        while(curr!=nullptr){
            
            if(i>left && i<right){
                
                next= curr->next;
                curr->next= prev;
                prev= curr;
                curr= next;
                
            }else{
                prev= curr;
                curr= curr->next;
            }
            i++;
            
        }
        
    return head;
}
int main(){
    cout>>
    return 0;
}