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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for ( int i=0; i<inorder.length; i++ ) {
            inorderMap.put(inorder[i], i);
        }

        return helper(preorder, inorderMap, 0, 0, preorder.length-1);
    }
    public TreeNode helper(int[] preorder, Map<Integer, Integer> inorderMap, int rootIndex, int left, int right) {
        TreeNode root = new TreeNode(preorder[rootIndex]);
        int mid = inorderMap.get(preorder[rootIndex]);
        if ( mid > left )
            root.left = helper(preorder, inorderMap, rootIndex+1, left, mid-1);
        if ( mid < right )
            root.right = helper(preorder, inorderMap, rootIndex+mid-left+1, mid+1, right);
        return root;
    }
}