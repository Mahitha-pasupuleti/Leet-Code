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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummyhead = new ListNode(-1);
        ListNode curr = dummyhead;

        int carry = 0;
        while ( l1 != null || l2 != null ) {
            int l1Value = 0, l2Value = 0;
            if ( l1 != null ) {
                l1Value = l1.val;
            }
            if ( l2 != null ) {
                l2Value = l2.val;
            }
            int sum = l1Value + l2Value + carry;

            ListNode newNode = new ListNode( sum%10 );
            carry = sum/10;
            if ( l1 != null ) l1 = l1.next;
            if ( l2 != null ) l2 = l2.next;
            curr.next = newNode;
            curr = curr.next;
        }
        if ( carry != 0 ) {
            ListNode newNode = new ListNode(carry);
            curr.next = newNode;
            curr = curr.next;
        }
        return dummyhead.next;
        
    }
}