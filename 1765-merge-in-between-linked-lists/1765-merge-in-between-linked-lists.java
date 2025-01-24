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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode prev = new ListNode(-1);
        prev.next = list1;
        ListNode prevHead = prev;
        ListNode temp = list1;
        ListNode first = temp;
        int count = 0;
        while ( temp != null ) {
            if ( count == a ) {
                first = prev;
                first.next = list2;
                while ( first.next != null ) {
                    first = first.next;
                }
            }
            if ( count == b ) {
                first.next = temp.next;
            }
            count++;
            prev = temp;
            temp = temp.next;
        }
        return prevHead.next;
    }
}