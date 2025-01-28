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
    /**
     * Reverses the linked list starting from the given head.
     * 
     * @param head The head of the list to reverse.
     * @return The new head of the reversed list.
     */
    public ListNode reverseList(ListNode head) {
        // Base case: if the list is empty or has only one node, return the head as is.
        if (head == null || head.next == null) return head;

        ListNode temp = head;      // Pointer to traverse the list.
        ListNode prev = null;      // Pointer to keep track of the previous node.
        ListNode nextEle = temp.next; // Pointer to the next element in the list.

        // Traverse the list and reverse the links.
        while (temp != null) {
            temp.next = prev;      // Reverse the current node's link.
            prev = temp;           // Move prev to the current node.
            temp = nextEle;        // Move temp to the next node.
            if (temp != null) {    // Update nextEle if there are more nodes.
                nextEle = temp.next;
            }
        }

        return prev; // prev will be the new head of the reversed list.
    }

    /**
     * Reorders the linked list such that the nodes are arranged as:
     * first -> last -> second -> second last -> third -> ...
     * 
     * @param head The head of the list to reorder.
     */
    public void reorderList(ListNode head) {
        // Edge case: if the list is empty or has only one node, no need to reorder.
        if (head == null || head.next == null) {
            return;
        }

        // Step 1: Find the middle of the list using the slow and fast pointer approach.
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = head; // Keeps track of the node before the middle.

        while (fast != null && fast.next != null) {
            prev = slow;      // Update prev to the current slow node.
            slow = slow.next; // Move slow one step forward.
            fast = fast.next.next; // Move fast two steps forward.
        }

        prev.next = null; // Split the list into two halves by severing the connection.

        // Step 2: Reverse the second half of the list starting from the middle.
        ListNode mid = slow;
        ListNode secondHead = reverseList(mid);

        // Step 3: Merge the two halves of the list.
        ListNode temp1 = head, temp3 = temp1.next; // Pointers for the first half.
        ListNode temp2 = secondHead, temp4 = temp2.next; // Pointers for the second half.

        while (temp1 != null && temp2 != null) {
            temp1.next = temp2; // Link the current node from the first half to the current node from the second half.
            if (temp3 != null) {
                temp2.next = temp3; // Link the current node from the second half to the next node in the first half.
                // Move all pointers forward.
                temp1 = temp3;
                temp2 = temp4;
                temp3 = temp3.next;
                if (temp4 != null) temp4 = temp4.next;
            } else {
                // If there are no more nodes in the first half, terminate the loop.
                temp1 = temp3;
                temp2 = temp4;
            }
        }
    }
}
