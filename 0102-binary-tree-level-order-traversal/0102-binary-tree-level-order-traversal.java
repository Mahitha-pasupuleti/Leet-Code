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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if ( root == null ) return result;
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while ( !queue.isEmpty() ) {
            List<Integer> subResult = new ArrayList();
            int queueSize = queue.size();
            for ( int i=0; i<queueSize; i++ ) {
                TreeNode currentNode = queue.poll();
                if ( currentNode.left != null  ) queue.add( currentNode.left );
                if ( currentNode.right != null  ) queue.add( currentNode.right );
                subResult.add(currentNode.val);
            }
            result.add(subResult);
        }

        return result;
    }
}