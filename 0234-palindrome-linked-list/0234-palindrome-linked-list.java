/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseLL(ListNode head) {
        ListNode temp = head;
        ListNode prev = null, front = null;
        while (temp != null) {
            front = temp.next;
            temp.next = prev;
            prev = temp;
            temp = front;
        }
        return prev;
    }

    public boolean isPalindrome(ListNode head) {

        // finding the middle - tortoise-hare pointer
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // slow gives the middle of linked list

        // reverse half of the linkedlist
        ListNode first = head;
        ListNode second = reverseLL(slow.next);

        while (second != null) {
            if (first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }

        return true;

    }
}