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
    public void reorderList(ListNode head) {
        /*
            1 -> 2 -> 3 -> 4    7 -> 6 -> 5
                 h1   n1             h2.  n2

            1 -> 7 -> 2 -> 6 -> 3 -> 5 -> 4

            Splitting and reverse LL
            preserve some head

            head = -1;
            temp = head;
            
            while ( h1 != null && h2 != null ) {
                next1 = h1.next;
                next2 = h2.next;
                
                h1.next = h2;            1 -> 7. 2 -> 6
                temp.next = h1;          1 -> 7 -> 2 -> 6 -> 3 -> 5
                temp = h2;

                h1 = next1;
                h2 = next2;
            }

            while ( h1 != null ) temp.next = h1;


        */
        
        // // 1 -> 2 -> 3 -> 4
        //         S
        //                   F
        // // 1 -> 2 -> 3 -> 4 -> 5
        //              S
        //                   F
        // Slow - fast pointer

        if ( head == null || head.next == null ) return;

        ListNode slow = head;
        ListNode fast = head.next;

        while ( fast != null && fast.next != null ) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondList = reverse(slow.next);
        slow.next = null;

        ListNode result = new ListNode(-1);
        ListNode temp = result;

        ListNode firstList = head;

        while ( firstList != null && secondList != null ) {
            ListNode firstNext = firstList.next;
            ListNode secondNext = secondList.next;

            firstList.next = secondList;
            temp.next = firstList;
            secondList.next = null;
            temp = secondList;

            firstList = firstNext;
            secondList = secondNext;
        }

        if ( firstList != null ) temp.next = firstList;

        head = result.next;
 
    }
    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode temp = head;
        ListNode after = temp.next;

        while ( temp != null ) {
            temp.next = prev;
            prev = temp;
            temp = after;
            if ( after != null ) after = after.next;
        }

        return prev;
    }
}