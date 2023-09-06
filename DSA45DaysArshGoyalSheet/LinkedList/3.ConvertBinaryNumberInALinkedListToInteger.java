
// https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/description/

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
    public int getDecimalValue(ListNode head) {
        int i = 0;
        int value = 0;
        ListNode temp = head;
        while(temp!=null && temp.next!=null){
            i+=2;
            temp = temp.next.next;
        }
        if(temp!=null && temp.next==null){
            i+=1;
        }
        while(head!=null){
            int twoPower = head.val * (int) Math.pow(2, --i);
            value+= twoPower;
            head = head.next;
        }
        return value;
    }
}