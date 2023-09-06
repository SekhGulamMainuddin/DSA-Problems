
// https://practice.geeksforgeeks.org/problems/multiply-two-linked-lists/1?utm_source=gfg&utm_medium=article&utm_campaign=bottom_sticky_on_article

/*Node is defined as
class Node
{
    int data; 
    Node next;
    Node(int data) {
        this.data=data;
        this.next = null;
    }
}*/

class GfG{
  /*You are required to complete this method */
   public long multiplyTwoLists(Node l1,Node l2){
       long lVal1 = 0;
       long lVal2 = 0;
       long modValue = 1000000007;
       while(l1!=null){
           lVal1 = ((lVal1*10)%modValue + l1.data)%modValue;
           l1 = l1.next;
       }
       while(l2!=null){
           lVal2 = ((lVal2*10)%modValue + l2.data)%modValue;
           l2 = l2.next;
       }
       return (lVal1 * lVal2)%modValue;
   }
}




