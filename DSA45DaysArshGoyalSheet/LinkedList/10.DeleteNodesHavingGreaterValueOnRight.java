
// https://practice.geeksforgeeks.org/problems/delete-nodes-having-greater-value-on-right/1

class Solution
{
    Node solve(Node head, Node prev){
        if(head==null){
            return head;
        }
        Node nxt = solve(head.next, head);
        
        if(nxt==null){
            return head;
        }else{
            if(nxt.data>head.data){
                if(prev!=null){
                    prev.next= nxt;
                }
                return nxt;
            }else{
                return head;
            }
        }
    }
    
    Node compute(Node head)
    {
        return solve(head, null);
    }
}