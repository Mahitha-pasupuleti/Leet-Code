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
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(0, preorder.length-1, preorder);
    }
    public TreeNode helper(int start, int end, int[] preorder) {
        if ( start > end ) return null;
        TreeNode root = new TreeNode(preorder[start]);
        if ( start == end ) return root;
        int mid = end + 1;
        for ( int i=start+1; i<=end; i++ ) {
            if ( root.val < preorder[i] ) {
                mid = i;
                break;
            }
        }
        // System.out.println(mid);
        root.left = helper(start+1, mid-1, preorder);
        root.right = helper(mid, end, preorder);
        return root;
    }
}