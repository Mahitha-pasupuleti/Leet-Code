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
    public void preorder(TreeNode root, List<Integer> rootList) {
        if ( root == null ) return;
        if ( root.left == null && root.right == null ) rootList.add(root.val);
        preorder(root.left, rootList);
        preorder(root.right, rootList);
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> root1List = new ArrayList();
        preorder(root1, root1List);

        List<Integer> root2List = new ArrayList();
        preorder(root2, root2List);

        return root1List.equals(root2List);
    }
}