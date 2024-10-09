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
    public ListNode oddEvenList(ListNode head) {
        if ( head == null || head.next == null ) return head;

        ListNode temp_odd = head, temp_even = head.next, head_even = head.next;

        while ( temp_odd != null && temp_even != null && temp_odd.next != null && temp_even.next != null ) {
            temp_odd.next = temp_even.next;
            temp_odd = temp_even.next;

            temp_even.next = temp_odd.next;
            temp_even = temp_odd.next;
        }

        temp_odd.next = head_even;

        return head;
    }
}