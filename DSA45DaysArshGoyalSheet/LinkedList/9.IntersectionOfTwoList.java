
// https://leetcode.com/problems/intersection-of-two-linked-lists/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aNode = headA;
        ListNode bNode = headB;
        // Approach is when a pointer reaches at the end, start it again from its respective start Node and after some time it will get to the point of intersection, if they are not present then null will be the point of intersection.
        while(aNode!=bNode){
            if(aNode == null){
                aNode = headA;
            }else{
                aNode = aNode.next;
            }

            if(bNode == null){
                bNode = headB;
            }else{
                bNode = bNode.next;
            }
        }
        return aNode;
    }
}