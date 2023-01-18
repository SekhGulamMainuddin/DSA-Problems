
// https://practice.geeksforgeeks.org/problems/44bb5287b98797782162ffe3d2201621f6343a4b/1

//User function Template for C++

/*struct Node
{
    int data;
    struct Node *next;
    Node(int x) {
        data = x;
        next = NULL;
    }

*/
class Solution
{
    public:
     //Function to find first node if the linked list has a loop.
    int findFirstNode(Node* head)
    {
        // your code here
        Node* fast= head;
        Node* slow= head;
        
        while(fast!=NULL && fast->next!=NULL){
            slow= slow->next;
            fast= fast->next->next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast)
            return -1;
        slow= head;
        while(fast!=slow){
            fast= fast->next;
            slow= slow->next;
        }
        return slow->data;
    }
};