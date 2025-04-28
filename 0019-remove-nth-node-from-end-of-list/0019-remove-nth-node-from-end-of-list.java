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
        // len of LL = 5
        // len-n+1

         // get length
         // len - n

         // temp
         // current = temp.next
         // temp.next = current.next

         // if remove head , count = 0, head = head.next
        
        if ( head.next == null ) return null;

         // length
        ListNode temp = head;
        int length = 0;
        while ( temp != null ) {
            temp = temp.next;
            length++;
        }
        // System.out.println(length);

        int removeElement = length - n;
        temp = head;

        if ( removeElement == 0 ) return head.next;

        while ( removeElement != 1 ) {
            temp = temp.next;
            removeElement--;
        }
        // ListNode current = temp.next;
        temp.next = temp.next.next;
        // current.next = null;

        return head;

    }
}