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
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        Map<Integer, Integer> postorderMap = new HashMap<>();
        for ( int i=0; i<postorder.length; i++ ) {
            postorderMap.put(postorder[i], i);
        }
        return helper(0, preorder.length-1, 0, postorder.length-1, postorderMap, preorder, postorder);
    }
    public TreeNode helper(int preStart, int preEnd, int postStart, int postEnd, Map<Integer, Integer> postorderMap, int[] preorder, int[] postorder) {
        if ( preStart > preEnd ) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd) return root;
        
        // Find the index of the left subtree root in postorder
        int leftRootVal = preorder[preStart + 1];
        int postIndex = postorderMap.get(leftRootVal);

        // Calculate the size of the left subtree
        int leftSize = postIndex - postStart + 1;

        root.left = helper(preStart + 1, preStart + leftSize, postStart, postStart + leftSize, postorderMap, preorder, postorder);
        root.right = helper(preStart + leftSize + 1, preEnd, postIndex + 1, postEnd - 1, postorderMap, preorder, postorder);
        return root;
    }
}