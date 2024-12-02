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
    public ListNode rotateRight(ListNode head, int k) {
        if ( head == null ) return head;

        int lenOfLL = 0;
        ListNode tempHead = head;
        while ( tempHead != null ) {
            ++lenOfLL;
            tempHead = tempHead.next;
        }

        int noOfIterations = k%lenOfLL;
        if ( noOfIterations == 0 ) return head;
        
        for ( int i=0; i<noOfIterations; i++ ) {
            ListNode temp = head, prev = head;
            while ( temp.next != null ) {
                prev = temp;
                temp = temp.next;
            }
            temp.next = head;
            prev.next = null;
            head = temp;
        }
        return head;
    }
}