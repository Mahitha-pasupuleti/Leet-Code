/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int getLengthOfLL(Node head) {
        Node curr = head;
        int count = 0;
        while ( curr != null ) {
            ++count;
            curr = curr.next;
        }
        return count;
    }
    public int[] toArray(Node head) {
        int n = getLengthOfLL(head);
        int[] result = new int[n];
        int index = 0;
        while ( head != null ) {
            result[index++] = head.val;
            head = head.next;
        }
        return result;
    }
}