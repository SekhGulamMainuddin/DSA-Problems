
// https://practice.geeksforgeeks.org/problems/d7e0ce338b11f0be36877d9c35cc8dfad6636957/1

/*
Brute Force Approach & optimized solution with explanation
Brute force approach :
Get the HEAD.
Now traverse both left and right subtree in inorder and add value in SUM variable.
Now change the data of head to SUM-previous value of head.
Do the same for left and right child.
TC :- O(n*n) - where n is the number of nodes.

 

CODE : 

class Solution {
  private:
    void subSum (Node *root, int &sum){
        if(!root)
            return;
        
        subSum(root -> left, sum);
        sum += root -> data;
        subSum(root -> right, sum);
    }
    
    
  public:
    void toSumTree(Node *node)
    {
        if(!node)
            return;
            
        int sum = -(node -> data);
        subSum(node, sum);
        node -> data = sum;
        toSumTree(node -> left);
        toSumTree(node -> right);
    }
};
 

Optimized Solution :
 

     Before moving toward optimzed solution the one thing to notice in previous solution which is while counting sum for the HEAD node you've calculated sum for every node so we'll be doing optimization at that point.

 

Approach : 
Take one variable, store the value of LEFT NODE and count the sum (recursion) for LEFT NODE.
Update the value of LEFT NODE to the counted sum.
Take another variable, store the value of RIGHT NODE and count the sum (recursion) for RIGHT NODE. 
Update the value of RIGHT NODE to the counted sum.
Now it's time for HEAD NODE.
          A. VALUE OF HEAD = sum of left subtree + sum of right subtree.

         B. left subtree = previous value of LEFT NODE + updated value of LEFT NODE.

         C. right subtree = previous value of RIGHT NODE + updated value of RIGHT NODE.

TC : O(n)—where n is the number of node

 
*/

class Solution {
  private:
    int subSum(Node *root){
        if(!root)
            return 0;
            
        int sum1 = 0;
        int sum2 = 0;
        
        if(root -> left){
            sum1 = root -> left -> data;
            root -> left -> data = subSum(root -> left);
            sum1 += root -> left -> data;
        }
        if(root -> right){
            sum2 = root -> right -> data;
            root -> right -> data = subSum(root -> right);
            sum2 += root -> right -> data;
        }
        
        root -> data = sum1+sum2;
        
        return sum1+sum2;
    }
    
    
  public:
    void toSumTree(Node *node)
    {
        subSum(node);
    }
};