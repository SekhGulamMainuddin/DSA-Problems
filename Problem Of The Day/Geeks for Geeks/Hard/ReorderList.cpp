
// https://practice.geeksforgeeks.org/problems/reorder-list/1

/* Following is the Linked list node structure */

/*
struct Node
{
    int data;
    struct Node* next;

    Node(int x){
        data = x;
        next = NULL;
    }
};
*/

class Solution{ 
public:
    void reorderList(Node* head) {
        stack<Node *>st;
        auto start=head,ptr=head;
        while(start){
            st.push(start);
            start=start->next;
        }
        
        while(ptr!=NULL and st.top()!=ptr and ptr->next!=ptr){
            auto next=ptr->next;
            ptr->next=st.top();
            st.top()->next=next;
            ptr=st.top()->next;
            st.pop();
        }
        ptr->next=NULL;
        
    }
};