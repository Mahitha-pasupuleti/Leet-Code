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
        ListNode temp = null, head = null;
        int sum, carry = 0;

        ListNode t1 = l1;
        ListNode t2 = l2;

        while ( t1 != null || t2 != null || carry > 0 ) {
            sum = 0;
            sum += carry;
            if ( t1 != null ) {
                sum += t1.val;
                t1 = t1.next;
            }
            if ( t2 != null ) {
                sum += t2.val;
                t2 = t2.next;
            }
            carry = sum/10;

            // System.out.println(sum);
            
            if ( temp == null ) {
                temp = new ListNode(sum%10, null);
                head = temp;
            } else {
                ListNode newNode = new ListNode(sum%10, null);
                temp.next = newNode;
                temp = newNode;
            }

        }

        // if ( carry > 0 ) {
        //     ListNode newNode = new ListNode(carry, null);
        //     temp.next = newNode;
        //     temp = newNode;
        // }

        return head;
    }
}