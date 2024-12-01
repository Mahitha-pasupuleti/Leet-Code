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
        
        ListNode temp = head;
        ListNode current, prev;

        while ( temp != null && temp.next != null ) {
            current = temp.next;
            while ( temp.val == current.val ) {
                prev = current;
                current = current.next;
                if ( current == null ) break;
            }
            temp.next = current;
            temp = temp.next;
        }

        return head;
    }
}