
// https://practice.geeksforgeeks.org/problems/6cb0782855c0f11445b8d70e220f888e6ea8e22a/1

/*

class Node{
public:
    int val;
    Node *next;
    Node(int num){
        val=num;
        next=NULL;
    }
};

*/

class Solution{
public:
    bool isprime(int n)
    {
        if(n<=1)
        {
            return false;
        }
        for(int i=2;i<=sqrt(n);i++)
        {
            if(n%i==0)               
            {
                return false;
            }
        }
        return true;
    }
    int isprimeall(int n)
    {
        if(n<=1)
        {
            return 2;
        }
        int i=0;
        while(true)
        {
            if(isprime(n-i))
            {
                return n-i;
            }
            if(isprime(n+i))
            {
                return n+i;
            }
          i++;
        }
    }
    Node *primeList(Node *head){
        Node* t=head;
        while(t)
        {
             t->val=isprimeall(t->val);
             t=t->next;
        }
        return head;
    }
};