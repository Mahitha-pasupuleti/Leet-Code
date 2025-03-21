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
    int min = Integer.MAX_VALUE;
    Integer prev = null;
    public void minDiff(TreeNode root) {
        if ( root == null ) return;
        minDiff(root.left);
        if ( prev != null ) {
            min = Math.min(min, Math.abs( prev - root.val ));
        }
        prev = root.val;
        minDiff(root.right);
    }
    public int minDiffInBST(TreeNode root) {
        // surely min lies between adjacent nodes - inorder
        minDiff(root);
        return min;
    }
}