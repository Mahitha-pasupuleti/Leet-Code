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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if ( head == null ) return head;

        // Get length of the LinkedList
        ListNode temp = head;
        int count = 0;
        while ( temp != null ) {
            count++;
            temp = temp.next;
        }

        int pos = count-n+1;
        System.out.println(pos);

        // Insert at given position
        if ( pos == 1 ) return head.next;
        else if ( pos == count ) {
            ListNode current = head;
            ListNode prev = null;
            while ( current.next != null ) {
                prev = current;
                current = current.next;
            }
            prev.next = null;
        } else {
            ListNode current = head;
            ListNode prev = null;
            int x=0;
            while ( current != null ) {
                x++;
                if ( pos == x ) {
                    prev.next = current.next;
                    break;
                }
                prev = current;
                current = current.next;
            }
        }

        return head;
    }
}