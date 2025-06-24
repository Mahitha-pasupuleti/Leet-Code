/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
};
*/

class Solution {
    public int[] toArray(Node node) {
        Node head = null;
        Node dummy = node;
        while ( dummy.prev != null ) {
            dummy = dummy.prev;
        }
        head = dummy;

        Node curr = dummy;
        int length = 0;
        while ( curr != null ) {
            ++length;
            curr = curr.next;
        }

        int[] result = new int[length];
        curr = dummy;
        int index = 0;
        while ( curr != null ) {
            result[index++] = curr.val;
            curr = curr.next;
        }

        return result;
    }
}