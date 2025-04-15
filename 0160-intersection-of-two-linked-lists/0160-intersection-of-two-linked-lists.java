/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // no cycles

        ListNode tempA = headA;
        ListNode tempB = headB;
        int countA =0, countB = 0;

        while ( tempA != null ) {
            countA++;
            tempA = tempA.next;
        }

         while ( tempB != null ) {
            countB++;
            tempB = tempB.next;
        }

        if ( countA > countB ) {
            int diff = countA - countB;
            while ( diff != 0 ) {
                headA = headA.next;
                diff--;
            }
        } else {
            int diff = countB - countA;
            while ( diff != 0 ) {
                headB = headB.next;
                diff--;
            }
        }

        tempA = headA;
        tempB = headB;

        while ( tempA != tempB && tempA != null ) {
            tempA = tempA.next;
            tempB = tempB.next;
        }

        if ( tempA == tempB ) return tempA;
        return null;

    }
}