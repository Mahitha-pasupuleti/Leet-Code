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
    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while ( fast.next != null && fast.next.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null, next = null;
        ListNode temp = head;

        while ( temp != null ) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return prev;
    }
    public void reorderList(ListNode head) {
        // find mid
        if ( head == null ) return;

        ListNode mid = getMid(head);
        ListNode h2 = mid.next;
        mid.next = null;

        // reverse
        h2 = reverse(h2);
        ListNode h1 = head;

        while ( h1 != null && h2 != null ) {
            ListNode n1 = h1.next;
            ListNode n2 = h2.next;
            h1.next = h2;
            h2.next = n1;
            h1 = n1;
            h2 = n2;
        }
    }
}