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
    // List<Integer> height = new ArrayList<>();
    boolean result = true;
    public int getSubtreeHeights(TreeNode root) {
        if ( root == null ) return 0;
        int lh = getSubtreeHeights(root.left);
        int rh = getSubtreeHeights(root.right);
        if ( Math.abs(lh-rh) > 1 ) result = false;
        // height.add(1 + Math.max(lh, rh));
        return 1 + Math.max(lh, rh);
    }
    public boolean isBalanced(TreeNode root) {
        getSubtreeHeights(root);
        // System.out.println(height);
        return result;
    }
}