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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if ( root == null ) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while ( !queue.isEmpty() ) {
            int listSize = queue.size();
            for ( int i=0; i<listSize; i++ ) {
                if ( queue.peek().left != null ) queue.add(queue.peek().left);
                if ( queue.peek().right != null ) queue.add(queue.peek().right);
                if ( i == listSize-1 ) {
                    result.add(queue.peek().val);
                }
                queue.remove();
            }
        }
        return result;
    }
}