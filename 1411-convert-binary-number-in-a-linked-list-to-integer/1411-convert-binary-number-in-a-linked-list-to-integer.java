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
    public int getDecimalValue(ListNode head) {
        
        ListNode temp1 = head, temp2 = head;
        int result = 0, count = 0;

        while ( temp1 != null ) {
            ++count;
            temp1 = temp1.next;
        }

        while ( temp2 != null ) {
            result = result + (int) ( Math.pow(2, --count) * temp2.val );
            temp2 = temp2.next;
        }

        return result;

    }
}