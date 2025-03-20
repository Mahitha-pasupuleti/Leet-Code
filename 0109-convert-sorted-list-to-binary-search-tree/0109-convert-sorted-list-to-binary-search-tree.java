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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // TreeNode root; // if i use this not working
    public TreeNode BST(int low, int high, List<TreeNode> treeList) {
        if ( low > high ) return null;
        int mid = (low + high) / 2 ;
        TreeNode root = treeList.get(mid); // at last this is the node that gets returned
        root.left = BST(low, mid-1, treeList);
        root.right = BST(mid+1, high, treeList);
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        if ( head == null ) return null;
        
        List<TreeNode> treeList = new ArrayList();
        ListNode temp = head;
        while ( temp != null ) {
            treeList.add(new TreeNode(temp.val));
            temp = temp.next;
        }

        return BST(0, treeList.size()-1, treeList);

    }
}