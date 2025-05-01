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
    boolean result = false;
    // stop traversal after result found
    // instead of global use internal variable
    // dont consider the root as leaf element
    public void inOrder(TreeNode root, int targetSum, int currentSum) {
        if ( root == null ) {
            return;
        }
        currentSum += root.val;
        if ( root.left == null && root.right == null ) {
            if ( currentSum == targetSum ) {
                result = true;
            }
        }
        inOrder(root.left, targetSum, currentSum); 
        inOrder(root.right, targetSum, currentSum); 
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if ( root == null ) return false;
        inOrder(root, targetSum, 0);
        return result;
    }
}