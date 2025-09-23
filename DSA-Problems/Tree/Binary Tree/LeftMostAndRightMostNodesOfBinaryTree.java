
// https://practice.geeksforgeeks.org/problems/leftmost-and-rightmost-nodes-of-binary-tree/1

/* Node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Tree
{
    public static void printCorner(Node node)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(q.size()!=0){
            int size = q.size();
            int a = -1;
            int b = -1;
            for(int i=0; i<size; i++){
                Node temp = q.peek();
                q.remove();
                if(i == 0){
                    a = temp.data;
                }else{
                    b = temp.data;
                }
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
            }
            if(a!=-1){
                System.out.print(a + " ");
            }
            if(b!=-1){
                System.out.print(b + " ");
            }
        }
    }
    
}
