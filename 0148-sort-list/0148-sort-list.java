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
    public ListNode sortList(ListNode head) {
        // Sort List by using Merge List
        if ( head == null || head.next == null ) return head;
        ListNode slow = head;
        ListNode fast = head.next;

        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode leftHead = head;
        ListNode rightHead = slow.next;
        slow.next = null;

        // head - slow will be first division, slow.next - end will be our second division
        leftHead = sortList(leftHead);
        rightHead = sortList(rightHead);

        return mergeSortList(leftHead, rightHead);
        // return head;
    }
    public ListNode mergeSortList(ListNode left, ListNode right) {
        ListNode head = new ListNode(-1);
        ListNode current = head;
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
        while ( left != null ) {
            current.next = left;
            left = left.next;
            current = current.next;
        }
        while ( right != null ) {
            current.next = right;
            right = right.next;
            current = current.next;
        }
        return head.next;
    }
}