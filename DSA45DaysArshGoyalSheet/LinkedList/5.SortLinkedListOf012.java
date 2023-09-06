
// https://practice.geeksforgeeks.org/problems/given-a-linked-list-of-0s-1s-and-2s-sort-it/1

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        int zero = 0;
        int one = 0;
        int two = 0;
        Node temp = head;
        while(temp!=null){
            if(temp.data==0){
                zero++;
            }else if(temp.data==1){
                one++;
            }else{
                two++;
            }
            temp= temp.next;
        }
        temp = head;
        while(temp!=null){
            if(zero!=0){
                temp.data = 0;
                zero--;
            }else if(one!=0){
                temp.data = 1;
                one--;
            }else{
                temp.data = 2;
                two--;
            }
            temp = temp.next;
        }
        return head;
    }
}

















