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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        /*

            left, right
            what is left, what is right
            prev ptr before left, after ptr after right
            left(start), right(end) -> null
            reverse(start, end)
            prev.next = start
            end.next = after

            left be head
            right be tail
            start, end, prev, after

            Case A : 1 -> 2 -> 3 -> 4 -> 5 -> null, left = 2, right = 4
            1   -> 2    -> 3 -> 4   -> 5 -> null
            prev.  start.  c.   end.  after
                                null
            
            head(4 -> 3 -> 2 -> null)
            prev.next = head
            after iteration, head.next = after
            return head

            Case B : : 1 -> 2 -> 3 -> 4 -> 5 -> null, left = 1, right = 5
            prev = null, ahead = null
            dummyhead revereLL

            if ( prev == null && ahead != null )

        */

        if ( head == null || left == right ) return head;

        int count = 0;
        ListNode prev = null, start = null, end = null, after = null;
        ListNode temp = head;

        while ( temp != null ) {
            count++;
            if ( count == left-1 ) prev = temp;
            if ( count == left ) start = temp;
            if ( count == right ) {
                end = temp;
                after = end.next;
                end.next = null;
            }
            if ( start != null && end != null ) {
                ListNode dummy = reverse(start);
                // System.out.println(dummy.next.next.val);
                if ( prev != null ) prev.next = dummy;
                else head = dummy;
                start.next = after;
                break;
            }
            temp = temp.next;
        }
        return head;
    }
    // DSA : Main method has to be public, apart from it all should be private
    // null <-  2  <- 3 -> 4 -> null
    //               prev.    after
    //                   temp
    private ListNode reverse(ListNode head) {
        ListNode prev = null, temp = head, after = temp.next;
        while ( temp != null ) {
            temp.next = prev;
            prev = temp;
            temp = after;
            if ( after != null ) after = after.next;
        }
        return prev;
    }
}