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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if ( root == null ) return result;

        // Seems like BFS(Level Order traversal)
        Queue<TreeNode> queue = new ArrayDeque();
        queue.add(root);

        while ( !queue.isEmpty() ) {
            int length = queue.size();
            int largeNodeValue = Integer.MIN_VALUE;
            for ( int i=0; i<length; i++ ) {
                largeNodeValue = Math.max(largeNodeValue, queue.peek().val);
                TreeNode currentNode = queue.poll();
                if ( currentNode.left != null ) queue.add(currentNode.left);
                if ( currentNode.right != null ) queue.add(currentNode.right);
            }
            result.add(largeNodeValue);
        }

        return result;
    }
}