
// https://leetcode.com/problems/remove-duplicates-from-sorted-list/description/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null){
            return head;
        }
        ListNode startNode = head;
        ListNode previousNonRepeatedNode = head;
        head = head.next;
        while(head!=null){
            if(head.val!=previousNonRepeatedNode.val){
                previousNonRepeatedNode.next = head;
                previousNonRepeatedNode = head;
            }
            head = head.next;
        }
        previousNonRepeatedNode.next = null;
        return startNode;
    }
}