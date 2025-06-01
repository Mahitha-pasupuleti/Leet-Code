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
        /*
            2 -> 4 -> 3 -> X
            5 -> 6 -> 6 -> X
                      T
            7    0.   0.  1

            9 -> 9 -> 9 -> 9 -> 9 -> 9 -> X
            9 -> 9 -> 9 -> 9 -> X
            T.   T.   T.   T.   T.  T
            18.  19   19.  19.  10. 10  
            8.   9.   9.   9.   0.  0.  1
                                9 -> 9 -> X (1)
                                1
            ListNode tempL1, tempL2;
            int carry = 0;
            int remainder = 0;
            while ( tempL1 != null && tempL2 != null ) {
                if ( carry > 0 )
                value = tempL1.val + tempL2.val + carry; // 18
                ListNode temp = new Node(val%10) // remainder
                carry = val/10 // carry
                
                tempL1 = tempL1.next;
                tempL2 = tempL2.next;

                18 = 1 + 8
                18/10 = 1 (carry)
                18%10 = 8 (remainder) add into temp
            }
            carry = 1/0;

            if ( carry == 0)
            while ( tempL1 != null ) {
                temp.next = tempL1
            }
            while ( tempL2 != null ) {
                temp.next = tempL2
            }

            if ( carry == 1 )
            while ( tempL1 != null ) {
                if ( carry > 0 )
                newNode(tempLi + carry); // 10
                carry = val%10
            }

            carry create new node and append at last

        */

        ListNode head = new ListNode(-1);
        ListNode temp = head; // new List
        ListNode l1Head = l1, l2Head = l2;

        int carry = 0, remainder = 0;

        // 9 -> 9 -> 9 -> 9 -> 9 -> 9 -> X
        // 9 -> 9 -> 9 -> 9 -> X

        while ( l1Head != null && l2Head != null ) {
            int currVal = carry + l1Head.val + l2Head.val; // 9 + 9 + 1
            remainder = currVal%10; // 9
            carry = currVal/10; // 1
            
            ListNode current = new ListNode(remainder); // 8 -> 9 -> 9 -> 9
            temp.next = current;
            temp = temp.next;

            l1Head = l1Head.next;
            l2Head = l2Head.next;
        }

        while ( l1Head != null ) {
            int currVal = carry + l1Head.val; // 1 + 9 = 10
            remainder = currVal%10; // 0
            carry = currVal/10; // 1

            ListNode current = new ListNode(remainder); // 0
            temp.next = current; // 8 -> 9 -> 9 -> 9 -> 0 -> 0
            temp = temp.next;

            l1Head = l1Head.next;
        }

        while ( l2Head != null ) {
            int currVal = carry + l2Head.val; // 1 + 9 = 10
            remainder = currVal%10; // 0
            carry = currVal/10; // 1

            ListNode current = new ListNode(remainder); // 1
            temp.next = current;
            temp = temp.next;

            l2Head = l2Head.next;
        }

        if ( carry == 1 ) {
            ListNode current = new ListNode(carry);
            temp.next = current; // 8 -> 9 -> 9 -> 9 -> 0 -> 0 -> 1
            temp = temp.next;
        }

        return head.next;

    }
}