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
    //int count = 0;
    public int good(TreeNode root, int max) {
        if ( root == null ) return 0;
        int result = (root.val >= max) ? 1 : 0;
        max = Math.max(root.val, max);
        result += good(root.left, max);
        result += good(root.right, max);
        return result;
    }
    public int goodNodes(TreeNode root) {
        int max = root.val;
        return good(root, max);
    }
}