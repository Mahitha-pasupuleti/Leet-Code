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
    private ListNode[] reverse(ListNode head) {
        ListNode prev = null, next = null;
        ListNode temp = head;

        while ( temp != null ) {
            next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }

        return new ListNode[]{prev, head};
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if ( head == null || right - left == 0 ) return head;
        ListNode firstNode = null, lastNode = null, revFirst = null, revLast = null, prev = null;
        
        ListNode temp = head;
        int count = 1;
        while ( temp != null ) {
            if ( count == left-1 ) firstNode = temp;
            if ( count == left ) revFirst = temp;
            if ( count == right+1 ) lastNode = temp;
            if ( count == right ) revLast = temp;
            // prev = temp;
            temp = temp.next;
            count++;
        }
        if ( firstNode != null ) firstNode.next = null;
        revLast.next = null;

        ListNode[] points = reverse(revFirst);
        if ( firstNode != null ) firstNode.next = points[0];
        if ( lastNode != null ) points[1].next = lastNode;

        if ( firstNode == null ) return points[0];

        return head;
    }
    public int getLength(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while ( temp != null ) {
            temp = temp.next;
            count++;
        }
        return count;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int len = getLength(head);
        for ( int i=1; i<=len; i+=k ) {
            int end = i+k-1;
            if ( end <= len ) curr = reverseBetween(curr, i, end);
        }
        return curr;
    }
}