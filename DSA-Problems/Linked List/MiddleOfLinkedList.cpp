
// https://www.codingninjas.com/codestudio/problems/middle-of-linked-list_973250?source=youtube&campaign=Lovebabbarcodestudio_24thJan&utm_source=youtube&utm_medium=affiliate&utm_campaign=Lovebabbarcodestudio_24thJan

#include <bits/stdc++.h> 
#include <bits/stdc++.h> 
/****************************************************************

    Following is the class structure of the Node class:

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
int getLength(Node *head){
    int count=0;
    while(head!=NULL){
        count++;
        head=head->next;
    }
    return count;
}
Node *findMiddle(Node *head) {
    // Write your code here
    if(head==NULL || head->next==NULL)
        return head;
    int length= getLength(head);
    int mid=length/2;
//     for(int i=0;i<length;i++){
//         if(i==mid){
//             return head;
//         }
//         head= head->next;        
//     }
    int i=0;
    while(mid!=0){
        if(mid%2==0){
            head=head->next->next;
            mid=mid-2;
        }else{
            head=head->next;
            mid--;
        }
    }
    return head;
}