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
    public ListNode mergeTwoLists(ListNode head1, ListNode head2) {

// Recursive approach

        if ( head1 == null ) return head2;
        if ( head2 == null ) return head1;
        if ( head1.val <= head2.val ) {
            head1.next = mergeTwoLists(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeTwoLists(head1, head2.next);
            return head2;
        }

// Iterative approach
        // ListNode temp1 = head1, temp2 = head2;
        // ListNode temp = new ListNode(-1);
        // ListNode tempHead = temp;

        // while ( temp1 != null && temp2 != null ) {
        //     if ( temp1.val <= temp2.val ) {
        //         temp.next = temp1;
        //         temp1 = temp1.next;
        //     } else {
        //         temp.next = temp2;
        //         temp2 = temp2.next;
        //     }
        //     temp = temp.next;
        // }

        // while ( temp1 != null ) {
        //     temp.next = temp1;
        //     temp1 = temp1.next;
        //     temp = temp.next;
        // }

        // while ( temp2 != null ) {
        //     temp.next = temp2;
        //     temp2 = temp2.next;
        //     temp = temp.next;
        // }

        // return tempHead.next;

    }
}