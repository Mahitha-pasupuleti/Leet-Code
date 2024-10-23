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
    public ListNode removeElements(ListNode head, int val) {

        if ( head == null ) return null;

        // if ( head.val == val ) {
        //     head = head.next;
        //     if ( head.next == null ) return null;
        // }

        // ListNode temp = head.next, prev = head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        head = prev;

        ListNode temp = head.next;

        while ( temp != null ) {     
           if ( temp.val == val ) {
            prev.next = temp.next;
           } else {
            prev = temp;
           }
           temp = temp.next;
        }

        return head.next;


        // if ( head == null ) {
        //     return head;
        // }
        // if ( head.val == val ) {
        //     if ( head.next == null ) return null;
        //     head = head.next;
        // }
        // if ( head.next == null ) {
        //     return head;
        // }
        // removeListElements(head, val);
        // return head;
    }
    // public ListNode removeListElements(ListNode head, int val) {
    //     ListNode temp = head;
    //     if ( temp == null || temp.next == null ) return head;
    //     if ( temp.next.val == val ) temp.next = temp.next.next;
    //     temp = temp.next;
    //     removeListElements(temp, val);
    //     return head;
    // }
}