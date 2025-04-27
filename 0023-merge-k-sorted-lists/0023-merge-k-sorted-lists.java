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
    public ListNode mergeKLists(ListNode[] lists) {
        if ( lists.length == 0 ) return null;
        if ( lists.length == 1 ) return lists[0];

        ListNode head = null;
        for ( int i=0; i<lists.length; i++ ) {
            head = merge(head, lists[i]);
        }
        return head;
    }
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        while ( left != null && right != null ) {
            if ( left.val <= right.val ) {
                current.next = left;
                left = left.next;
            } else {
                current.next = right;
                right = right.next;
            }
            current = current.next;
        }
        if ( left != null ) current.next = left;
        if ( right != null ) current.next = right;
        return dummy.next;
    }
}