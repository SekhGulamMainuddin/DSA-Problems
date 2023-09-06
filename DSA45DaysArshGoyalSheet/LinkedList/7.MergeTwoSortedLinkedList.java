
// https://leetcode.com/problems/merge-two-sorted-lists/description/

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode start = null;
        ListNode curr = null;
        while(list1!=null || list2!=null){
            if(list2==null || (list1!=null && list1.val<=list2.val)){
                if(start==null){
                    start = list1;
                    curr = list1;
                }else{
                    curr.next = list1;
                    curr = list1;
                }
                list1= list1.next;
            }
            else if(list1==null || (list2!=null && list2.val<=list1.val)){
                if(start==null){
                    start = list2;
                    curr = list2;
                }
                else{
                    curr.next = list2;
                    curr = list2;
                }
                list2= list2.next;
            }
        }
        return start;
    }
}