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
    public ListNode partition(ListNode head, int x) {

        if ( head == null || head.next == null ) return head;

        ListNode temp1 = head;
        ListNode prev1Head = new ListNode(0);
        prev1Head.next = head;
        ListNode prev1 = prev1Head;

        // Move temp1 to the first node >= x, while maintaining prev1
        while ( temp1 != null && temp1.val < x ) {
            prev1 = temp1;
            temp1 = temp1.next;
        }

        // If all nodes are less than x, no rearrangement is needed
        if (temp1 == null) return head;

        ListNode temp2 = temp1.next;
        ListNode prev2 = temp1;

        while ( temp2 != null ) {
            if ( temp2.val < x ) {
                // Remove temp2 from its current position
                prev1.next = temp2;

                // Insert temp2 before temp1
                prev2.next = temp2.next;
                temp2.next = temp1;

                // Move prev1 to temp2 (newly inserted node)
                prev1 = prev1.next;

                // Advance temp2 to the next node
                temp2 = prev2.next;
            } else {
                // Advance prev2 and temp2 if no swap is needed
                prev2 = temp2;
                temp2 = temp2.next;
            }
        }

        return prev1Head.next;
    }
}