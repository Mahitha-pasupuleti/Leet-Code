/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int count = 0;
    TreeNode node;
    public void inorderTraversal(TreeNode root, TreeNode p) {
        if (root == null ) return;
        inorderTraversal(root.left, p);
        if ( count == 1 ) {
            node = root;
            count = 0;
        }
        if ( root.val == p.val ) count++;
        inorderTraversal(root.right, p);
    }
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        inorderTraversal(root, p);
        return node;
    }
}