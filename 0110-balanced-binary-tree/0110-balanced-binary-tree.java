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
    boolean checkIsBalanced = true;
    public int heightOfBinaryTree(TreeNode root) {
        if ( root == null ) return 0;
        int left = heightOfBinaryTree(root.left);
        int right = heightOfBinaryTree(root.right);
        if ( Math.abs(left - right) > 1 ) checkIsBalanced = false;
        return 1 + Math.max(left, right);
    }
    public boolean isBalanced(TreeNode root) {
        heightOfBinaryTree(root);
        return checkIsBalanced;
    }
}